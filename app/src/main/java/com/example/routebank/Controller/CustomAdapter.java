package com.example.routebank.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.routebank.Model.Accounts.Account;
import com.example.routebank.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Account> {


    private int resourceLayout;
    private Context mContext;

    public CustomAdapter(Context context, int resource, List<Account> accountList) {
        super(context, resource, accountList);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
            v.setPadding(20, 20, 20, 20);
        }

        Account account = getItem(position);

        if (account != null) {
            ImageView profile = v.findViewById(R.id.row_imageView);
            TextView fullName = v.findViewById(R.id.row_fullName);
            TextView userName = v.findViewById(R.id.row_userName);
            TextView password = v.findViewById(R.id.row_password);
            TextView accountType = v.findViewById(R.id.row_type);
            TextView balance = v.findViewById(R.id.row_balance);

            if (profile != null) {
                profile.setImageResource(R.drawable.avatar_image);
            }

            if (fullName != null) {
                fullName.setText(account.getFullName());
            }

            if (userName != null) {
                userName.setText(account.getUserName());
            }

            if (password != null) {
                password.setText(account.getPassword());
            }

            if (accountType != null) {
                accountType.setText(Integer.toString(account.getType()));
            }

            if (balance != null) {
                balance.setText(Integer.toString(account.getBalance()));
            }
        }

        return v;
    }
}
