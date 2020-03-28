package com.example.routebank.View.AdminOptions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.routebank.Controller.AdminOptions.SearchAccountScreenController;
import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.R;

public class SearchAccountScreen extends AppCompatActivity {

    public TextView TV_fullName, TV_accountType, TV_userName, TV_password, TV_balance;

    public Button BTN_editAccount;

    SearchAccountScreenController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_account_screen);

        TV_fullName = findViewById(R.id.search_fullName);
        TV_accountType = findViewById(R.id.search_type);
        TV_userName = findViewById(R.id.search_userName);
        TV_password = findViewById(R.id.search_password);
        TV_balance = findViewById(R.id.search_balance);
        BTN_editAccount = findViewById(R.id.search_BTN_editAccount);

        controller = new SearchAccountScreenController(SearchAccountScreen.this, this);

        Intent intent = getIntent();
        Account parsedAccount = intent.getParcelableExtra("ACCOUNT");
        controller.populateView((parsedAccount));
        controller.setClickListener(parsedAccount);

    }
}
