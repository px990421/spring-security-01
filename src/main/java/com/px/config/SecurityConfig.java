package com.px.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/lev1/**").hasRole("vip1")
                .antMatchers("/lev2/**").hasRole("vip2")
                .antMatchers("/lev3/**").hasRole("vip3");
        http.formLogin();
        //.loginPage("/toLogin").usernameParameter("user").passwordParameter("pwd").loginProcessingUrl("/Login")
        http.csrf().disable();
        http.logout();
        //.logoutSuccessUrl("/")
        http.rememberMe();
        //.rememberMeParameter("remember")
    }

    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}
