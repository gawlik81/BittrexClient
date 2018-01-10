package com.pll.bittrex.dao.bittrex;

import com.pll.bittrex.model.GetBalancesResponse;
import com.pll.bittrex.model.GetTickerRequest;
import com.pll.bittrex.model.GetTickerResponse;

public interface BittrexApi {
  GetTickerResponse getTicker(GetTickerRequest req) throws Exception;
  GetBalancesResponse getBalances() throws Exception;

}
