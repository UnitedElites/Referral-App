package com.example.referal_app_version2;


public class User {
    private String email;
    private String name;
    private  String gender;
    private String age;
    private String password;

    private String emer_email;
    private  String emer_phone;


    User(String email, String name, String gender, String age, String password, String emer_email, String emer_phone) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.emer_email = emer_email;
        this.emer_phone = emer_phone;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setEmer_email(String emer_email) {
        this.emer_email = emer_email;
    }

    public String getEmer_email() {
        return emer_email;
    }


    public void setEmer_phone(String emer_phone) {
        this.emer_phone = emer_phone;
    }

    public String getEmer_phone() {
        return emer_phone;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}