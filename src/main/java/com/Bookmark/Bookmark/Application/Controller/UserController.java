package com.Bookmark.Bookmark.Application.Controller;

import com.Bookmark.Bookmark.Application.Entity.BookmarkEntity;
import com.Bookmark.Bookmark.Application.Entity.UserEntity;
import com.Bookmark.Bookmark.Application.Service.UserService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
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

    @GetMapping("/search/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id){
        return userService.getUserById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id,@RequestBody UserEntity entry){
        UserEntity updated =  userService.updateUser(id,entry);

        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
