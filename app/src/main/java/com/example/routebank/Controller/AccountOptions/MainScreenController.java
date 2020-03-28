package com.example.routebank.Controller.AccountOptions;

import android.content.Context;
import android.content.Intent;

import com.example.routebank.View.AccountOptions.MainScreen;

public class MainScreenController {

    MainScreen view;
    Context context;

    public MainScreenController(Context context, MainScreen view) {
        this.view = view;
        this.context = context;
    }

    public void intentTo(Class c) {
        Intent intent = new Intent(context, c);
        context.startActivity(intent);
    }

}
