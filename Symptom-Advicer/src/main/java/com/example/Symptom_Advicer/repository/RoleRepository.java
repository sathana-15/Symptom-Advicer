package com.example.Symptom_Advicer.repository;

import com.example.Symptom_Advicer.model.Roles;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface RoleRepository extends CrudRepository<Roles, Long> {
    Optional<Roles> findByRoleName(String roleName);
}
