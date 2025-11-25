package com.electricity.models.users;

public class Operator extends User {
    private String region;
    private String employeeNumber;

    public Operator(String userId, String username, String password, String email, String region,
            String employeeNumber) {
        super(userId, username, password, email, "Operator");
        this.region = region;
        this.employeeNumber = employeeNumber;
    }

    public String getRegion() {
        return region;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}
