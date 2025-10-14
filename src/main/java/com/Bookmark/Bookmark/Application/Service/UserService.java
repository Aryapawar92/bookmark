package com.Bookmark.Bookmark.Application.Service;

import com.Bookmark.Bookmark.Application.Entity.UserEntity;
import com.Bookmark.Bookmark.Application.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserEntity createUser(UserEntity entry){
        return userRepository.save(entry);
    }

    public List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(Long id){
        return userRepository.findById(id);
    }

    public boolean deleteUserById(Long id){
        userRepository.deleteById(id);
        return true;
    }

    public UserEntity updateUser(Long id,UserEntity updatedUser){
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            return userRepository.save(existingUser);
        }).orElse(null);
    }


}
