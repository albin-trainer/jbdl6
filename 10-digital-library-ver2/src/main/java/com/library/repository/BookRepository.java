package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.entity.Book;
import com.library.entity.Genre;

public interface BookRepository  extends JpaRepository<Book, Integer>{
List<Book> findByGenre(Genre g);
@Query(value = "select * from book where  authour_authour_id= :id",nativeQuery = true)
List<Book> searchByAuthour(@Param("id")  int aid);

@Query(value = "update Book b set b.cost= :c where b.bookId= :id")
@Modifying
int updateCost( @Param("id") int bookId,  @Param("c") float cost);
}
