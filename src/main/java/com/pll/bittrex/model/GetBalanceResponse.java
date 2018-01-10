package com.pll.bittrex.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class GetBalanceResponse {
  Boolean success;
  String message;
  Balance result;
}
