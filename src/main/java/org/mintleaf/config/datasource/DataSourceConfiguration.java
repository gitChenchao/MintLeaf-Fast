package org.mintleaf.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.MysqlXADataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 类名称：DataSourceConfiguration<br>
 * 类描述：<br>
 * 创建时间：2019年01月03日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Slf4j
@Configuration
public class DataSourceConfiguration {
    private final Environment env;

    public DataSourceConfiguration(Environment env) {
        this.env = env;
    }

    @Bean("core")
    public DataSource core()throws Exception{
        DataSource dataSource = createAtomikosDataSource("core");
        //configPool(dataSource);
        LOGGER.debug("数据源对象初始化完成->orderbank:{}", dataSource.toString());
        return dataSource;
    }

    @Bean("book")
    public DataSource book()throws Exception{
        DataSource dataSource = createAtomikosDataSource("book");
        //configPool(dataSource);
        LOGGER.debug("数据源对象初始化完成->orderbank:{}", dataSource.toString());
        return dataSource;
    }

    private void configPool(DruidDataSource dataSource) {
        dataSource.setInitialSize(Integer.valueOf(env.getProperty("datasource.druid.initialSize")));
        dataSource.setMinIdle(Integer.valueOf(env.getProperty("datasource.druid.minIdle")));
        dataSource.setMaxActive(Integer.valueOf(env.getProperty("datasource.druid.maxActive")));
        dataSource.setMaxWait(Integer.valueOf(env.getProperty("datasource.druid.maxWait")));
        dataSource.setTimeBetweenEvictionRunsMillis(Integer.valueOf(env.getProperty("datasource.druid.timeBetweenEvictionRunsMillis")));
        dataSource.setMinEvictableIdleTimeMillis(Integer.valueOf(env.getProperty("datasource.druid.minEvictableIdleTimeMillis")));
        dataSource.setValidationQuery(env.getProperty("datasource.druid.validationQuery"));
        dataSource.setTestWhileIdle(Boolean.valueOf(env.getProperty("datasource.druid.testWhileIdle")));
        dataSource.setTestOnBorrow(Boolean.valueOf(env.getProperty("datasource.druid.testOnBorrow")));
        dataSource.setTestOnReturn(Boolean.valueOf(env.getProperty("datasource.druid.testOnReturn")));
        dataSource.setPoolPreparedStatements(Boolean.valueOf(env.getProperty("datasource.druid.poolPreparedStatements")));
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.valueOf(env.getProperty("datasource.druid.maxPoolPreparedStatementPerConnectionSize")));
        try {
            dataSource.setFilters(env.getProperty("datasource.druid.filters"));
        } catch (SQLException e) {
            LOGGER.error("druid configuration initialization filter: " + e);
        }
        dataSource.setConnectionProperties(env.getProperty("datasource.druid.connectionProperties"));
        dataSource.setUseGlobalDataSourceStat(Boolean.valueOf(env.getProperty("datasource.druid.useGlobalDataSourceStat")));
    }

    private DruidDataSource createDataSource(String dataSourceName) {
        String template = "spring.%s.%s";
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty(String.format(template, dataSourceName, "url")));
        dataSource.setUsername(env.getProperty(String.format(template, dataSourceName, "username")));
        dataSource.setPassword(env.getProperty(String.format(template, dataSourceName, "password")));
        dataSource.setDriverClassName(env.getProperty(String.format(template, dataSourceName, "driver-class-name")));
        return dataSource;
    }

    private DataSource createAtomikosDataSource(String dataSourceName) throws SQLException{
        String template = "spring.%s.%s";
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(env.getProperty(String.format(template, dataSourceName, "url")));
        mysqlXADataSource.setUser(env.getProperty(String.format(template, dataSourceName, "username")));
        mysqlXADataSource.setPassword(env.getProperty(String.format(template, dataSourceName, "password")));
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setUniqueResourceName(dataSourceName);

        xaDataSource.setMinPoolSize(Integer.valueOf(env.getProperty("atomikos.minPoolSize")));
        xaDataSource.setMaxPoolSize(Integer.valueOf(env.getProperty("atomikos.maxPoolSize")));
        xaDataSource.setMaxLifetime(Integer.valueOf(env.getProperty("atomikos.maxLifetime")));
        xaDataSource.setBorrowConnectionTimeout(Integer.valueOf(env.getProperty("atomikos.borrowConnectionTimeout")));
        xaDataSource.setLoginTimeout(Integer.valueOf(env.getProperty("atomikos.loginTimeout")));
        xaDataSource.setMaintenanceInterval(Integer.valueOf(env.getProperty("atomikos.maintenanceInterval")));
        xaDataSource.setMaxIdleTime(Integer.valueOf(env.getProperty("atomikos.maxIdleTime")));
        xaDataSource.setTestQuery(env.getProperty("atomikos.testQuery"));
        return xaDataSource;
    }
}
