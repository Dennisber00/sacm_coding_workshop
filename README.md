# SACM coding workshop

## Description:
We are going to download current exchange rates from European Central Bank. 
This is an XML file where all exchange rates are based on EUR, for example, 
EUR - USD, EUR - GBP, etc. Based on exchange rates a few APIs are needed 
to be built (see TODO section)

Because this file in XML format i would like to simplify our task and 
have already written `com.example.sacmworkshop.service.ecb.EcbExchangeRateLoader` 
which can load and process this XML into `List<EcbExchangeRate>`

I want to avoid any DB, because of it I create `com.example.sacmworkshop.storage.CurrencyStorage`

## Our goals / TODO:
- Provide the following APIs (at least 2 + statistics)
  - "/v1/stat" - request statistics in "<CURRENCY> - <NUMBER_OF_REQUESTS>" form
  - "/v1/exchange/rate/<IN_CURRENCY>/<OUT_CURRENCY>" exchange rate for any combination (USD-EUR or USD-GBP, etc) of available currencies in ECB file.
  - "/v1/exchange/<IN_CURRENCY>/<AMOUNT>/<OUT_CURRENCY>/<AMOUNT>" exchange calculation for any combination (USD-EUR or USD-GBP, etc) of available currencies in ECB file.
  - "/v1/currency/supported" - list of supported currencies (which are in ECB file)
  - "/v1/ecb/graphlink/<CURRENCY>" return link to ECB currency graph. Link samples:
    - https://www.ecb.europa.eu/stats/policy_and_exchange_rates/euro_reference_exchange_rates/html/eurofxref-graph-usd.en.html
    - https://www.ecb.europa.eu/stats/policy_and_exchange_rates/euro_reference_exchange_rates/html/eurofxref-graph-gbp.en.html