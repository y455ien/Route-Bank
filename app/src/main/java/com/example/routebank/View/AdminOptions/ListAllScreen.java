package com.example.routebank.View.AdminOptions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.routebank.Controller.CustomAdapter;
import com.example.routebank.Controller.SessionType;
import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.Model.Accounts.Admin;
import com.example.routebank.Model.Accounts.Employee;
import com.example.routebank.Model.DataBase.DataBaseHelper;
import com.example.routebank.R;

import java.util.ArrayList;

public class ListAllScreen extends AppCompatActivity {

    ListView listView;
    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
    ArrayList<Account> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_screen);

        listView = findViewById(R.id.listAll_listView);

        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

        myList = dataBaseHelper.viewAllAccounts(db);

        CustomAdapter adapter = new CustomAdapter(ListAllScreen.this, R.layout.listviewrow, myList);

        listView.setAdapter(adapter);

    }
}
