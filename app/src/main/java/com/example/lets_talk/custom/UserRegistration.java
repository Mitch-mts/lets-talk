package com.example.lets_talk.custom;

/**
 * Created by Hp on 25/2/2019.
 */
public class UserRegistration {
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String password;
    private final String location;
    private final String dob;
    private final String sex;
    private final String mobileNumber;
    private final String confirmPassword;


    private UserRegistration(String username,
                             String firstName,
                             String lastName,
                             String emailAddress,
                             String password,
                             String location,
                             String dob,
                             String sex,
                             String mobileNumber,
                             String confirmPassword) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.location = location;
        this.dob = dob;
        this.sex = sex;
        this.mobileNumber = mobileNumber;
        this.confirmPassword = confirmPassword;
    }

    public static UserRegistration of(String username,
                                       String firstName,
                                       String lastName,
                                       String emailAddress,
                                       String password,
                                       String location,
                                       String dob,
                                       String sex,
                                       String mobileNumber,
                                       String confirmPassword) {
        return new UserRegistration(username,
                                    firstName,
                                    lastName,
                                    emailAddress,
                                    password,
                                    location,
                                    dob,
                                    sex,
                                    mobileNumber,
                                    confirmPassword);
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getLocation() {
        return location;
    }

    public String getDob() {
        return dob;
    }

    public String getSex() {
        return sex;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    @Override
    public String toString() {
        return "UserRegistration{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                ", dob=" + dob +
                ", sex='" + sex + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
