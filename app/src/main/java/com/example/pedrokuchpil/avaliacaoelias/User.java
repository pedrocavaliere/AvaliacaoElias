package com.example.pedrokuchpil.avaliacaoelias;

/**
 * Created by aiko.oliveira on 27/10/2017.
 */

public class User {


    private String userAdress;
    private String userName;
    private String userEmail;
    private String id;


    public User(String userAdress, String userName, String userEmail) {
        this.userAdress = userAdress;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public User (){
    }

    public User(String id, String userAdress, String userName, String userEmail) {
        this.id = id;
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



}
