package com.br.csousa.organizationForAll.controllers;

import com.br.csousa.organizationForAll.models.request.RequestReserveCreate;
import com.br.csousa.organizationForAll.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/reserves")
@CrossOrigin(origins = "*")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @Secured({"ADMIN"})
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createReserve(@RequestBody(required = true) RequestReserveCreate request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(reserveService.createReserve(request));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Secured({"ADMIN"})
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<?> getAllReserves() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(reserveService.getAllReserves());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Secured({"ADMIN","USER"})
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getReserveById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(reserveService.getReserveById(id));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Secured({"ADMIN","USER"})
    @PutMapping(value = "/update/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateReserve(@PathVariable Long id, @RequestBody(required = true) RequestReserveCreate request) {
        try {
            reserveService.updateReserve(id, request);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }


}
