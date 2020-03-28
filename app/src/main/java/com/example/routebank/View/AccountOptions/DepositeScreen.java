package com.example.routebank.View.AccountOptions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.routebank.Controller.AccountOptions.DepositeScreenController;
import com.example.routebank.R;

public class DepositeScreen extends AppCompatActivity {

    public EditText ET_amount;
    Button BTN_deposite;
    DepositeScreenController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposite_screen);

        ET_amount = findViewById(R.id.deposite_ET_amount);
        BTN_deposite = findViewById(R.id.deposite_BTN_deposite);

        controller = new DepositeScreenController(DepositeScreen.this, this);

        BTN_deposite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.deposite();
            }
        });

    }
}
