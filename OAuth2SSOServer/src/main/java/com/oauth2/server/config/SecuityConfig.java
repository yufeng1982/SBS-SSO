package com.oauth2.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.oauth2.server.service.UserService;

@Configuration
@EnableWebSecurity
public class SecuityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired private UserService userService;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/oauth/**", "/login","/logout").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		http.authorizeRequests().and().rememberMe().userDetailsService(userService);
		http.formLogin().loginPage("/login");
    }
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**");
    }
}
