package com.amarpal.vix.digital.example.service;

import com.amarpal.vix.digital.example.model.ServiceName;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ServiceNameService extends DatabaseService {

    public Map<Integer, String> getServices() {
        return jdbi.withHandle((handle -> handle.createQuery(
                "SELECT id, service_name FROM service_name;")
                .mapToBean(ServiceName.class)
                .collect(Collectors.toMap(ServiceName::getId, ServiceName::getServiceName))
        ));
    }

    public void addService(ServiceName serviceName) {
        jdbi.withHandle(
                handle -> handle.createUpdate("INSERT INTO service_name(service_name, enabled) VALUES (:url, :enabled)")
                        .bind("url", serviceName.getServiceName())
                        .bind("enabled", serviceName.isEnabled())
                        .execute()
        );
    }

    public ServiceName getService(String name) {
        return jdbi.withHandle(handle -> handle.createQuery("SELECT id, service_name FROM service_name WHERE service_name = :name")
                .bind("name", name)
                .mapToBean(ServiceName.class)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Service Name: " + name))
        );
    }

}
