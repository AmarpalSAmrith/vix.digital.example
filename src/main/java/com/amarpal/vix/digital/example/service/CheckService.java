package com.amarpal.vix.digital.example.service;

import static com.amarpal.vix.digital.example.values.QualityCategory.AMBER;
import static com.amarpal.vix.digital.example.values.QualityCategory.GREEN;
import static com.amarpal.vix.digital.example.values.QualityCategory.RED;

import com.amarpal.vix.digital.example.model.ServiceInfo;
import com.amarpal.vix.digital.example.model.ServiceName;
import java.net.URI;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CheckService {

  private static final Logger log = LoggerFactory.getLogger(CheckService.class);

  @Autowired
  ServiceInfoService serviceInfoService;

  @Autowired
  ServiceNameService serviceNameService;

  @Autowired
  private RestTemplate restTemplate;

  public ResponseEntity<String> getResponse(String url) throws Exception {

    ResponseEntity<String> entity = restTemplate
        .getForEntity(new URI(url), String.class);
    return entity;
  }

  public void checkServicesAndSubmit() {
    log.info(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a")));
    Map<Integer, String> serviceList = serviceNameService.getServices();
    serviceList.forEach((key, value) -> {
      try {
        checkServicesAndSubmit(new ServiceName(key, value));
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  public ServiceInfo checkServicesAndSubmit(ServiceName serviceName) {
    ServiceInfo serviceInfo = checkServiceInformation(serviceName);
    serviceInfoService.addServiceInfoEntry(serviceInfo);
    return serviceInfo;
  }

  public ServiceInfo checkServiceInformation(ServiceName serviceName) {
    if (null == serviceName.getServiceName()){
      return null;
    }
    log.info(serviceName + " : checkServiceInformation");

    LocalTime startTime = LocalTime.now();
    ResponseEntity<String> response = null;
    try {
      response = getResponse(serviceName.getServiceName());
    } catch (Exception e) {
      e.printStackTrace();
    }

    long duration = Duration.between(startTime, LocalTime.now()).toMillis();
    int quality = getQuality(duration);

    boolean hasResponse = null == response || response.hasBody();

    if (!hasResponse) {
      log.warn(serviceName + " invalid. No response body");
    }

    ServiceInfo serviceInfo = new ServiceInfo();
    serviceInfo.setAvailability(null != response && response.hasBody());
    serviceInfo.setPerformance(duration);
    serviceInfo.setQuality(quality);
    serviceInfo.setServiceName(serviceName.getId());
    return serviceInfo;
  }

  private int getQuality(long duration) {
    int quality;
    quality = RED.getId();
    if (duration < 2000 && duration > 1000) {
      quality = AMBER.getId();
    } else if (duration <= 1000) {
      quality = GREEN.getId();
    }
    return quality;
  }
}
