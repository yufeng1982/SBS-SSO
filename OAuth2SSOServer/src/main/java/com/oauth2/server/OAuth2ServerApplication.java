/**
 * 
 */
package com.oauth2.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author YF
 *
 */

@SpringBootApplication
@ServletComponentScan // build a war need add this annotation and extends SpringBootServletInitializer
public class OAuth2ServerApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(OAuth2ServerApplication.class, args);
	}
}
