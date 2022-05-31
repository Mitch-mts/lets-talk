package com.example.lets_talk.custom;

import java.util.Date;

/**
 * Created by Mitch on 14/8/2019.
 */
public class UserCreateRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String sex;
    private Date dob;
    private String emailAddress;
    private String mobileNumber;
    private Long locationId;

    private UserCreateRequest(String username,
                              String password,
                              String firstName,
                              String lastName,
                              String sex,
                              Date dob,
                              String emailAddress,
                              String mobileNumber,
                              Long locationId) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.dob = dob;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
        this.locationId = locationId;
    }

    public static UserCreateRequest createUserCreateRequest(String username,
                                                            String password,
                                                            String firstName,
                                                            String lastName,
                                                            String sex,
                                                            Date dob,
                                                            String emailAddress,
                                                            String mobileNumber,
                                                            Long locationId) {
        return new UserCreateRequest(username, password, firstName, lastName, sex, dob, emailAddress, mobileNumber, locationId);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "UserCreateRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", dob=" + dob +
                ", emailAddress='" + emailAddress + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", locationId=" + locationId +
                '}';
    }
}
