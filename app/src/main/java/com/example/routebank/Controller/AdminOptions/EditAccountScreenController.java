package com.example.routebank.Controller.AdminOptions;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.routebank.Controller.SessionType;
import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.Model.Accounts.Admin;
import com.example.routebank.Model.Accounts.Employee;
import com.example.routebank.Model.AdminOptions.EditAccountScreenModel;
import com.example.routebank.View.AdminOptions.EditAccountScreen;

public class EditAccountScreenController {

    EditAccountScreen view;
    Context context;
    EditAccountScreenModel model;

    public EditAccountScreenController(Context context, EditAccountScreen view) {
        this.view = view;
        this.context = context;
        model = new EditAccountScreenModel(this.context);
    }


    public void setClickListener(final Account account) {

        view.BTN_applyChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyChanges(account);
            }
        });
    }

    public void applyChanges(Account account) {

        String newFullName = view.ET_newName.getText().toString();
        String newUserName = view.ET_newUserName.getText().toString();
        String newPassword = view.ET_newPassowrd.getText().toString();

        if (newFullName.isEmpty() || newUserName.isEmpty() || newPassword.isEmpty()) {
            makeToast("Please fill all required values");
            return;
        }

        if (SessionType.account.getClass() == Admin.class) {
            model.modify(account, newFullName, newUserName, newPassword, getIntType(), account.getBalance());
            makeToast("Done!");
            return;
        }

        if (SessionType.account.getClass() == Employee.class) {
            model.modify(account, newFullName, newUserName, newPassword, 2, account.getBalance());
            makeToast("Done!");
        }
    }













    private int getIntType() {
        int selectedType = view.spinner_accountType.getSelectedItemPosition();
        int returnedType = 5;
            switch (selectedType) {
                case 0:
                    returnedType = 2;
                    break;
                case 1:
                    returnedType =  1;
                    break;
            }
        return returnedType;
    }


    public void makeToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }


}
