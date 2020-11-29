package com.example.digiq;

public class UserHelper {
    String name, application_no, phone_no, email;
    char form_fill, verified, file_created, payment, email_create;

    public UserHelper(String name, String application_no, String phone_no, String email, char form_fill, char verified, char file_created, char payment, char email_create) {
        this.name = name;
        this.application_no = application_no;
        this.phone_no = phone_no;
        this.email = email;
        this.form_fill = form_fill;
        this.verified = verified;
        this.file_created = file_created;
        this.payment = payment;
        this.email_create = email_create;
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

    public char getForm_fill() {
        return form_fill;
    }

    public void setForm_fill(char form_fill) {
        this.form_fill = form_fill;
    }

    public char getVerified() {
        return verified;
    }

    public void setVerified(char verified) {
        this.verified = verified;
    }

    public char getFile_created() {
        return file_created;
    }

    public void setFile_created(char file_created) {
        this.file_created = file_created;
    }

    public char getPayment() {
        return payment;
    }

    public void setPayment(char payment) {
        this.payment = payment;
    }

    public char getEmail_create() {
        return email_create;
    }

    public void setEmail_create(char email_create) {
        this.email_create = email_create;
    }
}
