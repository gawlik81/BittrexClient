package com.pll.bittrex.scheduled;

import com.pll.bittrex.dao.bittrex.BittrexApi;
import com.pll.bittrex.model.GetBalancesResponse;
import com.pll.bittrex.model.GetTickerRequest;
import com.pll.bittrex.model.GetTickerResponse;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class UpdateTicker {

  @Autowired
  BittrexApi bittrexApi;

  @Scheduled(fixedRate = 10000)
  public void getTicker() throws Exception {

    GetTickerRequest getTickerRequest = GetTickerRequest.builder()
        .market("BTC-XVG")
        .build();

    GetTickerResponse getTickerResponse = bittrexApi.getTicker(getTickerRequest);

    GetBalancesResponse getBalancesResponse = bittrexApi.getBalances();

    if(getTickerResponse.getResult().getLast() > 0.000014) {
      log.info("Sprzedaję");
    }

    System.out.println(getTickerResponse);
    System.out.println(getBalancesResponse);

  }


}
