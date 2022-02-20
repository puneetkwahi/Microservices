package com.controllers;

import com.Configuration;
import com.entity.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsAppConfigController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfig getConfig(){
        return new LimitConfig(1000, 10);
    }

    @GetMapping("/limits-config")
    public LimitConfig getConfigProperties(){
        return new LimitConfig(configuration.getMaximum(), configuration.getMinimum());
    }
}
