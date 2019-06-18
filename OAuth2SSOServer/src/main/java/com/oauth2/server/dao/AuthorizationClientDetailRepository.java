/**
 * 
 */
package com.oauth2.server.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Repository;

/**
 * @author YF
 *
 */
@Repository
public interface AuthorizationClientDetailRepository extends MongoRepository<BaseClientDetails, String> {

	public ClientDetails findByClientId(String clientId);
}
