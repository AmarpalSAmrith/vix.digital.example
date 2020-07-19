package com.amarpal.vix.digital.test.service;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CheckService {

  @Autowired
  private RestTemplate restTemplate;

  public ResponseEntity<String> getResponse(String url) throws Exception {

    ResponseEntity<String> entity = restTemplate
        .getForEntity(new URI(url), String.class);
//    ResponseEntity<String> entity3 = restTemplate.getForEntity(new URI("http://vix.digital"),String.class);
    return entity;
  }

}
