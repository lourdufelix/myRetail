package com.tgt.corp.finance.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxCategory {

    @JsonProperty("tax_class")
    private String taxClass;
    @JsonProperty("tax_code_id")
    private Long taxCodeId;
    @JsonProperty("tax_code")
    private String taxCode;

    //Getters and Setters

    public String getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }

    public Long getTaxCodeId() {
        return taxCodeId;
    }

    public void setTaxCodeId(Long taxCodeId) {
        this.taxCodeId = taxCodeId;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }
}
