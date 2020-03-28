package com.example.routebank.View.AccountOptions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.routebank.Controller.AccountOptions.MainScreenController;
import com.example.routebank.Controller.SessionType;
import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.Model.Accounts.Admin;
import com.example.routebank.R;
import com.example.routebank.View.AdminOptions.AdminEditingScreen;

public class MainScreen extends AppCompatActivity {

    Button BTN_checkBalance, BTN_withDraw, BTN_deposite, BTN_transefer, BTN_accountInfo, BTN_adminOptions;
    MainScreenController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        BTN_checkBalance = findViewById(R.id.main_BTN_checkBalance);
        BTN_withDraw = findViewById(R.id.main_BTN_withDraw);
        BTN_deposite = findViewById(R.id.main_BTN_deposite);
        BTN_transefer = findViewById(R.id.main_BTN_transefer);
        BTN_adminOptions = findViewById(R.id.main_BTN_adminOptions);

        controller = new MainScreenController(MainScreen.this, this);

        if (SessionType.account.getClass() == Account.class) {
            BTN_adminOptions.setVisibility(View.GONE);
        }

        BTN_checkBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.intentTo(CheckBalanceScreen.class);
            }
        });

        BTN_withDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.intentTo(WithdrawScreen.class);
            }
        });

        BTN_deposite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.intentTo(DepositeScreen.class);
            }
        });

        BTN_transefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.intentTo(TranseferScreen.class);
            }
        });

        BTN_adminOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.intentTo(AdminEditingScreen.class);
            }
        });

    }
}
