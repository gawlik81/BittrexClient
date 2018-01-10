package com.pll.bittrex.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GetTickerResponse {
  Boolean success;
  String message;
  Ticker result;
}
