package com.entity;

import java.math.BigDecimal;

public class CurrencyConvertBean {

    private Long id;
    private String from;
    private String to;
    private BigDecimal multiple;
    private BigDecimal quantity;
    BigDecimal calculatedAmt;
    private int port;

    public CurrencyConvertBean() {

    }

    public CurrencyConvertBean(Long id, String from, String to, BigDecimal multiple,
                               BigDecimal quantity,int port) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.multiple = multiple;
        this.quantity = quantity;
        this.port = port;
    }

    public CurrencyConvertBean(Long id, String from, String to, BigDecimal multiple,
                                BigDecimal quantity, BigDecimal calculatedAmt, int port) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.multiple = multiple;
        this.quantity = quantity;
        this.calculatedAmt = calculatedAmt;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getMultiple() {
        return multiple;
    }

    public void setMultiple(BigDecimal multiple) {
        this.multiple = multiple;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCalculatedAmt() {
        return calculatedAmt;
    }

    public void setCalculatedAmt(BigDecimal calculatedAmt) {
        this.calculatedAmt = calculatedAmt;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
