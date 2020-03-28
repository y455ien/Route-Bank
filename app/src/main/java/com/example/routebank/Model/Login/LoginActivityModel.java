package com.example.routebank.Model.Login;

import android.database.sqlite.SQLiteDatabase;

import com.example.routebank.Controller.Login.LoginActivityController;
import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.Model.DataBase.DataBaseHelper;

public class LoginActivityModel {

    LoginActivityController controller;
    DataBaseHelper dataBaseHelper;
    SQLiteDatabase db;

    public LoginActivityModel(LoginActivityController controller) {
        this.controller = controller;
        dataBaseHelper = new DataBaseHelper(controller.getContext());
        db = dataBaseHelper.getReadableDatabase();
    }

    public Account login(String userName, String password) {
        Account account = dataBaseHelper.login(db, userName);

        if (account == null) {
            controller.makeToast("Account does not exist");
            return null;
        }

        String accountPassword = account.getPassword();

        if (!accountPassword.equals(password)) {

            controller.makeToast("Wrong Password");
            return null;

        }

        return account;


    }
}
