package com.example.routebank.Controller.AdminOptions;

import android.content.Context;
import android.widget.Toast;

import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.Model.Accounts.Admin;
import com.example.routebank.Model.Accounts.Employee;
import com.example.routebank.Model.AdminOptions.CreateAccountScreenModel;
import com.example.routebank.View.AdminOptions.CreateAccountScreen;

public class CreateAccountScreenController {

    CreateAccountScreen view;
    CreateAccountScreenModel model;
    Context context;


    public CreateAccountScreenController(Context context, CreateAccountScreen view) {
        this.view = view;
        this.context = context;
        this.model = new CreateAccountScreenModel(this.context);
    }

    public void createAccount() {
        String fullName = view.ET_fullName.getText().toString();
        String userName = view.ET_userName.getText().toString();
        String password = view.ET_password.getText().toString();

        if (fullName.isEmpty() || userName.isEmpty() || password.isEmpty()) {
            makeToast("Please fill all required values");
            return;
        }

        String spinnerValue = view.spinner_accType.getSelectedItem().toString();

        Account account = new Account(fullName, userName, password);

        if (!model.isUnique(account)) {
            makeToast("This Username has already been taken");
            return;
        }

        if (spinnerValue.contentEquals("User")) {
            model.createAccount(account);
            return;
        }

        if (spinnerValue.contentEquals("Employee")) {
            Employee employeeAccount = new Employee(context, fullName, userName, password);
            model.createAccount(employeeAccount);
        }
    }



















    public void makeToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
