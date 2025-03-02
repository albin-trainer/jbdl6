package com.library.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.library.dto.BookDto;
import com.library.entity.Authour;
import com.library.entity.Book;
import com.library.entity.Genre;
import com.library.service.BookService;

@RestController
//@RequestMapping
public class BookCatalogue {
	@Autowired
	private BookService bookService;
@PostMapping("/authours")
public Authour addAuthour(@RequestBody Authour authour) {
	return bookService.addAuthour(authour);
}
@PostMapping("/books")
//@RequestBody ==> converts XML/JSON to Java object(Unmarshalling/ DeSerialization)
public Book addBook(@RequestBody  BookDto book) {
	
	return bookService.addBook(book);
}
public List<Book> searchByGenre2(Genre genre){
	return null;
}
public List<Book> allBooks(){
	return null;
}
public Page<Book> allBookswithPagination(int pageNo,int size){
	return null;
}
public List<Book> searchByAuthour(int authourId){
	return null;
}
public List<Book> searchByGenre(Genre genre){
	return null;
}
public Book updateBook(Book book,int bookId) {
	return null;
}
public void removeBook(int bookId) {
	return ;
}

public List<Book> searchByBookName(String bookName){
	return null;
}

}
