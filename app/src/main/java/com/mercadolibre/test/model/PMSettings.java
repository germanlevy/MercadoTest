package com.mercadolibre.test.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by GL on 20/11/2015.
 */
public class PMSettings {

    @SerializedName("bin")
    private PMBin bin;

    @SerializedName("card_number")
    private PMNumber number;

    @SerializedName("security_code")
    private PMSecurityCode security_code;

    public PMBin getBin() {
        return bin;
    }

    public void setBin(PMBin bin) {
        this.bin = bin;
    }

    public PMNumber getNumber() {
        return number;
    }

    public void setNumber(PMNumber number) {
        this.number = number;
    }

    public PMSecurityCode getSecurity_code() {
        return security_code;
    }

    public void setSecurity_code(PMSecurityCode security_code) {
        this.security_code = security_code;
    }
}
