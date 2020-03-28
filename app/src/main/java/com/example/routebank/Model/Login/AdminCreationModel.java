package com.example.routebank.Model.Login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.routebank.Controller.Login.AdminCreationController;
import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.Model.DataBase.DataBaseHelper;

import java.util.ArrayList;

public class AdminCreationModel {

    DataBaseHelper dataBaseHelper;
    SQLiteDatabase db;
    AdminCreationController controller;


    public AdminCreationModel(Context context, AdminCreationController controller){
        this.controller = controller;
        dataBaseHelper = new DataBaseHelper(context);
        db = dataBaseHelper.getWritableDatabase();
    }

    public void insert(Account adminAccount) {
        ArrayList<Account> list = dataBaseHelper.search(db, adminAccount);
        if (!list.isEmpty()) {
            controller.makeToast("Username already exists");
            return;
        }
        dataBaseHelper.insert(db, adminAccount);
        controller.makeToast("Admin account created!, please Log in");
    }


}
