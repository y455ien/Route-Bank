package com.example.routebank.View.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.routebank.Controller.Login.LoginActivityController;
import com.example.routebank.R;

public class MainActivity extends AppCompatActivity {

    LoginActivityController controller;

    public EditText userName;
    public EditText password;
    public Button BTN_login;
    public Button BTN_createAdmin;
    public Button BTN_removeAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.login_ET_username);
        password = findViewById(R.id.login_ET_password);
        BTN_createAdmin = findViewById(R.id.BTN_register);
        BTN_login = findViewById(R.id.BTN_login);

        controller = new LoginActivityController(MainActivity.this, this);

        BTN_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.login();
            }
        });

        BTN_createAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdminCreation.class);
                startActivity(intent);
            }
        });

    }
}
