package com.example.lets_talk.utils;


public class UserDto {
    private String username;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String dob;
    private String location;
    private String emailAddress;
    private String mobileNumber;

    public UserDto() {
    }

    public UserDto(String username,
                   String password,
                   String confirmPassword,
                   String firstName,
                   String lastName,
                   Gender gender,
                   String dob,
                   String location,
                   String emailAddress,
                   String mobileNumber) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.location = location;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
    }

    public static UserDto of(String username,
                      String password,
                      String confirmPassword,
                      String firstName,
                      String lastName,
                      Gender gender,
                      String dob,
                      String location,
                      String emailAddress,
                      String mobileNumber) {
        return new UserDto(username,
                password,
                confirmPassword,
                firstName,
                lastName,
                gender,
                dob,
                location,
                emailAddress,
                mobileNumber);
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", dob='" + dob + '\'' +
                ", location='" + location + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
