package com.example.routebank.Model.AccountOptions;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.routebank.Model.DataBase.DataBaseHelper;

public class DepositeScreenModel {

    DataBaseHelper dataBaseHelper;
    SQLiteDatabase db;

    public DepositeScreenModel(Context context) {
        dataBaseHelper = new DataBaseHelper(context);
        db = dataBaseHelper.getWritableDatabase();
    }

    public void deposit(int newBalance){
        dataBaseHelper.update(db, newBalance);
    }
}
