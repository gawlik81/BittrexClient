package com.pll.bittrex.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GetBalancesResponse {
  Boolean success;
  String message;
  Balance result[];
}
