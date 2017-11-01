package com.example.pedrokuchpil.avaliacaoelias;

/**
 * Created by aiko.oliveira on 27/10/2017.
 */

public class User {
    public User(String userAdress, String userName, String userEmail) {
        this.userAdress = userAdress;
        this.userName = userName;
        this.userEmail = userEmail;
    }

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

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    private String userAdress;
    private String userName;
    private String userEmail;

}
