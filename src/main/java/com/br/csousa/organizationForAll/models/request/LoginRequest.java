package com.br.csousa.organizationForAll.models.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
}
