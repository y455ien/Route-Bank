package com.example.routebank.View.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.routebank.Controller.Login.AdminCreationController;
import com.example.routebank.R;

public class AdminCreation extends AppCompatActivity {

    public EditText admin_ET_fullName;
    public EditText admin_ET_userName;
    public EditText admin_ET_password;
    public EditText admin_ET_key;
    public Button admin_BTN_create;

    AdminCreationController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_creation);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        admin_ET_fullName = findViewById(R.id.admin_ET_fullName);
        admin_ET_userName = findViewById(R.id.admin_ET_userName);
        admin_ET_password = findViewById(R.id.admin_ET_password);
        admin_ET_key = findViewById(R.id.admin_ET_key);
        admin_BTN_create = findViewById(R.id.admin_BTN_create);

        controller = new AdminCreationController(AdminCreation.this, this);

        admin_BTN_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.createAdmin();
            }
        });




    }
}
