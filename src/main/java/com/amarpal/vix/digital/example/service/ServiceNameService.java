package com.amarpal.vix.digital.example.service;

import com.amarpal.vix.digital.example.model.ServiceName;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ServiceNameService extends DatabaseService {

  public Map<Integer, String> getServices() {
    return jdbi.withHandle((handle -> handle.createQuery(
        "SELECT id, service_name FROM service_name;")
        .mapToBean(ServiceName.class)
        .collect(Collectors.toMap(ServiceName::getId, ServiceName::getServiceName))
    ));
  }

  public void addService(String serviceURL) {
    jdbi.withHandle(
        handle -> handle.createUpdate("INSERT INTO service_name(service_name) VALUES (:url)")
            .bind("url", serviceURL)
            .execute()
    );
  }

}
