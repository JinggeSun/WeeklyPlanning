package com.sun.restFulApi.repository;

import com.sun.restFulApi.entity.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "/books",collectionResourceRel = "books")
public interface BookRestRepository extends PagingAndSortingRepository<Book,Long> {

    @Override
    @RestResource(exported = false)
    default void delete(Book book) {
        delete(book.getId());
    }
    @Modifying
    @Query("update Book set status = false where id=:id")
    void delete(@Param("id") Long id);


    @RestResource(path = "authors",rel = "authors")
    Book findBookByAuthor(@Param("author") String author);
}
