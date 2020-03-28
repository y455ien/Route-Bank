package com.example.routebank.Controller.AdminOptions;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.Model.AdminOptions.SearchAccountScreenModel;
import com.example.routebank.View.AdminOptions.EditAccountScreen;
import com.example.routebank.View.AdminOptions.SearchAccountScreen;

public class SearchAccountScreenController {

    SearchAccountScreen view;
    Context context;
    SearchAccountScreenModel model;

    public SearchAccountScreenController(Context context, SearchAccountScreen view) {
        this.view = view;
        this.context = context;
        model = new SearchAccountScreenModel();
    }


    public void  setClickListener(final Account account) {
        view.BTN_editAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditAccountScreen.class);
                intent.putExtra("ACCOUNT", account);
                context.startActivity(intent);
            }
        });
    }

    public void populateView(Account account) {

        view.TV_fullName.setText(account.getFullName());
        view.TV_accountType.setText(getStringType(account.getType()));
        view.TV_userName.setText(account.getUserName());
        view.TV_password.setText(account.getPassword());
        view.TV_balance.setText(Integer.toString(account.getBalance()));

    }







    private String getStringType(int type) {
        String stringType = null;
        switch (type) {
            case 0:
                stringType = "Admin";
                break;
            case 1:
                stringType = "Employee";
                break;
            case 2:
                stringType = "User";
                break;
        }

        return stringType;
    }

}
