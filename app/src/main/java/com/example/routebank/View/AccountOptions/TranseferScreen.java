package com.example.routebank.View.AccountOptions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.routebank.Controller.AccountOptions.TranseferScreenController;
import com.example.routebank.R;

public class TranseferScreen extends AppCompatActivity {

    public EditText ET_userName, ET_amount;
    Button BTN_transefer;

    TranseferScreenController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transefer_screen);

        ET_userName = findViewById(R.id.transefer_ET_userName);
        ET_amount = findViewById(R.id.transefer_ET_amount);
        BTN_transefer = findViewById(R.id.transefer_BTN_transefer);

        controller = new TranseferScreenController(TranseferScreen.this, this);

        BTN_transefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.transefer();
            }
        });

    }
}
