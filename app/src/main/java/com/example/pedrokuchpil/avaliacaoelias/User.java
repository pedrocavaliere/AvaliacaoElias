package com.example.pedrokuchpil.avaliacaoelias;

/**
 * Created by aiko.oliveira on 27/10/2017.
 */

public class User {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    private String userName, userEmail;
}
