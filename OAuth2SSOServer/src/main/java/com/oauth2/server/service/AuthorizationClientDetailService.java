/**
 * 
 */
package com.oauth2.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import com.oauth2.server.dao.AuthorizationClientDetailRepository;

/**
 * @author YF
 *
 */
@Service("authorizationClientDetailService")
public class AuthorizationClientDetailService implements ClientDetailsService {

	@Autowired private AuthorizationClientDetailRepository authorizationClientDetailRepository;
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		return authorizationClientDetailRepository.findByClientId(clientId);
	}

	public ClientDetails save(BaseClientDetails bcd) {
		return authorizationClientDetailRepository.save(bcd);
	}
}
