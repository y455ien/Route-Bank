package com.example.routebank.Controller.AccountOptions;

import android.content.Context;
import android.widget.Toast;

import com.example.routebank.Controller.SessionType;
import com.example.routebank.Model.AccountOptions.TranseferScreenModel;
import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.View.AccountOptions.TranseferScreen;

import java.util.ArrayList;

public class TranseferScreenController {

    TranseferScreen view;
    Context context;
    TranseferScreenModel model;

    public TranseferScreenController(Context context, TranseferScreen view){
        this.view = view;
        this.context = context;
        model = new TranseferScreenModel(this.context);
    }

    public void transefer(){
        String recievingUsername = view.ET_userName.getText().toString();
        String stringAmount = view.ET_amount.getText().toString();

        if (recievingUsername.isEmpty() || stringAmount.isEmpty()) {
            makeToast("Please fill all required fields");
            return;
        }

        if (recievingUsername.contentEquals(SessionType.account.getUserName())) {
            makeToast("You can not transfer money to your own account");
        }

        int amount = Integer.parseInt(stringAmount);

        if (amount > SessionType.account.getBalance()) {
            makeToast("Your do not have enough balance");
            return;
        }

        if (amount < 100) {
            makeToast("The minimum value to transfer is 100");
            return;
        }

        if (amount%20 != 0) {
            makeToast("Please insert multiplications of 20");
            return;
        }

        if (model.transefer(recievingUsername, amount)) {
            makeToast("Done");
        } else {makeToast("This account is not found");}


    }













    public void makeToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
