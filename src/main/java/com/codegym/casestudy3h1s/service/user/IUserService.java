package com.codegym.casestudy3h1s.service.user;

import com.codegym.casestudy3h1s.model.dto.UserPrincipal;
import com.codegym.casestudy3h1s.model.entity.User;
import com.codegym.casestudy3h1s.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User findByUsername(String username);

    User findByEmail(String email);
}
