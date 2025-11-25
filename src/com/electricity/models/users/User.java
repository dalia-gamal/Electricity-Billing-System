package com.electricity.models.users;

// كلاس أساسي لكل أنواع المستخدمين
public class User {
    protected String userId; // رقم المستخدم
    protected String username; // اسم المستخدم
    protected String password; // كلمة المرور
    protected String email; // البريد الإلكتروني
    protected String userType; // نوع المستخدم: Customer, Operator, Admin

    // Constructor
    public User(String userId, String username, String password, String email, String userType) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    // Getter and Setter لكل الخصائص
    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
