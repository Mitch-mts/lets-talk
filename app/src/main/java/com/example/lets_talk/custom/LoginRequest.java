package com.example.lets_talk.custom;

/**
 * Created by Hp on 26/2/2019.
 */
public class LoginRequest {
    private final String username;
    private final String password;

    private LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginRequest createLoginRequest(String username, String password) {
        return new LoginRequest(username, password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

