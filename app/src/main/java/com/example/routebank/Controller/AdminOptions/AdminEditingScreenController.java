package com.example.routebank.Controller.AdminOptions;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.routebank.Controller.SessionType;
import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.Model.Accounts.Admin;
import com.example.routebank.Model.Accounts.Employee;
import com.example.routebank.Model.AdminOptions.AdminEditingScreenModel;
import com.example.routebank.View.AdminOptions.AdminEditingScreen;
import com.example.routebank.View.AdminOptions.EditAccountScreen;
import com.example.routebank.View.AdminOptions.ListAllScreen;
import com.example.routebank.View.AdminOptions.SearchAccountScreen;

import java.util.ArrayList;

public class AdminEditingScreenController {

    AdminEditingScreen view;
    Context context;
    AdminEditingScreenModel model;

    public AdminEditingScreenController(Context context, AdminEditingScreen view) {
        this.view = view;
        this.context = context;
        model = new AdminEditingScreenModel(this.context);
    }

    public void chosenAction() {
        String userName = view.ET_userName.getText().toString();

        ArrayList<Account> queryList = null;

        Account account = null;

        Intent intent = null;

            int selectedAction = view.spinner_actionType.getSelectedItemPosition();
                switch (selectedAction) {
                    case 0:
                        if (isFieldEmpty(userName)) return;
                        queryList =  model.search(userName);
                        if (!isFound(queryList)) return;
                        account = queryList.get(0);

                        if (!model.validateAction(account)) {
                            makeToast("You dont have access");
                            return;
                        }

                        intent = new Intent(context, SearchAccountScreen.class);
                        intent.putExtra("ACCOUNT", account);
                        context.startActivity(intent);
                        break;

                    case 1:
                        if (isFieldEmpty(userName)) return;
                        queryList =  model.search(userName);
                        if (!isFound(queryList)) return;
                        account = queryList.get(0);

                        if (!model.validateAction(account)) {
                            makeToast("You dont have access");
                            return;
                        }

                        intent = new Intent(context, EditAccountScreen.class);
                        intent.putExtra("ACCOUNT", account);
                        context.startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(context, ListAllScreen.class);
                        context.startActivity(intent);
                        break;

                    case 3:
                        if (isFieldEmpty(userName)) return;
                        queryList =  model.search(userName);
                        if (!isFound(queryList)) return;
                        account = queryList.get(0);

                        if (!model.validateAction(account)) {
                            makeToast("You dont have access");
                            return;
                        }

                        model.removeAccount(account);
                        makeToast("Account removed!");
                        break;
                }

    }








    private Boolean isFieldEmpty(String userName) {
        Boolean isFieldEmpty = false;
        if (userName.isEmpty()) {
            makeToast("Please fill the Username field");
            isFieldEmpty = true;
        }
        return isFieldEmpty;
    }

    private Boolean isFound(ArrayList<Account> queryList) {
        Boolean isFound = true;
        if (queryList.isEmpty()) {
            makeToast("Account not found");
            isFound = false;
        }
        return isFound;
    }


    public void updateButton() {

        view.spinner_actionType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        AdminEditingScreenController.this.view.TV_userName.setVisibility(View.VISIBLE);
                        AdminEditingScreenController.this.view.ET_userName.setVisibility(View.VISIBLE);
                        AdminEditingScreenController.this.view.BTN_performAction.setText("Search");
                        break;
                    case 1:
                        AdminEditingScreenController.this.view.TV_userName.setVisibility(View.VISIBLE);
                        AdminEditingScreenController.this.view.ET_userName.setVisibility(View.VISIBLE);
                        AdminEditingScreenController.this.view.BTN_performAction.setText("Edit");
                        break;
                    case 2:
                        AdminEditingScreenController.this.view.TV_userName.setVisibility(View.GONE);
                        AdminEditingScreenController.this.view.ET_userName.setVisibility(View.GONE);
                        AdminEditingScreenController.this.view.BTN_performAction.setText("List");
                        break;
                    case 3:
                        AdminEditingScreenController.this.view.TV_userName.setVisibility(View.VISIBLE);
                        AdminEditingScreenController.this.view.ET_userName.setVisibility(View.VISIBLE);
                        AdminEditingScreenController.this.view.BTN_performAction.setText("Remove");
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void makeToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

}
