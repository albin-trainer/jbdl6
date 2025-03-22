package com.library.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.library.dto.BookDto;
import com.library.entity.Authour;
import com.library.entity.Book;
import com.library.entity.Genre;
//CRUD operations
public interface BookService {
Authour addAuthour(Authour authour);
Book addBook(BookDto book);
List<Book> searchByGenre2(Genre genre);
List<Book> allBooks();
Page<Book> allBookswithPagination(int pageNo,int size);
List<Book> searchByAuthour(int authourId);
List<Book> searchByGenre(Genre genre);
Book updateBook(BookDto book,int bookId);
void removeBook(int bookId);

List<Book> searchByBookName(String bookName);
public int updateCost(int bookId, float cost);
}
