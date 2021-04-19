package com.example.referal_app_version2;

public class CateInfo {

    private String categery;
    private String title;
    private String address;
    private String email;
    private String phone;

    public CateInfo(){

    }

    public CateInfo(String categery, String title, String address, String email, String phone) {
        this.categery = categery;
        this.title = title;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public String getCategery() {
        return categery;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setCategery(String categery) {
        this.categery = categery;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
