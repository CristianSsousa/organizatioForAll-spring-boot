package com.br.csousa.organizationForAll.services;

import com.br.csousa.organizationForAll.models.Costumer;
import com.br.csousa.organizationForAll.models.Local;
import com.br.csousa.organizationForAll.models.Reserve;
import com.br.csousa.organizationForAll.models.request.RequestReserveCreate;
import com.br.csousa.organizationForAll.models.response.ResponseLocal;
import com.br.csousa.organizationForAll.repositorys.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReserveService {

    @Autowired
    private ReserveRepository reserveRepository;

    @Autowired
    private LocalService localService;

    @Autowired
    private CostumerService costumerService;

    public Reserve createReserve(RequestReserveCreate request) {

        reserveRepository.findByDateAndHourAndLocal(request.getDate(), request.getHour(), localService.findById(request.getLocalId())).ifPresent(reserve -> {
            throw new RuntimeException("RESERVE ALREADY EXISTS");
        });

        Reserve reserve = builderReserve(request);
        return reserveRepository.save(reserve);
    }

    public Reserve findById(Long idReserve) {
        return reserveRepository.findById(idReserve).orElseThrow(() -> new RuntimeException("Reserve not found"));
    }

    private Reserve builderReserve(RequestReserveCreate request) {
        return Reserve.builder()
                .name(request.getName())
                .mail(request.getMail())
                .telephone(request.getTelephone())
                .local(localService.findById(request.getLocalId()))
                .date(request.getDate())
                .hour(request.getHour())
                .createdAt(LocalDateTime.now())
                .qtdAdults(request.getQtdAdults())
                .qtdChilds(request.getQtdChilds())
                .build();
    }

    private List<Costumer> builderCostumers(List<Long> costumersId) {
        return costumersId.stream().map(costumerService::findById).toList();
    }

    public Reserve getReserveById(Long id) {
        return reserveRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserve not found"));
    }

    public List<Reserve> getAllReserves() {
        return reserveRepository.findAll();
    }

    public void updateReserve(Long id, RequestReserveCreate request) {
        try {
            Reserve reserve = findById(id);
            reserve.setName(request.getName());
            reserve.setMail(request.getMail());
            reserve.setTelephone(request.getTelephone());
            reserve.setLocal(localService.findById(request.getLocalId()));
            reserve.setDate(request.getDate());
            reserve.setHour(request.getHour());
            reserve.setUpdatedAt(LocalDateTime.now());
            reserve.setQtdAdults(request.getQtdAdults());
            reserve.setQtdChilds(request.getQtdChilds());
            reserveRepository.save(reserve);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
