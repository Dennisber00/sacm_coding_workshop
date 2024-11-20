package com.example.sacmworkshop.service.ecb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * European central bank XML response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EcbXmlResponse {
  @JsonProperty("Cube")
  EcbWrapperExchangeRate ecbWrapperExchangeRate;

  public List<EcbExchangeRate> getRates() {
    return ecbWrapperExchangeRate.getEcbExchangeRates();
  }
}