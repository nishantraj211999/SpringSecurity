package com.example.SpringSecurity.Controller;

import com.example.SpringSecurity.Entity.Role;
import com.example.SpringSecurity.Service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PostExchange;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    // in real production this endpoint should be private
    private RoleService roleService;

    public RoleController(RoleService rs){
        this.roleService=rs;
    }

    @PostMapping
    public ResponseEntity<String>adRole(@RequestBody Role role){
        roleService.addRole(role);
        return ResponseEntity.ok("DONE");

    }
}
