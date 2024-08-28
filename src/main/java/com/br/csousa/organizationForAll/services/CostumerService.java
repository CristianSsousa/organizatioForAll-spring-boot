package com.br.csousa.organizationForAll.services;

import com.br.csousa.organizationForAll.models.Costumer;
import com.br.csousa.organizationForAll.models.request.RequestCostumerCreate;
import com.br.csousa.organizationForAll.repositorys.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CostumerService {

    @Autowired
    private CostumerRepository costumerRepository;

    public Costumer createCostumer(RequestCostumerCreate request) {
        Costumer costumer = builderCostumer(request);
        return costumerRepository.save(costumer);
    }

    private Costumer builderCostumer(RequestCostumerCreate request) {
        return Costumer.builder()
                .name(request.getName())
                .mail(request.getMail())
                .telephone(request.getTelephone())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public Costumer findById(Long idCostumer) {
        return costumerRepository.findById(idCostumer).orElseThrow(() -> new RuntimeException("Costumer not found"));
    }

    public List<Costumer> getAllCostumers() {
        return costumerRepository.findAll();
    }
}
