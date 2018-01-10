package com.pll.bittrex.dao.bittrex.impl;

import com.google.gson.Gson;
import com.pll.bittrex.dao.bittrex.BittrexApi;
import com.pll.bittrex.model.*;
import com.pll.bittrex.util.Bittrex;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Log4j
@Repository
public class BittrexApiImpl implements BittrexApi {

  private Ticker ticker;

  public Ticker getTicker() {
    return ticker;
  }

  public void setTicker(Ticker ticker) {
    this.ticker = ticker;
  }

  @Autowired
  RestTemplate restTemplate;

  @Value("${bittrex.apikey}")
  String apikey;

  @Value("${bittrex.secret}")
  String secret;

  @Value("${bittrex.getbalance.currency}")
  String currency;

  @Override
  public GetTickerResponse getTicker(GetTickerRequest req) throws Exception {

    Gson gson = new Gson();
    Bittrex wrapper = new Bittrex(apikey, secret, 3, 10);

    String response = wrapper.getTicker(req.getMarket());

    GetTickerResponse getTickerResponse = gson.fromJson(response, GetTickerResponse.class);

    if (ticker != null) {
      log.info(getTicker().toString());
    }

    setTicker(getTickerResponse.getResult());

    return getTickerResponse;

  }

  @Override public GetBalancesResponse getBalances() throws Exception {

    Gson gson = new Gson();
    Bittrex wrapper = new Bittrex(apikey, secret, 3, 10);
    Balance balances[] = new Balance[1];

    String response = wrapper.getBalance(currency);

    System.out.println(response);
    GetBalanceResponse getBalanceResponse = gson.fromJson(response, GetBalanceResponse.class);
    balances[0] = getBalanceResponse.getResult();
    return GetBalancesResponse.builder()
        .message(getBalanceResponse.getMessage())
        .success(getBalanceResponse.getSuccess())
        .result(balances)
        .build();

  }
}