package com.amarpal.vix.digital.example.model;

public class ServiceName {

  private int id;
  private String serviceName;

  public ServiceName() {}

  public ServiceName(int id, String serviceName) {
    this.id = id;
    this.serviceName = serviceName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  @Override
  public String toString() {
    return "id: " + id + " - service name: " + serviceName;
  }
}
