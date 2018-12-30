package com.zj.bloggradle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 *
 * @author 周杰
 * @date 2018/12/30
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            // 以下配置的路径都可以访问
            .antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll()
            // 以下配置的路径需要相应的角色才能访问
            .antMatchers("/users/**").hasRole("ADMIN")
            .and()
            // 基于form表单登录验证
            .formLogin()
            // 自定义登录 页面，登录失败跳转
            .loginPage("/login").failureUrl("/login-error");
    }

    /**
     * 认证信息管理
     * @return
     * @author 周杰
     * @date 2018/12/30
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // 认证信息存储于内存中
        auth
            .inMemoryAuthentication()
            .withUser("sliver")
            .password("123456")
            .roles("ADMIN");

    }
}
