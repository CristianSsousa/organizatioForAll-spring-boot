package com.br.csousa.organizationForAll.models.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestLocalCreate {

    private String name;
    private Integer capacity;
}
