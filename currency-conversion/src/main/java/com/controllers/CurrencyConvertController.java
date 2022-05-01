package com.controllers;

import com.entity.CurrencyConvertBean;
import com.proxy.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConvertController {

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @GetMapping("/currency-convert/hello")
    public String hello() {
        return "Hello Currency Exchange";
    }


    @GetMapping("/currency-convert/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConvertBean getConvertedValue(@PathVariable String from, @PathVariable String to,
                                                 @PathVariable BigDecimal quantity) {
    Map<String, String> uriVarsMAp = new HashMap<>();
    uriVarsMAp.put("from", from);
    uriVarsMAp.put("to", to);
        ResponseEntity<CurrencyConvertBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConvertBean.class, uriVarsMAp);
        CurrencyConvertBean response = responseEntity.getBody();
        return new CurrencyConvertBean(response.getId(), from, to, response.getMultiple(),
                quantity, quantity.multiply(response.getMultiple()),response.getPort());
    }

    @GetMapping("/currency-convert-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConvertBean getConvertedValueFeign(@PathVariable String from, @PathVariable String to,
                                                 @PathVariable BigDecimal quantity) {
        CurrencyConvertBean response = currencyExchangeServiceProxy.getExchangeValue(from, to);
        return new CurrencyConvertBean(response.getId(), from, to, response.getMultiple(),
                quantity, quantity.multiply(response.getMultiple()),response.getPort());
    }
}
