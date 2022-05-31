package com.example.lets_talk.custom;

public class TokenRequest {
    private String username;
    private String password;

    private TokenRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public TokenRequest() {
    }

    public static TokenRequest createTokenRequest(String username, String password) {
        return new TokenRequest(username, password);
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
        return "TokenRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
