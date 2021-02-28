package com.dut2.colormemory;

public class User {
    private String mFirstName;
    private String mName;
    private String mMail;
    private String mPassword;

    public User(String firstName, String name, String mail, String password){
        mFirstName = firstName;
        mName = name;
        mMail = mail;
        mPassword = password;
    }

    public void addDataBase(){
        //Code d'ajout vers la bdd
    }

    public String getFirstName() {
        return mFirstName;
    }
    public String getName() {
        return mName;
    }
    public String getMail() {
        return mMail;
    }
    public String getPassword() {
        return mPassword;
    }
}
