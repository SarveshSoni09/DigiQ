package com.example.digiq;

public class UserHelper {
    private String name, application_no, phone_no, email;
    private String form_fill, verified, file_created, payment, email_create;

    public UserHelper(String name, String application_no_no, String phone_no, String email, String form_fill, String verified, String file_created, String payment, String email_create) {
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

    public void setApplication_no(String app_no) {
        this.application_no = app_no;
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

    public String getForm_fill() {
        return form_fill;
    }

    public void setForm_fill(String form_fill) {
        this.form_fill = form_fill;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getFile_created() {
        return file_created;
    }

    public void setFile_created(String file_created) {
        this.file_created = file_created;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getEmail_create() {
        return email_create;
    }

    public void setEmail_create(String email_create) {
        this.email_create = email_create;
    }
}
