package com.Bookmark.Bookmark.Application.Service;


import com.Bookmark.Bookmark.Application.Entity.BookmarkEntity;
import com.Bookmark.Bookmark.Application.Repository.BookmarkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@Service
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    // create Book
    public BookmarkEntity createBook(BookmarkEntity entry){
        return bookmarkRepository.save(entry);
    }

    // Get All Book
    public List<BookmarkEntity> getAllBook(){
        return bookmarkRepository.findAll();
    }

    // Get BookById
    public Optional<BookmarkEntity> getBookById(long id){
        return bookmarkRepository.findById(id);
    }

    // Delete Book
    public boolean deleteBookById(long id){
        bookmarkRepository.deleteById(id);
        return true;
    }

    // Update Book
    public BookmarkEntity updateBook(long id,BookmarkEntity updateBook){
        return bookmarkRepository.findById(id).map(existingBookmark -> {
            existingBookmark.setTitle(updateBook.getTitle());
            existingBookmark.setContent(updateBook.getContent());
            return bookmarkRepository.save(existingBookmark);
        }).orElse(null);
    }

}