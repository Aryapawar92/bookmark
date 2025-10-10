package com.Bookmark.Bookmark.Application.Controller;


import com.Bookmark.Bookmark.Application.Entity.BookmarkEntity;
import com.Bookmark.Bookmark.Application.Service.BookmarkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor

public class BookmarkController{

    private final BookmarkService bookmarkService;

    @PostMapping
    public ResponseEntity<BookmarkEntity> createBookmark(@RequestBody BookmarkEntity bookmarkEntity){
        BookmarkEntity record = bookmarkService.createBook(bookmarkEntity);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookmarkEntity>> getAllBookmark(){
        List<BookmarkEntity> bookmarkEntityList = bookmarkService.getAllBook();
        return ResponseEntity.ok(bookmarkEntityList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookmarkEntity> getBookmarkById(@PathVariable Long id){
        return bookmarkService.getBookById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookmark(@PathVariable long id){
        bookmarkService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookmarkEntity> updateBookmark(@PathVariable long id,@RequestBody BookmarkEntity newEntry){
        BookmarkEntity updated =  bookmarkService.updateBook(id,newEntry);

        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }

    }


}