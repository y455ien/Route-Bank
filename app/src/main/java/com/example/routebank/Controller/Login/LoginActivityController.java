package com.example.routebank.Controller.Login;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.routebank.Controller.SessionType;
import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.Model.Login.LoginActivityModel;
import com.example.routebank.View.Login.MainActivity;
import com.example.routebank.View.AccountOptions.MainScreen;

public class LoginActivityController {

    MainActivity view;
    Context context;
    LoginActivityModel model;
    SessionType sessionType;

    public LoginActivityController(Context context, MainActivity view) {
        this.context = context;
        this.view = view;
        this.model = new LoginActivityModel(this);
    }

    public void login(){
        String userName = view.userName.getText().toString();
        String password = view.password.getText().toString();

        if (userName.isEmpty() || password.isEmpty()) {
            makeToast("Please fill all fields");
            return;
        }

        Account account = model.login(userName, password);

        if (account != null) {
            sessionType = new SessionType(account);
            Intent intent = new Intent(context, MainScreen.class);
            context.startActivity(intent);
        }
    }


    public Context getContext() {
        return context;
    }

    public void makeToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
