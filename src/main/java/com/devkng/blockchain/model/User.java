package com.devkng.blockchain.model;

public class User {
    private String aadhar ;
    private int uid ;

    public User(String aadhar, int uid) {
        this.aadhar = aadhar;
        this.uid = uid;
    }

    public User() {

    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "User{" +
                "aadhar='" + aadhar + '\'' +
                ", uid=" + uid +
                '}';
    }
}
