package com.br.csousa.organizationForAll.models.request;

import lombok.Data;

import java.util.List;

@Data
public class RequestReserveCreate {

    private String name;

    private String mail;

    private String telephone;

    private Long localId;

    private String date;

    private String hour;

    private Long qtdAdults;

    private Long qtdChilds;

}
