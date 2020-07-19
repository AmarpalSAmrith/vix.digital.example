package com.amarpal.vix.digital.test.component;

import com.amarpal.vix.digital.test.model.ServiceInfo;
import com.amarpal.vix.digital.test.service.CheckService;
import com.amarpal.vix.digital.test.service.ServiceInfoService;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

  private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

  @Autowired
  CheckService checkService;

  @Autowired
  ServiceInfoService serviceInfoService;

  @Scheduled(fixedRate = 60000)
  public void reportCurrentTime() throws Exception {
    LocalTime startTime = LocalTime.now();
    String url = "https://vix.digital";
    ResponseEntity<String> response = checkService.getResponse(url);
    if (!response.hasBody())
      log.warn(url + " invalid. No response body");
    long duration = Duration.between(startTime, LocalTime.now()).toMillis();
    String quality = getQuality(duration);

    ServiceInfo serviceInfo = new ServiceInfo();
    serviceInfo.setAvailability(response.hasBody());
    serviceInfo.setPerformance(duration);
    serviceInfo.setQuality(quality);
    serviceInfo.setServiceName(1);
    serviceInfoService.addServiceInfoEntry(serviceInfo);

    log.info(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
  }

  private String getQuality(long duration) {
    String quality;
    quality = "red";
    if (duration < 2000 && duration > 1000) {
      quality = "amber";
    } else if (duration <= 1000) {
      quality = "green";
    }
    return quality;
  }

}
