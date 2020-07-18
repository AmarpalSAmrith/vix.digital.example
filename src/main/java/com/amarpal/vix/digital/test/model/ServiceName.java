package com.amarpal.vix.digital.test.model;

public class ServiceName {

  private int id;

  private String serviceName;

  public ServiceName(int id, String serviceName) {
    this.id = id;
    this.serviceName = serviceName;
  }

  public ServiceName() {
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


}
