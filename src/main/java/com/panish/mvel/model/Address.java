package com.panish.mvel.model;

public class Address {

    private String street1;
    private String street2;

    public Address() {
    }

    public Address(String street1, String street2) {
        this.street1 = street1;
        this.street2 = street2;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }
}
