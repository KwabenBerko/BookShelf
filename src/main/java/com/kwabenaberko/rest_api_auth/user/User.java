package com.kwabenaberko.rest_api_auth.user;

import com.kwabenaberko.rest_api_auth.account.Account;

import java.util.UUID;

public class User {
    private String id;
    private Account account;

    public User(Account account) {
        this.id = UUID.randomUUID().toString();
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", account=" + account +
                '}';
    }
}
