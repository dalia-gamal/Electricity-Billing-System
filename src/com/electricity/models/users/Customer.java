package com.electricity.models.users;

public class Customer extends User {
    private String meterNumber;
    private String address;
    private String phoneNumber;

    public Customer(String userId, String username, String password, String email, String meterNumber, String address,
            String phoneNumber) {
        super(userId, username, password, email, "Customer");
        this.meterNumber = meterNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
