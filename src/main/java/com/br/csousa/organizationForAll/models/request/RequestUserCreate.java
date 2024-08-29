package com.br.csousa.organizationForAll.models.request;

import lombok.Data;

@Data
public class RequestUserCreate {

    private String name;
    private String username;
    private String password;
    private String role;
}
