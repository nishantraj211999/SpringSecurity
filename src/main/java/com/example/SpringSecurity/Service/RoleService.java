package com.example.SpringSecurity.Service;

import com.example.SpringSecurity.Entity.Role;
import com.example.SpringSecurity.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository repository;

    public RoleService(RoleRepository rr){
        this.repository=rr;
    }
    public void addRole(Role role){
      repository.save(role);
    }
}
