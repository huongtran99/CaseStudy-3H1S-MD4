package com.codegym.casestudy3h1s.service.user.userStatus;

import com.codegym.casestudy3h1s.model.entity.user.UserStatus;
import com.codegym.casestudy3h1s.service.IGeneralService;
import com.codegym.casestudy3h1s.service.user.users.UserService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserStatusService extends IGeneralService<UserStatus> {
}
