package com.pll.bittrex.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GetTickerRequest {
  String market;
}
