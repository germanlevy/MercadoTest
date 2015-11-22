package com.mercadolibre.test.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by GL on 20/11/2015.
 */
public class PMNumber {

    @SerializedName("length")
    private String length;

    @SerializedName("validation")
    private String validation;

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }
}
