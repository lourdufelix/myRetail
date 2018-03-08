package com.tgt.corp.finance.entity;

import org.springframework.lang.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.SplittableRandom;

/**
 * Created by a515583 on 3/6/18.
 */
public class Price {

    @Valid
    @NonNull
    @Min(0)
    private double value;

    @Valid
    @Pattern.List({@Pattern(regexp = "USD", message = "only accepts USD")})
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
