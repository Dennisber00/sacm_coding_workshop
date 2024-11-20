package com.example.sacmworkshop.storage;

import com.example.sacmworkshop.service.ecb.model.EcbExchangeRate;
import com.example.sacmworkshop.storage.model.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * Currency im memory storage.
 */
@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CurrencyStorage {

  @Value("${app.value.currency.basic}")
  private String basicCurrencyName;

  private Map<String, Currency> currenciesByName;

  private List<String> currenciesNames;

  private Currency basicCurrency;

  protected void init(List<EcbExchangeRate> ecbRates) {
    Map<String, Currency> currencyMap = new HashMap<>();
    for (EcbExchangeRate ecbRate : ecbRates) {
      Currency currency = Currency.builder()
          .name(ecbRate.getCurrencyName().toLowerCase())
          .rate(ecbRate.getRate())
          .build();
      currencyMap.put(ecbRate.getCurrencyName().toLowerCase(), currency);
    }

    basicCurrency = Currency.builder()
        .name(basicCurrencyName)
        .rate(BigDecimal.ONE)
        .build();
    currencyMap.put(basicCurrencyName, basicCurrency);

    currenciesByName = Collections.unmodifiableMap(currencyMap);
    currenciesNames = new ArrayList<>(currencyMap.keySet());
  }

  /**
   * Loads all supported currencies.
   * @return list of currencies
   */
  public Collection<Currency> loadAll() {
    return currenciesByName.values();
  }

  /**
   * Loads all supported currencies as currency names.
   * @return list of currency names
   */
  public List<String> loadAllAsString() {
    return currenciesNames;
  }

  /**
   * Loads one currency by name.
   * @param name currency name
   * @return {@link Optional} of found currency
   * or {@link Optional} empty if not found
   */
  public Optional<Currency> findByName(String name) {
    return Optional.ofNullable(currenciesByName.get(name.toLowerCase()));
  }
}
