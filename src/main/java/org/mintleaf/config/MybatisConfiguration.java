package org.mintleaf.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 类名称：MybatisConfiguration<br>
 * 类描述：<br>
 * 创建时间：2019年01月03日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Configuration
@ConditionalOnClass({ SqlSessionFactory.class, SqlSessionFactoryBean.class })
public class MybatisConfiguration {

    @Configuration
    @MapperScan(basePackages = {"org.mintleaf.modules.core.mapper"},
            sqlSessionFactoryRef = "coreSqlSessionFactory")
    public static class CoreMybatisConfig {
        private final DataSource dataSource;

        public CoreMybatisConfig(@Qualifier("core") DataSource dataSource) {
            this.dataSource = dataSource;
        }

        @Bean("coreSqlSessionFactory")
        public SqlSessionFactory coreSqlSessionFactory(PageHelper pageHelper) throws Exception {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                    .getResources("classpath:/modules/core/mapper/*.xml"));
            factoryBean.setDataSource(dataSource);
            //factoryBean.setConfigLocation(new ClassPathResource("/mybatis/mybatis-config.xml"));
            //添加分页插件
            Interceptor[] plugins = new Interceptor[]{pageHelper};
            factoryBean.setPlugins(plugins);
            return factoryBean.getObject();
        }

        @Bean
        public SqlSessionTemplate coreSqlSessionTemplate(PageHelper pageHelper) throws Exception {
            return new SqlSessionTemplate(coreSqlSessionFactory(pageHelper));


        /*@Bean("coreTransactionManager")
        public PlatformTransactionManager coreTransactionManager() {
            return new DataSourceTransactionManager(dataSource);
        }*/
        }

        @Configuration
        @MapperScan(basePackages = {"org.mintleaf.modules.book.mapper"},
                sqlSessionFactoryRef = "bookSqlSessionFactory")
        public static class BookMybatisConfig {
            private final DataSource dataSource;

            public BookMybatisConfig(@Qualifier("book") DataSource dataSource) {
                this.dataSource = dataSource;
            }

            @Bean("bookSqlSessionFactory")
            public SqlSessionFactory bookSqlSessionFactory(PageHelper pageHelper) throws Exception {
                SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
                factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                        .getResources("classpath:/modules/book/mapper/*.xml"));
                factoryBean.setDataSource(dataSource);
                //factoryBean.setConfigLocation(new ClassPathResource("/mybatis/mybatis-config.xml"));
                //添加分页插件
                Interceptor[] plugins = new Interceptor[]{pageHelper};
                factoryBean.setPlugins(plugins);
                return factoryBean.getObject();
            }

            @Bean
            public SqlSessionTemplate bookSqlSessionTemplate(@Qualifier("pageHelper") PageHelper pageHelper) throws Exception {
                return new SqlSessionTemplate(bookSqlSessionFactory(pageHelper));
            }

        /*@Primary
        @Bean("bookTransactionManager")
        public PlatformTransactionManager bookTransactionManager() {
            return new DataSourceTransactionManager(dataSource);
        }*/
        }
    }
}
