package com.codegym.casestudy3h1s.model.entity.user;

import com.codegym.casestudy3h1s.model.entity.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @ManyToMany
    private Set<Role> roles;

    @OneToOne
    private UserProfile userProfile;

    @ManyToOne
    private UserStatus userStatus;

}
