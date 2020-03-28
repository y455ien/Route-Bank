package com.example.routebank.Controller.AccountOptions;

import android.content.Context;
import android.widget.Toast;

import com.example.routebank.Controller.SessionType;
import com.example.routebank.Model.AccountOptions.DepositeScreenModel;
import com.example.routebank.View.AccountOptions.DepositeScreen;

public class DepositeScreenController {

    DepositeScreen view;
    Context context;
    DepositeScreenModel model;

    public DepositeScreenController(Context context, DepositeScreen view) {
        this.context = context;
        this.view = view;
        model = new DepositeScreenModel(this.context);
    }

    public void deposite() {

        String input = view.ET_amount.getText().toString();

        if (input.isEmpty()) {
            makeToast("Please insert an amount first");
            return;
        }

        int amount = Integer.parseInt(input);

        if (amount < 100) {
            makeToast("The minimum value to deposit is 100");
            return;
        }

        if (amount%20 != 0) {
            makeToast("Please insert multiplications of 20");
            return;
        }

        int newBalance = SessionType.account.getBalance() + amount;

        model.deposit(newBalance);
        makeToast("Done!");
    }











    public void makeToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
