package com.amarpal.vix.digital.example.service;

import com.amarpal.vix.digital.example.model.ServiceInfo;
import org.springframework.stereotype.Service;

@Service
public class ServiceInfoService extends DatabaseService {

  public void addServiceInfoEntry(ServiceInfo serviceInfo) {
    jdbi.withHandle(handle ->
        handle.createUpdate(
            "INSERT INTO service_info(service_name_id, availability, performance, quality) "
                + "VALUES (:serviceNameId, :availability, :performance, :quality)")
            .bind("serviceNameId", serviceInfo.getServiceName())
            .bind("availability", serviceInfo.getAvailability())
            .bind("performance", serviceInfo.getPerformance())
            .bind("quality", serviceInfo.getQuality())
            .execute());
  }

}
