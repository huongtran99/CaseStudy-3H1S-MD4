package com.codegym.casestudy3h1s.service.user.userProfile;

import com.codegym.casestudy3h1s.model.entity.user.UserProfile;
import com.codegym.casestudy3h1s.repository.user.IUserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserProfileService implements IUserProfileService{
    @Autowired
    private IUserProfileRepository userProfileRepository;
    @Override
    public Iterable<UserProfile> findAll() {
        return userProfileRepository.findAll();
    }

    @Override
    public Page<UserProfile> findAll(Pageable pageable) {
        return userProfileRepository.findAll(pageable);
    }

    @Override
    public Optional<UserProfile> findById(Long id) {
        return userProfileRepository.findById(id);
    }

    @Override
    public UserProfile save(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @Override
    public void remove(Long id) {
        userProfileRepository.deleteById(id);
    }
}
