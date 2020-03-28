package com.example.routebank.Model.AccountOptions;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.Model.Accounts.Admin;
import com.example.routebank.Model.DataBase.DataBaseHelper;

import java.util.ArrayList;

public class TranseferScreenModel {

    DataBaseHelper dataBaseHelper;
    SQLiteDatabase db;

    public TranseferScreenModel(Context context) {
        dataBaseHelper = new DataBaseHelper(context);
        db = dataBaseHelper.getWritableDatabase();

    }

    public Boolean transefer(String userName, int amount){

        Account temp = new Account(null, userName, null);
        ArrayList<Account> queryList = dataBaseHelper.search(db, temp);

        if (queryList.isEmpty()) {
            return false;
        }

        temp = queryList.get(0);
        int oldBalance = temp.getBalance();

        dataBaseHelper.transefer(db, userName, amount,oldBalance);
        return true;


    }

}
