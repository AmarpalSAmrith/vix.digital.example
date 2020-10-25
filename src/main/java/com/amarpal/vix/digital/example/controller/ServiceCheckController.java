package com.amarpal.vix.digital.example.controller;

import com.amarpal.vix.digital.example.model.ServiceInfo;
import com.amarpal.vix.digital.example.model.ServiceName;
import com.amarpal.vix.digital.example.service.CheckService;
import com.amarpal.vix.digital.example.service.ServiceInfoService;
import com.amarpal.vix.digital.example.service.ServiceNameService;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceCheckController {

  private static final Logger log = LoggerFactory.getLogger(ServiceCheckController.class);

  @Autowired
  CheckService checkService;

  @Autowired
  ServiceInfoService serviceInfoService;

  @Autowired
  ServiceNameService serviceNameService;

  @GetMapping("/")
  public String getServiceStatus() {
    return "This is working!";
  }

  @PostMapping(path = "/check-service", consumes = "application/json", produces = "application/json")
  public ServiceInfo checkService(@RequestBody() ServiceName service) {
    log.info("Check Service: " + service.toString());
    return checkService.checkServiceInformation(service);
  }

  @PostMapping(path="/add-service", consumes = "application/json", produces = "application/json")
  public String addService(@ModelAttribute("url") String url){
    String preUrl = "https://";
    if (!url.startsWith(preUrl)) {
      url = preUrl + url;
    }
    serviceNameService.addService(url);
    return "Success!! " + url + " Added!";
  }

  @GetMapping("/map")
  public Map<Integer, String> getMap() {
    return serviceNameService.getServices();
  }
}
