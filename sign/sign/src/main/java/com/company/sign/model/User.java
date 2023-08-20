package com.company.sign.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
    @Column(name="name")
    private String name;
    @Column(name="age")
    private String age;
    @Id
    @Column(name="mobile")
    private String mobile;
    @Column(name="dob")
    private String dob;
    @Column(name="gender")
    private String gender;
    @Column(name="country")
    private String country;
    @Column(name="password")
    private String password;
    public User() { }
    public User(String name, String age, String mobile, String dob,String gender, String country, String password) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.dob = dob;
        this.gender = gender;
        this.country = country;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


