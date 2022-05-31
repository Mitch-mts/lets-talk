package com.example.lets_talk.custom;

public class TokenResponse {
    private String token;

    public TokenResponse() {
    }

    public TokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "TokenResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
