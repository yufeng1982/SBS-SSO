/**
 * 
 */
package com.oauth2.server.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oauth2.server.model.User;
import com.oauth2.server.service.UserService;

/**
 * @author YF
 *
 */
@Controller
@RequestMapping("/user/form")
public class UserController {

	@Autowired private UserService userService;
	
	@RequestMapping("{id}/show")
	public String show(@ModelAttribute("user") User user, Map<String, Object> map) {
		map.put("user", user);
		map.put("entityId", user.getId() == null ? "NEW" : user.getId());
		return "user";
	}
	
	@RequestMapping("{id}/save")
	public String save(@ModelAttribute("user") User user, Map<String, Object> map) {
		userService.save(user);
		map.put("user", user);
		map.put("entityId", user.getId() == null ? "NEW" : user.getId());
		return "redirect:/user/form/" + user.getId() + "/show" ;
	}
	
	@ModelAttribute("user")
	public User getEntity(@PathVariable(value = "id") String id) {
		User user = null;
		if (id == null || id.equals("NEW")) {
			user = new User();
		} else {
			user = userService.getById(id);
		}
		return user;
	}
}
