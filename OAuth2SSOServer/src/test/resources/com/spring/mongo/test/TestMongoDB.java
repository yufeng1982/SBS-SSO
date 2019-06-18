package com.spring.mongo.test;

import java.time.LocalDate;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oauth2.server.OAuth2ServerApplication;
import com.oauth2.server.model.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=OAuth2ServerApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMongoDB {
	
	@Autowired private MongoTemplate mongoTemplate;
	
	/**
	 * 插入一条记录
	 */
	@Test
	public void Test1Save(){	
		Role role1 = new Role();
		role1.setCode("r1");
		role1.setDesc("role1");
		role1.setFunctionNodeIds("K001,L002");
		role1.setResources("aa,bb,cc");
		role1.setCreateBy("admin");
		role1.setCreationDate(LocalDate.now());
		role1.setModifiedBy("admin");
		role1.setModifiedDate(LocalDate.now());
		Role role2 = new Role();
		role2.setCode("r2");
		role2.setDesc("role2");
		role2.setFunctionNodeIds("K003,L004");
		role2.setResources("dd,ee,ff");
		role2.setCreateBy("admin");
		role2.setCreationDate(LocalDate.now());
		role2.setModifiedBy("admin");
		role2.setModifiedDate(LocalDate.now());
		mongoTemplate.insert(role1);
		mongoTemplate.insert(role2);
		System.err.println("保存成功！");
	}
//	@Test
//	public void Test3FindAll(){	
//		List<Role> roles = mongoTemplate.findAll(Role.class);
//		System.err.println("size: "+roles.size()+","+roles.get(0).getCode());
//	}

}
