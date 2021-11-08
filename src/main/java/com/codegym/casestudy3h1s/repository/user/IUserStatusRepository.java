package com.codegym.casestudy3h1s.repository.user;

import com.codegym.casestudy3h1s.model.entity.user.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserStatusRepository extends JpaRepository<UserStatus, Long> {
}
