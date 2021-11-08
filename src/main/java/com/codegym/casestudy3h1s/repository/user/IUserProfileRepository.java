package com.codegym.casestudy3h1s.repository.user;

import com.codegym.casestudy3h1s.model.entity.user.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserProfileRepository extends JpaRepository<UserProfile, Long> {
}
