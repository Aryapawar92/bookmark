package com.Bookmark.Bookmark.Application.Controller;

import com.Bookmark.Bookmark.Application.Entity.UserEntity;
import com.Bookmark.Bookmark.Application.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor

@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
        UserEntity record = userService.createUser(user);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserEntity>> getAllUser(){
        List<UserEntity> recordsList = userService.getAllUser();
        return ResponseEntity.ok(recordsList);
    }
}
