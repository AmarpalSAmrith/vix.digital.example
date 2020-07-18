package com.amarpal.vix.digital.test.model;

public class ServiceInfo {

  private int id;

  private String availability;

  private String performance;

  private String quality;

  public ServiceInfo() {
  }

  public ServiceInfo(int id, String availability, String performance, String quality) {
    this.id = id;
    this.availability = availability;
    this.performance = performance;
    this.quality = quality;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAvailability() {
    return availability;
  }

  public void setAvailability(String availability) {
    this.availability = availability;
  }

  public String getPerformance() {
    return performance;
  }

  public void setPerformance(String performance) {
    this.performance = performance;
  }

  public String getQuality() {
    return quality;
  }

  public void setQuality(String quality) {
    this.quality = quality;
  }
}
