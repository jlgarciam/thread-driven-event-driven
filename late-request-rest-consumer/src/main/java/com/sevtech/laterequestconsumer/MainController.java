package com.sevtech.laterequestconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("spring")
public class MainController {
    @Autowired
    RestTemplate  restTemplate;

    @Value("${endpoint}")
    String endpoint;

    @GetMapping("rest")
    public String makeRequest(){
        System.out.println("REST Request");
        return "Spring MVC: " + restTemplate.getForObject(endpoint, String.class);
    }
}
