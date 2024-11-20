package com.example.sacmworkshop.service.ecb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * European central bank exchange rate.
 */
@Getter
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EcbExchangeRate {
  @JsonProperty("currency")
  String currencyName;
  @JsonProperty("rate")
  BigDecimal rate;
}
