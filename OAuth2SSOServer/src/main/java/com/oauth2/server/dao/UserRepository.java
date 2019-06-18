/**
 * 
 */
package com.oauth2.server.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oauth2.server.model.User;

/**
 * @author YF
 *
 */
public interface UserRepository extends MongoRepository<User, String> {
	public User findByUsername(String username);
	public List<User> findByRolesCode(String code);
}
