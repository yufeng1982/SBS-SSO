/**
 * 
 */
package com.oauth2.server.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author YF
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home (Map<String, Object> map) {
		return "home";
	}
	
}
