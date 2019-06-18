/**
 * 
 */
package com.oauth2.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author YF
 *
 */
public abstract class BaseService {

	@Autowired private MongoTemplate  mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

}
