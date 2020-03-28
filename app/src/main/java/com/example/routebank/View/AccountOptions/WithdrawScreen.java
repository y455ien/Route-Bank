package com.example.routebank.View.AccountOptions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.routebank.Controller.AccountOptions.WithdrawScreenController;
import com.example.routebank.R;

public class WithdrawScreen extends AppCompatActivity implements View.OnClickListener {

    Button BTN_2h, BTN_5h, BTN_1k, BTN_2k, BTN_4k, BTN_other;
    WithdrawScreenController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_screen);

        BTN_2h = findViewById(R.id.withdraw_BTN_2h);
        BTN_5h = findViewById(R.id.withdraw_BTN_5h);
        BTN_1k = findViewById(R.id.withdraw_BTN_1k);
        BTN_2k = findViewById(R.id.withdraw_BTN_2k);
        BTN_4k = findViewById(R.id.withdraw_BTN_4k);

        controller = new WithdrawScreenController(WithdrawScreen.this, this);

        BTN_2h.setOnClickListener(this);
        BTN_5h.setOnClickListener(this);
        BTN_1k.setOnClickListener(this);
        BTN_2k.setOnClickListener(this);
        BTN_4k.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button view = (Button) v;
        controller.withdraw(view);
    }

}
