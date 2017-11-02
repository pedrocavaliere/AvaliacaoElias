package com.example.pedrokuchpil.avaliacaoelias;

/**
 * Created by aiko.oliveira on 27/10/2017.
 */

public class User {


    private String userAdress;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String id;


    public User(String userName, String userEmail, String userAdress,  String userPhone) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAdress = userAdress;
        this.userPhone = userPhone;
    }

    public User (){
    }

    public User(String id, String userName, String userEmail, String userAdress, String userPhone) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAdress = userAdress;
        this.userPhone = userPhone;
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

    public String getUserPhone(){
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }


}
