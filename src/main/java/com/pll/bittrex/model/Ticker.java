package com.pll.bittrex.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Ticker {
  Double Bid;
  Double Ask;
  Double Last;
}
