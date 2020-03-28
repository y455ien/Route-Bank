package com.example.routebank.Controller.AccountOptions;

import android.content.Context;
import android.widget.Button;
import android.widget.Toast;

import com.example.routebank.Controller.SessionType;
import com.example.routebank.Model.AccountOptions.WithdrawScreenModel;
import com.example.routebank.View.AccountOptions.WithdrawScreen;

public class WithdrawScreenController {

    WithdrawScreen view;
    Context context;
    WithdrawScreenModel model;

    public WithdrawScreenController(Context context, WithdrawScreen view) {
        this.view = view;
        this.context = context;
        model = new WithdrawScreenModel(this.context);
    }

    public void withdraw(Button clickedView) {
        int value = Integer.parseInt(clickedView.getText().toString());

        if (value > SessionType.account.getBalance()) {
            makeToast("You do not have enough Balance, please check your Balance");
            return;
        }

        model.withdraw(value);
        makeToast("Done!");

    }










    public void makeToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

}
