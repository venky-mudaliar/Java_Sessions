
package com.lazycoffee.Sec2_Building_RESTful_Services_with_Spring.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PublicController {

	@GetMapping("/api/public/")
	public String getPublicInformation() {
		
		String publicDomanInformaiton = "This API contains methods to work on Users Database.";
		
		return publicDomanInformaiton;
	}
	
}
