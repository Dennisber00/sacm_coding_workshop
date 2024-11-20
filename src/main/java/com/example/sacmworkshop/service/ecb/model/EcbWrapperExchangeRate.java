package com.example.sacmworkshop.service.ecb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * European central bank exchange rate wrapper.
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EcbWrapperExchangeRate {
  @JsonProperty("Cube")
  List<EcbExchangeRate> ecbExchangeRates;
}