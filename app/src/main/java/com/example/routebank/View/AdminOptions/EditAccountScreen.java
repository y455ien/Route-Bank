package com.example.routebank.View.AdminOptions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.routebank.Controller.AdminOptions.EditAccountScreenController;
import com.example.routebank.Controller.SessionType;
import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.Model.Accounts.Employee;
import com.example.routebank.R;

public class EditAccountScreen extends AppCompatActivity {

    TextView TV_type;
    public Spinner spinner_accountType;
    TextView TV_oldName, TV_oldUserName, TV_oldPassword;
    public EditText ET_newName, ET_newUserName, ET_newPassowrd;
    public Button BTN_applyChanges;

    EditAccountScreenController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account_screen);

        Intent intent = getIntent();
        Account parsedAccount = intent.getParcelableExtra("ACCOUNT");

        TV_type = findViewById(R.id.edit_TV_type);
        spinner_accountType = findViewById(R.id.edit_spinner_type);
        TV_oldName = findViewById(R.id.edit_TV_oldName);
        TV_oldUserName = findViewById(R.id.edit_TV_oldUserName);
        TV_oldPassword = findViewById(R.id.edit_TV_oldPassword);

        ET_newName = findViewById(R.id.edit_ET_newFullName);
        ET_newUserName = findViewById(R.id.edit_ET_newUserName);
        ET_newPassowrd = findViewById(R.id.edit_ET_newPassword);

        BTN_applyChanges = findViewById(R.id.edit_BTN_apply);

        if (SessionType.account.getClass() == Employee.class) {
            spinner_accountType.setVisibility(View.GONE);
            TV_type.setVisibility(View.GONE);
        }

        controller = new EditAccountScreenController(EditAccountScreen.this, this);

        controller.setClickListener(parsedAccount);

    }
}
