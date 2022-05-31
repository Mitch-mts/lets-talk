package com.example.lets_talk.custom;

/**
 * @author Mitch
 * 17/10/18
 * 11:26 PM
 */
public class MessageResponse {
     String message;
     String username;

    private MessageResponse(String message, String username) {
        this.message = message;
        this.username = username;
    }

    public static MessageResponse createMessageResponse(String message, String username) {
        return new MessageResponse(message, username);
    }

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "MessageResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
