// Note : Sample API for testing Circuit Breaker for Resilience 4j 

package com.mailsonymathew.microservices.currencyexchangeservicev2.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/sample-api")
	//*** Retry - Allows us to configure teh retry attemps
	// @Retry(name = "default") // use default Retry configuration  -> will retry 3 times
	// @Retry(name="sample-api") // use this name in application.properties to configure retry count 
	//@Retry(name="sample-api", fallbackMethod = "hardCodedResponse")  // use this name in application.properties to configure retry count ;define publi method 'hardCodedResponse'
	//@CircuitBreaker(name="sample-api", fallbackMethod = "hardCodedResponse") // Circuit Breaker is used when the microservice is entirely down. After repeated attempts, circuit breaker will not call the dependant api & send a default response
	//*** CircuitBreaker - Allows us to configure the maximum number of calls allowed for a given interval
	//@RateLimiter(name="sample-api")
	//*** Bulkhead - Allows us to configure maximum concurrent calls allowd
	// @Bulkhead(name="sample-api")
	public String sampleAPI() {
		
		logger.info("Sample API call received!!!");
		
		// The following code is designed to fail as we have not defined the url. However this is required to demonstrate Circuit Breaker resilience.
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:9999/dummy-uri", String.class);  // Call fake url and return the class name
		
		
		return forEntity.getBody();
	}

	// This methodis a fallback method as defined in the @Retry annotation of the sampleAPI() method above
	public String hardCodedResponse(Exception ex) {
	//public String hardCodedResponse(RuntimeException ex) {
		return "Oops!!! Something went wrong. Please try again later...";
	}
	
}
