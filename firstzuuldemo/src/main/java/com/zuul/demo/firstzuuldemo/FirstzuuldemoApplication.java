package com.zuul.demo.firstzuuldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zuul.demo.firstzuuldemo.entity.ErrorFilter;
import com.zuul.demo.firstzuuldemo.entity.PostFilter;
import com.zuul.demo.firstzuuldemo.entity.PreFilter;
import com.zuul.demo.firstzuuldemo.entity.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
//@EnableCircuitBreaker
public class FirstzuuldemoApplication {
	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(FirstzuuldemoApplication.class, args);
	}

	/*
	 * @Bean public PreFilter preFilter() { return new PreFilter(); }
	 * 
	 * @Bean public PostFilter postFilter() { return new PostFilter(); }
	 * 
	 * @Bean public ErrorFilter errorFilter() { return new ErrorFilter(); }
	 * 
	 * @Bean public RouteFilter routeFilter() { return new RouteFilter(); }
	 * 
	 * @RequestMapping("/callHystrix")
	 * 
	 * @HystrixCommand(fallbackMethod = "reliable") public String CallingHystrix() {
	 * ResponseEntity<String> entity =
	 * restTemplate.getForEntity("http://localhost:8080/", String.class); String
	 * result = entity.getBody(); return result; }
	 * 
	 * public String reliable() { return
	 * " CONTROL PASSED to hystrix fallback method reliable"; }
	 * 
	 */	
	@Bean
	//@Autowired
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
