package com.amarpal.vix.digital.test.controller;

import com.amarpal.vix.digital.test.model.ServiceInfo;
import com.amarpal.vix.digital.test.service.CheckService;
import com.amarpal.vix.digital.test.service.ServiceInfoService;
import com.sun.org.apache.bcel.internal.generic.SIPUSH;
import java.time.Duration;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
