package com.codegym.casestudy3h1s.repository.role;

import com.codegym.casestudy3h1s.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.logging.LoggingPermission;
@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
