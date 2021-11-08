package com.codegym.casestudy3h1s.service.user.users;

import com.codegym.casestudy3h1s.model.entity.user.User;
import com.codegym.casestudy3h1s.service.IGeneralService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);

    User getUserFromJwt(Authentication authentication);
}
