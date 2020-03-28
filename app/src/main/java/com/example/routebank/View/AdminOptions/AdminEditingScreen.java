package com.example.routebank.View.AdminOptions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.routebank.Controller.AdminOptions.AdminEditingScreenController;
import com.example.routebank.R;

public class AdminEditingScreen extends AppCompatActivity {

    public Spinner spinner_actionType;

    public TextView TV_userName;

    public EditText ET_userName;

    public Button BTN_performAction, BTN_createAccount;

    AdminEditingScreenController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_editing_screen);

        spinner_actionType = findViewById(R.id.action_spinner_actionType);
        TV_userName = findViewById(R.id.action_TV_userName);
        ET_userName = findViewById(R.id.action_ET_username);
        BTN_performAction = findViewById(R.id.action_BTN_actionType);
        BTN_createAccount = findViewById(R.id.adminScreen_BTN_createAccount);

        controller = new AdminEditingScreenController(AdminEditingScreen.this, this);
        controller.updateButton();

        BTN_performAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.chosenAction();
            }
        });

        BTN_createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminEditingScreen.this, CreateAccountScreen.class);
                startActivity(intent);
            }
        });

    }
}
