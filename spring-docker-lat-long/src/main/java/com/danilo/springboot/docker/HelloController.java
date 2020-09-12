package com.danilo.springboot.docker;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello-rest")
public class HelloController {

	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
	    HttpHeaders headers = new HttpHeaders();
	        
	    headers.add("Custom-Header-lat-long", "Hello");
	    
	    return ResponseEntity
	            .ok()
	            .headers(headers)
	            .body("Hello");
	}

}
