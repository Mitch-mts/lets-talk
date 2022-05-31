package com.example.lets_talk.custom;

/**
 * Created by Mitch on 23/4/2019.
 */
public class UserLoginRequest {
    String username;
    String password;

    public UserLoginRequest() {
    }

    private UserLoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static UserLoginRequest createUserLoginRequest(String username, String password) {
        return new UserLoginRequest(username, password);
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

    @Override
    public String toString() {
        return "UserLoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
