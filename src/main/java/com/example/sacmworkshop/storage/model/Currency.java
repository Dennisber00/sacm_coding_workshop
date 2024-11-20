package com.example.sacmworkshop.storage.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

/**
 * Currency.
 */
@Value
@Builder
public class Currency {

  private final String name;
  private final BigDecimal rate;
}
