package com.example.routebank.View.AdminOptions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.routebank.Controller.AdminOptions.CreateAccountScreenController;
import com.example.routebank.Controller.SessionType;
import com.example.routebank.Model.Accounts.Employee;
import com.example.routebank.R;

public class CreateAccountScreen extends AppCompatActivity {

    TextView TV_spinnerTextView;
    public Spinner spinner_accType;

    public EditText ET_fullName, ET_userName, ET_password;

    Button BTN_createAccount;

    CreateAccountScreenController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_screen);

        TV_spinnerTextView = findViewById(R.id.create_TV_spinnerTextView);
        spinner_accType = findViewById(R.id.create_spinner_type);
        ET_fullName = findViewById(R.id.create_ET_fullName);
        ET_userName = findViewById(R.id.create_ET_userName);
        ET_password = findViewById(R.id.create_ET_password);
        BTN_createAccount = findViewById(R.id.create_BTN_createAccount);

        if (SessionType.account.getClass() == Employee.class) {
            spinner_accType.setVisibility(View.GONE);
            TV_spinnerTextView.setVisibility(View.GONE);
        }

        controller = new CreateAccountScreenController(CreateAccountScreen.this, this);


        BTN_createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.createAccount();
            }
        });


    }
}
