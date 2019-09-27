package com.sun.restFulApi.repository;

import com.sun.restFulApi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zcm
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
