package com.example.sacmworkshop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Rest configuration.
 */
@Configuration
public class RestConfig {

  @Bean
  public RestTemplate restTemplate() {
    return  new RestTemplate();
  }
}
