package com.controllers;

import com.dao.ExchangeValueRepository;
import com.entity.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment env;

    @Autowired
    ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/hello")
    public String hello() {
        return "Hello Currency Exchange";
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
                //new ExchangeValue(1000L, "from", "to", BigDecimal.valueOf(65));
        exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        return exchangeValue;
    }
}
