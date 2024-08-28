package com.br.csousa.organizationForAll.services;

import com.br.csousa.organizationForAll.models.Local;
import com.br.csousa.organizationForAll.models.request.RequestLocalCreate;
import com.br.csousa.organizationForAll.repositorys.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    public Local createLocal(RequestLocalCreate request) {
        Local local = builderLocal(request);
        return localRepository.save(local);
    }

    public Local findById(Long localId) {
        return localRepository.findById(localId).orElseThrow(() -> new RuntimeException("Local not found"));
    }

    private Local builderLocal(RequestLocalCreate request) {
        return Local.builder()
                .name(request.getName())
                .capacity(request.getCapacity())
                .createdAt(LocalDateTime.now())
                .build();
    }


    public List<Local> getAllLocals() {
        return localRepository.findAll();
    }

    public Local getLocalById(Long id) {
        return localRepository.findById(id).orElseThrow(() -> new RuntimeException("Local not found"));
    }
}
