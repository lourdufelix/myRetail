package com.tgt.corp.finance.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    @JsonProperty("tcin")
    private Long tcin;
    @JsonProperty("dpci")
    private String dpci;
    @JsonProperty("upc")
    private String upc;
    @JsonProperty("product_description")
    private ProductDescription productDescription;
    @JsonProperty("buy_url")
    private String buyUrl;
    @JsonProperty("return_method")
    private String returnMethod;
    @JsonProperty("tax_category")
    private TaxCategory taxCategory;
    @JsonProperty("package_dimensions")
    private PackageDimensions packageDimensions;

    //Getters and Setters
    public Long getTcin() {
        return tcin;
    }

    public void setTcin(Long tcin) {
        this.tcin = tcin;
    }

    public String getDpci() {
        return dpci;
    }

    public void setDpci(String dpci) {
        this.dpci = dpci;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }

    public String getBuyUrl() {
        return buyUrl;
    }

    public void setBuyUrl(String buyUrl) {
        this.buyUrl = buyUrl;
    }

    public String getReturnMethod() {
        return returnMethod;
    }

    public void setReturnMethod(String returnMethod) {
        this.returnMethod = returnMethod;
    }

    public TaxCategory getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(TaxCategory taxCategory) {
        this.taxCategory = taxCategory;
    }

    public PackageDimensions getPackageDimensions() {
        return packageDimensions;
    }

    public void setPackageDimensions(PackageDimensions packageDimensions) {
        this.packageDimensions = packageDimensions;
    }
}
