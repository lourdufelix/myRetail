package com.tgt.corp.finance.entity;

import java.util.SplittableRandom;

/**
 * Created by a515583 on 3/6/18.
 */
public class Price {

    private double value;
    private String currency_code;


    public Price(){}

    public Price(double value, String currency_code){
        this.value=value;
        this.currency_code=currency_code;
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }
}
