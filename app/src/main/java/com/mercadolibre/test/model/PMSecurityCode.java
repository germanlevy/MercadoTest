package com.mercadolibre.test.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by GL on 20/11/2015.
 */
public class PMSecurityCode {

    @SerializedName("type")
    private String type;

    @SerializedName("length")
    private int length;

    @SerializedName("card_location")
    private String card_location;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getCard_location() {
        return card_location;
    }

    public void setCard_location(String card_location) {
        this.card_location = card_location;
    }
}
