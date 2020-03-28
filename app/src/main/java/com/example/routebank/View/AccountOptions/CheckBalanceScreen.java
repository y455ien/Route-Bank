package com.example.routebank.View.AccountOptions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.routebank.Controller.SessionType;
import com.example.routebank.R;

public class CheckBalanceScreen extends AppCompatActivity {

    TextView TV_name, TV_balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_balance_screen);

        TV_name = findViewById(R.id.checkBalance_TV_name);
        TV_balance = findViewById(R.id.checkBalance_TV_balance);

        TV_name.setText(SessionType.account.getFullName());
        TV_balance.setText(Integer.toString(SessionType.account.getBalance()));

    }
}
