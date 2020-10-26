package com.amarpal.vix.digital.example.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceName {

  private int id;
  private String serviceName;
  private boolean enabled;

  public ServiceName(int id, String serviceName) {
    this.id = id;
    this.serviceName = serviceName;
    this.enabled = true;
  }

  public ServiceName(String serviceName) {
    this.serviceName = serviceName;
    this.enabled = true;
  }

  @Override
  public String toString() {
    return "id: " + id + " - service name: " + serviceName;
  }
}
