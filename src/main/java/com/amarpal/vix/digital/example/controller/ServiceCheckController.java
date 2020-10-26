package com.amarpal.vix.digital.example.controller;

import com.amarpal.vix.digital.example.model.ServiceInfo;
import com.amarpal.vix.digital.example.model.ServiceName;
import com.amarpal.vix.digital.example.service.CheckService;
import com.amarpal.vix.digital.example.service.ServiceInfoService;
import com.amarpal.vix.digital.example.service.ServiceNameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    @PostMapping(path = "/check-services", consumes = "application/json", produces = "application/json")
    public ServiceInfo[] checkServices(@RequestBody() ServiceName... services) {
        log.info("Check Service: " + Arrays.toString(services));
        List<ServiceInfo> serviceInfoList = new ArrayList<>();
        for (ServiceName service : services) {
            serviceInfoList.add(checkService.checkServiceInformation(service));
        }
        return serviceInfoList.toArray(new ServiceInfo[0]);
    }

    @PostMapping(path = "/add-service")
    public String addService(@ModelAttribute("url") String url) {
        String preUrl = "https://";
        if (!url.startsWith(preUrl)) {
            url = preUrl + url;
        }

        serviceNameService.addService(new ServiceName(url));
        log.info(url + " Added!");
        return "Success!! " + url + " Added!";
    }

    @GetMapping("/map")
    public Map<Integer, String> getMap() {
        return serviceNameService.getServices();
    }
}