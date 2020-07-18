package com.amarpal.vix.digital.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceCheckController {

  @GetMapping("/")
  public String getServiceStatus() {
    return "This is working!";
  }
  
}
