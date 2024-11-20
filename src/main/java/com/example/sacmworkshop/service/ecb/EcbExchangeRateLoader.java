package com.example.sacmworkshop.service.ecb;

import com.example.sacmworkshop.service.ecb.model.EcbExchangeRate;
import com.example.sacmworkshop.service.ecb.model.EcbXmlResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * European central bank exchange rate loader.
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class EcbExchangeRateLoader {

  private final RestTemplate restTemplate;
  private final EcbXmlResponseParser responseConverter;

  @Value("${app.value.ecb.rate.link}")
  private String ecbRateUrl;

  /**
   * Loads European central bank exchange rates from ECB website.
   * @return European central bank exchange rates
   */
  public List<EcbExchangeRate> load() {
    ResponseEntity<String> response = restTemplate.exchange(
        ecbRateUrl,
        HttpMethod.GET,
        HttpEntity.EMPTY,
        String.class
    );
    String xmlResponse = response.getBody();

    EcbXmlResponse ecbXmlResponse = responseConverter.fromString(xmlResponse);

    return ecbXmlResponse.getRates();
  }
}
