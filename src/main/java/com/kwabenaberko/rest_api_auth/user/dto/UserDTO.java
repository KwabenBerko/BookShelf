package com.kwabenaberko.rest_api_auth.user.dto;

import com.kwabenaberko.rest_api_auth.account.dto.AccountDTO;

public class UserDTO {
    private String id;
    private AccountDTO account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }
}
