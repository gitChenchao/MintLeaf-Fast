package org.mintleaf.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * 类名称：PageHelperConfig<br>
 * 类描述：<br>
 * 创建时间：2018年12月25日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Configuration
@Component
public class PageHelperConfig {
    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        //配置mysql数据库的方言
        properties.setProperty("dialect", "mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
