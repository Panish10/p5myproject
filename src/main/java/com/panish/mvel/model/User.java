package com.panish.mvel.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String fname;
    private String lname;
    private List<Address> addressList = new ArrayList<>();

    public User() { }

    public User(String fname, String lname, List<Address> addressList) {
        this.fname = fname;
        this.lname = lname;
        this.addressList = addressList;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "User{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", addressList=" + addressList +
                '}';
    }
}
