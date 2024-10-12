package com.lazycoffee.Ch1_Introduction_To_Spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping("/helllo")
    public String sayHello() {
        return "Hello, World!";
    }
}

