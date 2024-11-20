package com.example.sacmworkshop.service.ecb;

import com.example.sacmworkshop.service.ecb.model.EcbXmlResponse;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

/**
 * European central bank XML response parser.
 */
@Component
public class EcbXmlResponseParser {

  private static final XmlMapper XML_MAPPER = new XmlMapper();

  /**
   * Parses response as xml string into {@link EcbXmlResponse} object.
   * @param input Ecb response as string
   * @return EcbXmlResponse
   */
  @SneakyThrows
  public EcbXmlResponse fromString(String input) {
    return XML_MAPPER.readValue(input, EcbXmlResponse.class);
  }

}
