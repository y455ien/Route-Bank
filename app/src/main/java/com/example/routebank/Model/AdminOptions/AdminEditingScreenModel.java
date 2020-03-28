package com.example.routebank.Model.AdminOptions;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.routebank.Controller.SessionType;
import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.Model.Accounts.Admin;
import com.example.routebank.Model.Accounts.Employee;
import com.example.routebank.Model.DataBase.DataBaseHelper;

import java.util.ArrayList;

public class AdminEditingScreenModel {

    DataBaseHelper dataBaseHelper;
    SQLiteDatabase db;

    public AdminEditingScreenModel(Context context) {

        dataBaseHelper = new DataBaseHelper(context);
        db = dataBaseHelper.getWritableDatabase();

    }

    public ArrayList<Account> search(String userName) {
        Account temp = new Account(null, userName, null);
        ArrayList queryList = dataBaseHelper.search(db, temp);
        return queryList;
    }

    public boolean validateAction(Account account) {
        Boolean access = false;

        if (account.getClass() == Account.class && SessionType.account.getClass() == Employee.class) {
            access = true;
        }


        if (account.getClass() == Employee.class && SessionType.account.getClass() == Admin.class) {
            access = true;
        }

        if (account.getClass() == Account.class && SessionType.account.getClass() == Admin.class) {
            access = true;
        }


        return access;
    }

    public void removeAccount(Account account) {
        dataBaseHelper.delete(db, account);
    }

}
