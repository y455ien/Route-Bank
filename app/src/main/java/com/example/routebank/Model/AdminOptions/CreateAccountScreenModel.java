package com.example.routebank.Model.AdminOptions;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.routebank.Controller.SessionType;
import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.Model.Accounts.Admin;
import com.example.routebank.Model.Accounts.Employee;
import com.example.routebank.Model.DataBase.DataBaseHelper;

import java.util.ArrayList;

public class CreateAccountScreenModel {

    DataBaseHelper dataBaseHelper;
    SQLiteDatabase db;

    public CreateAccountScreenModel(Context context) {
        dataBaseHelper = new DataBaseHelper(context);
        db = dataBaseHelper.getWritableDatabase();
    }

    public Boolean isUnique(Account account) {
        Boolean isUnique = false;
        ArrayList<Account> accountList = dataBaseHelper.search(db, account);

        if (accountList.isEmpty()) isUnique = true;

        return isUnique;
    }

    public void createAccount(Account account){
        if (SessionType.account.getClass() == Admin.class) {
            Admin adminSession = (Admin) SessionType.account;
            adminSession.create(account);
            return;
        }

        if (SessionType.account.getClass() == Employee.class) {
            Employee employeeSession = (Employee) SessionType.account;
            employeeSession.create(account);
        }
    }

}
