/**
 * 
 */
package com.oauth2.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oauth2.server.dao.UserRepository;
import com.oauth2.server.model.User;

/**
 * @author YF
 *
 */
@Service("userService")
public class UserService extends BaseService implements UserDetailsService {

	@Autowired private UserRepository userRepository;
	@Autowired private PasswordEncoder passwordEncoder;
	
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<User> findByRolesCode(String code) {
		return userRepository.findByRolesCode(code);
	}
	
	public List<User> findUserByName(String name, String password) {
		return getMongoTemplate().find(new Query(Criteria.where("username").is(name).and("password").is(password)), User.class);
	}

	public User getById(String id) {
		return userRepository.findById(id).get();
	}
	
	public User save (User user) {
		encryptPassword(user);
		return userRepository.save(user);
	}
	
	private void encryptPassword(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) {
        	throw new UsernameNotFoundException(username);
        } else {
        	return user;
        }
	}
}
