package com.Bookmark.Bookmark.Application.Service;

import com.Bookmark.Bookmark.Application.Entity.BookmarkEntity;
import com.Bookmark.Bookmark.Application.Repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Transactional
    public BookmarkEntity createEntry(BookmarkEntity entry){
        return bookmarkRepository.save(entry);
    }


}
