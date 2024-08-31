package com.br.csousa.organizationForAll.controllers;

import com.br.csousa.organizationForAll.models.request.RequestUserCreate;
import com.br.csousa.organizationForAll.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Secured({"ADMIN","USER"})
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody RequestUserCreate requestUserCreate) {
        try {
            userService.save(requestUserCreate);
            return ResponseEntity.ok().body("User created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

}
