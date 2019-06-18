/**
 * 
 */
package com.oauth2.server.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

import com.oauth2.server.model.User;

/**
 * @author YF
 *
 */
@Component
public class InitDataService {

	@Autowired private UserService userService;
	@Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired private AuthorizationClientDetailService authorizationClientDetailService;
	
	@PostConstruct
	public void init() {
		User user = userService.findByUsername("yf");
		if (user == null) {
			user = new User("yf", "123456");
			userService.save(user);
		}
		
		ClientDetails cd1 = authorizationClientDetailService.loadClientByClientId("MemberSystem");
		if (cd1 == null) {
			BaseClientDetails bcd = new BaseClientDetails();
			bcd.setClientId("MemberSystem");
			bcd.setClientSecret(bCryptPasswordEncoder.encode("12345"));
			Set<String> scopeSet = new HashSet<String>();
			scopeSet.add("user-info");
			bcd.setScope(scopeSet);
			bcd.setAccessTokenValiditySeconds(60);
			Set<String> authorized_grant_types = new HashSet<String>();
			authorized_grant_types.add("authorization_code");
			bcd.setAuthorizedGrantTypes(authorized_grant_types);
			Set<String> redirect_uri = new HashSet<String>();
			redirect_uri.add("http://localhost:8081/login");
			bcd.setRegisteredRedirectUri(redirect_uri);
			Set<String> autoapprove = new HashSet<String>();
			autoapprove.add("true");
			bcd.setAutoApproveScopes(autoapprove);
			authorizationClientDetailService.save(bcd);
		}
		ClientDetails cd2 = authorizationClientDetailService.loadClientByClientId("CouponSystem");
		if (cd2 == null) {
			BaseClientDetails bcd = new BaseClientDetails();
			bcd.setClientId("CouponSystem");
			bcd.setClientSecret(bCryptPasswordEncoder.encode("12345"));
			Set<String> scopeSet = new HashSet<String>();
			scopeSet.add("user-info");
			bcd.setScope(scopeSet);
			bcd.setAccessTokenValiditySeconds(60);
			Set<String> authorized_grant_types = new HashSet<String>();
			authorized_grant_types.add("authorization_code");
			bcd.setAuthorizedGrantTypes(authorized_grant_types);
			Set<String> redirect_uri = new HashSet<String>();
			redirect_uri.add("http://localhost:8082/login");
			bcd.setRegisteredRedirectUri(redirect_uri);
			Set<String> autoapprove = new HashSet<String>();
			autoapprove.add("true");
			bcd.setAutoApproveScopes(autoapprove);
			authorizationClientDetailService.save(bcd);
		}
		
	}
	
}
