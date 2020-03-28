package com.example.routebank.Model.Accounts;

import java.util.ArrayList;

interface AdminstrativeActions {

    void create(Account account);

    void remove(String userName);

    ArrayList<Account> search(String userName);

    ArrayList<Account> listAll();

}
