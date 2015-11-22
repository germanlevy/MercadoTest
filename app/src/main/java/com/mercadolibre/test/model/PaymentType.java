package com.mercadolibre.test.model;

/**
 * Created by GL on 20/11/2015.
 */
public enum PaymentType {

    CC("credit_card", "Credit Card"),
    TK("ticket", "Ticket"),
    ATM("atm", "ATM");

    public String id;
    public String name;

    PaymentType(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
