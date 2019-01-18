package org.mintleaf.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.mintleaf.common.MyExceptionResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.mintleaf.common.Realm;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器.
        Map<String, String> filterMap = new LinkedHashMap<>();
        // 配置不会被拦截的链接 顺序判断
        filterMap.put("/css/**", "anon");
        filterMap.put("/images/**", "anon");
        filterMap.put("/script/**", "anon");
        filterMap.put("/plugins/**", "anon");
        filterMap.put("/login.do", "anon");
        filterMap.put("/captcha/getCaptcha.jpg", "anon");
        filterMap.put("/upload/**", "anon");

        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterMap.put("/loginOut.do", "logout");

        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterMap.put("/**", "authc");
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login.html");


        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index.html");

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403.html");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }


    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager(myRealm());
        return defaultWebSecurityManager;
    }

    @Bean
    public Realm myRealm() {
        Realm myRealm = new Realm();
        return myRealm;
    }

    @Bean
    public HandlerExceptionResolver solver(){
        HandlerExceptionResolver handlerExceptionResolver=new MyExceptionResolver();
        return handlerExceptionResolver;
    }

}
