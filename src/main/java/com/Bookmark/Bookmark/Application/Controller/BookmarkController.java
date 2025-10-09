package com.Bookmark.Bookmark.Application.Controller;

import com.Bookmark.Bookmark.Application.Entity.BookmarkEntity;
import com.Bookmark.Bookmark.Application.Service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;


    @PostMapping("/create")
    public BookmarkEntity createRecord(@RequestBody BookmarkEntity entry){

        return bookmarkService.createEntry(entry);
    }
}
