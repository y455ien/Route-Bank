package com.example.routebank.Controller.Login;

import android.content.Context;
import android.widget.Toast;

import com.example.routebank.Model.Accounts.Admin;
import com.example.routebank.Model.Login.AdminCreationModel;
import com.example.routebank.View.Login.AdminCreation;

public class AdminCreationController {

    AdminCreation view;
    AdminCreationModel model;
    Context context;

    public AdminCreationController(Context context, AdminCreation view) {
        this.context = context;
        this.view = view;
        model = new AdminCreationModel(context, this);
    }

    public void createAdmin(){
        String fullName = view.admin_ET_fullName.getText().toString();
        String userName = view.admin_ET_userName.getText().toString();
        String password = view.admin_ET_password.getText().toString();

        String adminKey = view.admin_ET_key.getText().toString();

        if (fullName.isEmpty() || userName.isEmpty() || password.isEmpty() || adminKey.isEmpty()) {
            makeToast("Please fill all values");
            return;
        }

        if (!adminKey.contentEquals("AdminKey")) {
            makeToast("Wrong admin key!");
            return;
        }

        Admin adminAccount = new Admin(context, fullName, userName, password);
        model.insert(adminAccount);

    }


























    public void makeToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
