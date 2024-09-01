package com.br.csousa.organizationForAll.services;

import com.br.csousa.organizationForAll.models.Local;
import com.br.csousa.organizationForAll.models.request.RequestLocalCreate;
import com.br.csousa.organizationForAll.models.response.ResponseLocal;
import com.br.csousa.organizationForAll.repositorys.LocalRepository;
import com.br.csousa.organizationForAll.repositorys.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private ReserveRepository reserveRepository;

    public Local createLocal(RequestLocalCreate request) {
        Local local = builderLocal(request);
        return localRepository.save(local);
    }

    public Local findById(Long localId) {
        return localRepository.findById(localId).orElseThrow(() -> new RuntimeException("Local not found"));
    }

    public List<ResponseLocal> getAllLocals() {
        return localRepository.findAll().stream().map(this::builderResponseLocal).toList();
    }

    public Local getLocalById(Long id) {
        return localRepository.findById(id).orElseThrow(() -> new RuntimeException("Local not found"));
    }

    public ResponseLocal builderResponseLocal(Local local) {
        return ResponseLocal.builder()
                .name(local.getName())
                .capacity(local.getCapacity())
                .createdAt(local.getCreatedAt())
                .reserves(reserveRepository.findByLocal(local))
                .build();
    }

    private Local builderLocal(RequestLocalCreate request) {
        return Local.builder()
                .name(request.getName())
                .capacity(request.getCapacity())
                .createdAt(LocalDateTime.now())
                .build();
    }



}
