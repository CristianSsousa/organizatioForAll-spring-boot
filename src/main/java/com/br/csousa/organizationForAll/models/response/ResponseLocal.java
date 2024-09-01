package com.br.csousa.organizationForAll.models.response;

import com.br.csousa.organizationForAll.models.Reserve;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ResponseLocal {

    private String name;

    private Integer capacity;

    private LocalDateTime createdAt;

    private List<Reserve> reserves;
}
