/**
 * 
 */
package com.oauth2.server.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oauth2.server.model.Role;

/**
 * @author YF
 *
 */
public interface RoleRepository extends MongoRepository<Role, String> {
	List<Role> findByCode(String code);
}
