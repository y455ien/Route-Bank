package com.example.routebank.Model.Accounts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.routebank.Model.DataBase.DataBaseHelper;

import java.util.ArrayList;

public class Employee extends Account implements AdminstrativeActions{

    DataBaseHelper dataBaseHelper;
    SQLiteDatabase db;

    public Employee(Context context, String fullName, String userName, String password) {

        super(fullName, userName, password);
        this.setType(1);

        dataBaseHelper = new DataBaseHelper(context);
        db = dataBaseHelper.getWritableDatabase();
    }


    @Override
    public void create(Account account) {
        dataBaseHelper.insert(db, account);
    }

    @Override
    public void remove(String userName) {

    }

    @Override
    public ArrayList<Account> search(String userName) {
        return null;
    }

    @Override
    public ArrayList<Account> listAll() {
        return null;
    }
}
