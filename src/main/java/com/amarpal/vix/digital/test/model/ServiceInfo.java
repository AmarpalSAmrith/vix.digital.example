package com.amarpal.vix.digital.test.model;

public class ServiceInfo {

  private int id;

  private int serviceName;

  private boolean availability;

  private long performance;

  private String quality;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getServiceName() {
    return serviceName;
  }

  public void setServiceName(int serviceName) {
    this.serviceName = serviceName;
  }

  public boolean getAvailability() {
    return availability;
  }

  public void setAvailability(boolean availability) {
    this.availability = availability;
  }

  public long getPerformance() {
    return performance;
  }

  public void setPerformance(long performance) {
    this.performance = performance;
  }

  public String getQuality() {
    return quality;
  }

  public void setQuality(String quality) {
    this.quality = quality;
  }
}
