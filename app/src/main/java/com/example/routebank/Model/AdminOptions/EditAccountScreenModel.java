package com.example.routebank.Model.AdminOptions;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.Model.DataBase.DataBaseHelper;

public class EditAccountScreenModel {

    DataBaseHelper dataBaseHelper;
    SQLiteDatabase db;

    public EditAccountScreenModel(Context context){
        dataBaseHelper = new DataBaseHelper(context);
        db = dataBaseHelper.getWritableDatabase();
    }


    public void modify(Account account, String newFullName, String newUserName, String newPassword, int newType, int newBalance) {
        dataBaseHelper.editAccountInfo(db, account, newFullName, newUserName, newPassword, newType, newBalance);
    }


}
