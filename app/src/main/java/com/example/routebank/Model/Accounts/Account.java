package com.example.routebank.Model.Accounts;

import android.os.Parcel;
import android.os.Parcelable;

public class Account implements Parcelable {

    private String fullName;
    private String userName;
    private String password;
    private int type;
    private int balance;

    public Account(String fullName, String userName, String password) {
        this.fullName = fullName;
        this.userName = userName;
         this.password = password;
         this.type = 2;
         this.balance = 500;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    //------------------Parcelable Part--------------->

    //-----Ignore this part
    @Override
    public int describeContents() {
        return 0;
    }

    //-----Write your object state to a Parcel Object
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullName);
        dest.writeString(userName);
        dest.writeString(password);
        dest.writeInt(type);
        dest.writeInt(balance);
    }


    public static final Parcelable.Creator<Account> CREATOR = new Parcelable.Creator<Account>() {
        public Account createFromParcel(Parcel pc) {
            return new Account(pc);
        }
        public Admin[] newArray(int size) {
            return new Admin[size];
        }
    };

    //-----This Constructor takes a Parcel Object, and read the Object State back from it
    public Account(Parcel pc) {
        fullName = pc.readString();
        userName = pc.readString();
        password = pc.readString();
        type = pc.readInt();
        balance = pc.readInt();
    }
}
