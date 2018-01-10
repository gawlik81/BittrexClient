package com.pll.bittrex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.pll.bittrex")
public class BittrexClientConfig {

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
