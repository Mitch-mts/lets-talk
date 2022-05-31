package com.example.lets_talk.custom;

public class ResetPasswordRequest {
    private String newPassword;
    private String confirmNewPassword;

    public ResetPasswordRequest() {
    }

    private ResetPasswordRequest(String newPassword, String confirmNewPassword) {
        this.newPassword = newPassword;
        this.confirmNewPassword = confirmNewPassword;
    }

    public static ResetPasswordRequest of(String newPassword, String confirmNewPassword) {
        return new ResetPasswordRequest(newPassword, confirmNewPassword);
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    @Override
    public String toString() {
        return "ResetPasswordRequest{" +
                "newPassword='" + newPassword + '\'' +
                ", confirmNewPassword='" + confirmNewPassword + '\'' +
                '}';
    }
}
