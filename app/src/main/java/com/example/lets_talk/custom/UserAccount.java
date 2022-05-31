package com.example.lets_talk.custom;

import java.util.Date;

/**
 * Created by Mitch on 6/8/2019.
 */
public class UserAccount {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String sex;
    private Date dob;
    private String emailAddress;
    private String mobileNumber;
    private String location;
    private Date dateCreated;

    public UserAccount() {
    }

    private UserAccount(Long id,
                        String username,
                        String firstName,
                        String lastName,
                        String sex,
                        Date dob,
                        String emailAddress,
                        String mobileNumber,
                        String location,
                        Date dateCreated) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.dob = dob;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
        this.location = location;
        this.dateCreated = dateCreated;
    }

    public static UserAccount of(Long id,
                                 String username,
                                 String firstName,
                                 String lastName,
                                 String sex,
                                 Date dob,
                                 String emailAddress,
                                 String mobileNumber,
                                 String location,
                                 Date dateCreated) {
        return new UserAccount(id, username, firstName, lastName, sex, dob, emailAddress, mobileNumber, location, dateCreated);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", dob=" + dob +
                ", emailAddress='" + emailAddress + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", location='" + location + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
