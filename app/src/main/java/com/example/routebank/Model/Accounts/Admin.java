package com.example.routebank.Model.Accounts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ArrayAdapter;

import com.example.routebank.Model.DataBase.DataBaseHelper;

import java.util.ArrayList;

public class Admin extends Account implements AdminstrativeActions {

    DataBaseHelper dataBaseHelper;
    SQLiteDatabase db;

    public Admin(Context context, String fullName, String userName, String password){
        super(fullName, userName, password);
        this.setType(0);

        dataBaseHelper = new DataBaseHelper(context);
        db = dataBaseHelper.getWritableDatabase();
    }

    @Override
    public void create(Account account) {
        if (account.getClass() == Account.class) {
            dataBaseHelper.insert(db, account);
            return;
        }

        if (account.getClass() == Employee.class) {
            Employee employeeAccount = (Employee) account;
            dataBaseHelper.insert(db, employeeAccount);
        }
    }


    @Override
    public void remove(String userName) {

    }

    @Override
    public ArrayList<Account> search(String userName) {
        Account temp = new Account(null, userName, null);
        ArrayList<Account> queryList = dataBaseHelper.search(db, temp);
        return queryList;
    }

    @Override
    public ArrayList<Account> listAll() {
        return null;
    }

}
