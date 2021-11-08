package com.codegym.casestudy3h1s.service.user.userStatus;

import com.codegym.casestudy3h1s.model.entity.user.UserStatus;
import com.codegym.casestudy3h1s.repository.user.IUserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserStatusService implements IUserStatusService {
    @Autowired
    private IUserStatusRepository userStatusRepository;

    @Override
    public Iterable<UserStatus> findAll() {
        return userStatusRepository.findAll();
    }

    @Override
    public Page<UserStatus> findAll(Pageable pageable) {
        return userStatusRepository.findAll(pageable);
    }

    @Override
    public Optional<UserStatus> findById(Long id) {
        return userStatusRepository.findById(id);
    }

    @Override
    public UserStatus save(UserStatus userStatus) {
        return userStatusRepository.save(userStatus);
    }

    @Override
    public void remove(Long id) {
        userStatusRepository.deleteById(id);
    }
}
