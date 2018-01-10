package com.pll.bittrex.model;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class Balance {
  String Currency;
  Double Balance;
  Double Available;
  Double Pending;
  String CryptoAddress;
  Boolean Requested;
  UUID Uuid;
}