package com.amarpal.vix.digital.example.component;

import com.amarpal.vix.digital.example.model.ServiceInfo;
import com.amarpal.vix.digital.example.service.CheckService;
import com.amarpal.vix.digital.example.service.ServiceInfoService;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
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
  public void scheduledServiceCheck() {
    checkService.checkServicesAndSubmit();
  }



}
