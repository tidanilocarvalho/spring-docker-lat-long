package com.danilo.springboot.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danilo.springboot.docker.service.Address;

@RestController
@RequestMapping("lat-long-rest")
public class LatLongController {

    @Autowired
    private Address address;
    
	@GetMapping("/seach")
	public ResponseEntity<String> serach(@RequestParam(name = "city", required = true) String city, @RequestParam(name = "amenity", required = true) String amenity) {
	    HttpHeaders headers = new HttpHeaders();
	        
	    String reponsePayload = address.getAddress(city, amenity);
	    
	    return ResponseEntity
	            .ok()
	            .headers(headers)
	            .body(reponsePayload);
	}

}
