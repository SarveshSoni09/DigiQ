package com.example.digiq;

public class UserHelper {
    String name, application_no, phone_no, email;

    public UserHelper(String name, String application_no, String phone_no, String email) {
        this.name = name;
        this.application_no = application_no;
        this.phone_no = phone_no;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApplication_no() {
        return application_no;
    }

    public void setApplication_no(String application_no) {
        this.application_no = application_no;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
