package com.spring.mongo.test;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oauth2.server.OAuth2ServerApplication;
import com.oauth2.server.dao.RoleRepository;
import com.oauth2.server.dao.UserRepository;
import com.oauth2.server.model.Role;
import com.oauth2.server.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=OAuth2ServerApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMongoDB2 {
	
	@Autowired private UserRepository userRepository;
	@Autowired private RoleRepository roleRepository;
	@Autowired private MongoTemplate mongoTemplate;
	
	/**
	 * 插入一条记录
	 */
//	@Test
	public void Test1Save(){
		User user = new User("yf","123456");
		List<Role> roles = mongoTemplate.findAll(Role.class);
		user.setRoles(roles);
		userRepository.insert(user);
		System.err.println("保存成功！");
	}
	
//	@Test
	public void Test2Save(){	
		User user = new User("fy","123456");
		user.setRoles(mongoTemplate.find(new Query(Criteria.where("code").is("r1")), Role.class));
		userRepository.insert(user);
		System.err.println("保存成功！");
	}
	
//	@Test
	public void Test3Save(){	
		User user = new User("lg","123456");
		user.setRoles(roleRepository.findByCode("r2"));
		userRepository.insert(user);
		System.err.println("保存成功！");
	}
	
	/**
	 * 查询全部User实体
	 */
//	@Test
//	public void Test3FindAll(){	
//		List<User> users = userRepository.findAll();
//		System.err.println("size: "+users.size()+","+users.get(0).getName());
//	}
	
	
//	@Test
	public void Test4Find4(){	
		List<User> users = mongoTemplate.find(new Query(Criteria.where("username").is("yf").and("password").is("123456")), User.class);
		System.err.println("size: "+users.size()+","+users.get(0).getUsername());
		users = mongoTemplate.find(new Query(Criteria.where("username").regex("yf")), User.class);
		System.err.println("size: "+users.size()+","+users.get(0).getCreateBy());
//		users = mongoTemplate.find(new Query(Criteria.where("roles.code").regex("yf","i")), User.class);
//		System.err.println("size: "+users.size()+","+users.get(0).getRoles().get(0).getCode());
		users = mongoTemplate.find(new Query(Criteria.where("username").is("yf").orOperator(Criteria.where("password").is("123456"))), User.class);
		System.err.println("size: "+users.size()+","+users.get(0).getRoles().get(0).getCode());
	}
	
	
	@Test
	public void Test4Find5(){	
		BasicQuery query = new BasicQuery("{password : \"123456\"}");
		List<User> users = mongoTemplate.find(query, User.class);
		System.err.println("size: "+users.size()+","+users.get(0).getUsername());
	}
	/**
	 * 根据name查询User
	 */
//	@Test
//	public void Test5FindByName(){	
//		List<User> users = userRepository.findByName("appleyk");
//		System.err.println("size: "+users.size());
//	}
	
	@Test
	public void Test5Update(){	
		mongoTemplate.updateMulti(new Query(Criteria.where("username").is("yf")), new Update().set("password", "098765"), User.class);
		List<User> users = mongoTemplate.find(new Query(Criteria.where("username").is("yf")), User.class);
		System.err.println("size: "+users.size()+","+users.get(0).getPassword());
	}
	
	/**
	 * 根据id删除对应User实体
	 */
//	@Test
//	public void Test6Delete(){
//		userRepository.deleteAll();
//		System.err.println("删除成功！");
//	}

}
