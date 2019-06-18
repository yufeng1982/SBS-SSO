/**
 * 
 */
package com.oauth2.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import com.oauth2.server.service.AuthorizationClientDetailService;

/**
 * @author YF
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired private AuthorizationClientDetailService authorizationClientDetailService;
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		super.configure(security);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(authorizationClientDetailService);
//		clients.inMemory().withClient("MemberSystem").scopes("user-info").
//							secret(passwordEncoder().encode("12345")).redirectUris("http://localhost:8081/login").authorizedGrantTypes("authorization_code")
//							.accessTokenValiditySeconds(60).autoApprove(true)
//				.and().withClient("CouponSystem").scopes("user-info").
//							secret(passwordEncoder().encode("12345")).redirectUris("http://localhost:8082/login").authorizedGrantTypes("authorization_code")
//							.accessTokenValiditySeconds(60).autoApprove(true);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		super.configure(endpoints);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
