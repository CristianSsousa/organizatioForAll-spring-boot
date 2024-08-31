package com.br.csousa.organizationForAll.controllers;

import com.br.csousa.organizationForAll.models.request.RequestLocalCreate;
import com.br.csousa.organizationForAll.services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/locals")
@CrossOrigin(origins = "*")
public class LocalController {

    @Autowired
    private LocalService localService;


    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    @Secured("ADMIN")
    public ResponseEntity<?> createLocal(@RequestBody(required = true)  RequestLocalCreate request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(localService.createLocal(request));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping(value = "/all", produces = "application/json")
    @Secured("ADMIN")
    public ResponseEntity<?> getAllLocals() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(localService.getAllLocals());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Secured({"ADMIN","USER"})
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getLocalById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(localService.getLocalById(id));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
