package com.example.bct.Ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "User_Table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd" , timezone = "Asia/Kolkata")
    private Date dob;

    private String gender;

    @Column(name = "user_address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "user_phone")
    private String phoneNo;

    @Column(name = "user_email", unique=true, nullable = false)
    private String email;

    @Column(name = "created_on")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd" , timezone = "Asia/Kolkata")
    private Date createdOn;

    @Column(name = "updated_on")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd" , timezone = "Asia/Kolkata")
    private Date updatedOn;

    boolean isDeleted;

    @Column(name = "user_active")
    @JsonProperty
    boolean userActive;

    String userRole;

    String password;

    public User() {
    }

    public User(String firstName, String lastName, Date dob, String gender, String address, String city, String zipCode, String phoneNo, String email, Date createdOn, Date updatedOn, boolean isDeleted, String userRole, boolean userActive, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNo = phoneNo;
        this.email = email;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.isDeleted = isDeleted;
        this.userRole = userRole;
        this.userActive = userActive;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean getUserActive() {
        return userActive;
    }

    public void setUserActive(boolean userActive) {
        this.userActive = userActive;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", isDeleted=" + isDeleted +
                ", userRole='" + userRole + '\'' +
                ", userActive='" + userActive + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
