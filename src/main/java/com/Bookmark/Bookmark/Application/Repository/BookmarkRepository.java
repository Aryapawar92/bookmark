package com.Bookmark.Bookmark.Application.Repository;

import com.Bookmark.Bookmark.Application.Entity.BookmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<BookmarkEntity,String> {
}
