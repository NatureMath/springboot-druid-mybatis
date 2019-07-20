package com.atguigu.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author huct
 * @Date 2019/7/20 - 15:10
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String, String> initparams=new HashMap<>();
        initparams.put("loginUsername", "admin");
        initparams.put("loginPassword", "123456");
        initparams.put("allow", "");
        //initparams.put("deny", "");
        bean.setInitParameters(initparams);
        return bean;
    }

    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        Map<String, String> initparams=new HashMap<>();
        initparams.put("exclusions", "*.js, *.css,/druid/*");
        bean.setFilter(new WebStatFilter());
        bean.setInitParameters(initparams);
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;

    }
}
