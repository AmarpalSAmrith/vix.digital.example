package com.amarpal.vix.digital.example.controller;

import com.amarpal.vix.digital.example.model.ServiceInfo;
import com.amarpal.vix.digital.example.service.CheckService;
import com.amarpal.vix.digital.example.service.ServiceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceCheckController {

  @Autowired
  CheckService checkService;

  @Autowired
  ServiceInfoService serviceInfoService;

  @GetMapping("/")
  public String getServiceStatus() {
    return "This is working!";
  }

  @GetMapping("/check-service")
  public ServiceInfo checkService() throws Exception {

    return new ServiceInfo();
  }
}
