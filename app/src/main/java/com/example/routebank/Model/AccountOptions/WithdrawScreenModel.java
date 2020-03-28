package com.example.routebank.Model.AccountOptions;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.routebank.Controller.SessionType;
import com.example.routebank.Model.DataBase.DataBaseHelper;

public class WithdrawScreenModel {

    DataBaseHelper dataBaseHelper;
    SQLiteDatabase db;

    public WithdrawScreenModel(Context context) {
        dataBaseHelper = new DataBaseHelper(context);
        db = dataBaseHelper.getWritableDatabase();
    }


    public void withdraw(int value){

        int newBalance = SessionType.account.getBalance() - value;

        dataBaseHelper.update(db, newBalance);

    }


}
