package com.codegym.casestudy3h1s.service.role;

import com.codegym.casestudy3h1s.model.entity.Role;
import com.codegym.casestudy3h1s.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
