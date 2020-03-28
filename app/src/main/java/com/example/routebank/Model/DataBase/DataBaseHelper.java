package com.example.routebank.Model.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.routebank.Controller.SessionType;
import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.Model.Accounts.Admin;
import com.example.routebank.Model.Accounts.Employee;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String database_name = "DataBase";
    private static final int database_version = 1;
    private Context context;


    public DataBaseHelper(Context context) {
        super(context,database_name, null, database_version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ACCOUNTS (_id INTEGER PRIMARY KEY AUTOINCREMENT, FULLNAME TEXT, USERNAME TEXT, PASSWORD TEXT, TYPE INTEGER, BALANCE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(SQLiteDatabase db, Account account) {

        ContentValues accountValues = new ContentValues();
        accountValues.put("FULLNAME", account.getFullName());
        accountValues.put("USERNAME", account.getUserName());
        accountValues.put("PASSWORD", account.getPassword());
        accountValues.put("TYPE", account.getType());
        accountValues.put("BALANCE", account.getBalance());

        db.insert("ACCOUNTS", null, accountValues);
    }

    public void delete(SQLiteDatabase db, Account account) {
        String userName = account.getUserName();
        db.delete("ACCOUNTS", "USERNAME = ?", new String[]{userName});
    }

    public ArrayList<Account> search(SQLiteDatabase db, Account account){

            ArrayList<Account> list = new ArrayList<>();
            String userName = account.getUserName();

            Cursor cursor = db.query("ACCOUNTS", new String[] {"FULLNAME", "USERNAME", "PASSWORD", "TYPE", "BALANCE"}, "USERNAME = ?", new String[] {userName}, null, null, null);

            if (cursor.getCount() > 0) {

                while (cursor.moveToNext()) {
                    String FULLNAME = cursor.getString(0);
                    String USERNAME = cursor.getString(1);
                    String PASSWORD = cursor.getString(2);
                    int TYPE = cursor.getInt(3);
                    int BALANCE = cursor.getInt(4);

                    Account queryAccount = null;

                    switch (TYPE) {
                        case 0:
                            queryAccount = new Admin(context, FULLNAME, USERNAME, PASSWORD);
                            queryAccount.setBalance(BALANCE);
                            break;

                        case 1:
                            queryAccount = new Employee(context, FULLNAME, USERNAME, PASSWORD);
                            break;

                        case 2:
                            queryAccount = new Account(FULLNAME, USERNAME, PASSWORD);
                            queryAccount.setBalance(BALANCE);
                            break;

                    }

                    list.add(queryAccount);
                }
                cursor.close();
            }
            return list;

    }

    public Account login(SQLiteDatabase db, String userName){

        Account accountSession = null;

        Cursor cursor = db.query("ACCOUNTS", new String[] {"FULLNAME", "USERNAME", "PASSWORD", "TYPE", "BALANCE"}, "USERNAME = ?", new String[] {userName}, null, null, null);

        if (cursor.getCount() > 0) {

            while (cursor.moveToNext()) {
                String FULLNAME = cursor.getString(0);
                String USERNAME = cursor.getString(1);
                String PASSWORD = cursor.getString(2);
                int TYPE = cursor.getInt(3);
                int BALANCE = cursor.getInt(4);

                switch (TYPE) {
                    case 0:
                        accountSession = new Admin(context, FULLNAME, USERNAME, PASSWORD);
                        accountSession.setBalance(BALANCE);
                        break;

                    case 1:
                        accountSession = new Employee(context, FULLNAME, USERNAME, PASSWORD);
                        accountSession.setBalance(BALANCE);
                        break;

                    case 2:
                        accountSession = new Account(FULLNAME, USERNAME, PASSWORD);
                        accountSession.setBalance(BALANCE);
                        break;
                }

            }
            cursor.close();
        }
        return accountSession;
    }

    public void update(SQLiteDatabase db, int value) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("BALANCE", value);

        db.update("ACCOUNTS", contentValues, "USERNAME = ?", new String[] {SessionType.account.getUserName()});
        SessionType.account.setBalance(value);
    }

    public void updateBalance(SQLiteDatabase db, String userName, int value) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("BALANCE", value);

        db.update("ACCOUNTS", contentValues, "USERNAME = ?", new String[] {userName});
    }

    public void transefer(SQLiteDatabase db, String userName, int transeferedAmount, int oldBalance) {
        int newBalance = oldBalance + transeferedAmount;
        updateBalance(db, userName, newBalance);

        int currentUserNewBalance = SessionType.account.getBalance() - transeferedAmount;
        update(db, currentUserNewBalance);

        SessionType.account.setBalance(currentUserNewBalance);
    }

    public void editAccountInfo(SQLiteDatabase db, Account account, String fullName, String userName, String password, int type, int balance) {
        String queryUserName = account.getUserName();

        ContentValues newValues = new ContentValues();
        newValues.put("FULLNAME", fullName);
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD", password);
        newValues.put("TYPE", type);
        newValues.put("BALANCE", balance);

        db.update("ACCOUNTS", newValues, "USERNAME = ?", new String[] {queryUserName});


    }

    public ArrayList<Account> viewAllAccounts(SQLiteDatabase db) {

        Cursor cursor = null;

        if (SessionType.account.getClass() == Admin.class) {
            cursor = db.query("ACCOUNTS", new String[] {"FULLNAME", "USERNAME", "PASSWORD", "TYPE", "BALANCE"}, null, null, null, null, null);
        }

        if (SessionType.account.getClass() == Employee.class) {
            cursor = db.query("ACCOUNTS", new String[] {"FULLNAME", "USERNAME", "PASSWORD", "TYPE", "BALANCE"}, "TYPE = ?", new String[] {Integer.toString(2)}, null, null, null);
        }

        ArrayList<Account> dataList = new ArrayList<>();

        if (cursor.getCount() > 0) {

            while (cursor.moveToNext()) {
                String FULLNAME = cursor.getString(0);
                String USERNAME = cursor.getString(1);
                String PASSWORD = cursor.getString(2);
                int TYPE = cursor.getInt(3);
                int BALANCE = cursor.getInt(4);

                Account queryAccount = null;

                switch (TYPE) {
                    case 0:
                        queryAccount = new Admin(context, FULLNAME, USERNAME, PASSWORD);
                        queryAccount.setBalance(BALANCE);
                        break;

                    case 1:
                        queryAccount = new Employee(context, FULLNAME, USERNAME, PASSWORD);
                        break;

                    case 2:
                        queryAccount = new Account(FULLNAME, USERNAME, PASSWORD);
                        queryAccount.setBalance(BALANCE);
                        break;

                }

                dataList.add(queryAccount);
            }
            cursor.close();
        }
        return dataList;


    }

}
