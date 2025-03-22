package com.library.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@PreAuthorize("hasAuthority('admin')")
@PostMapping("/authours")
public Authour addAuthour(@RequestBody Authour authour) {
	return bookService.addAuthour(authour);
}
	@PreAuthorize("hasAuthority('admin')")
@PostMapping("/books")
//@RequestBody ==> converts XML/JSON to Java object(Unmarshalling/ DeSerialization)
public Book addBook(@RequestBody  BookDto book) {
	
	return bookService.addBook(book);
}
	@PreAuthorize("hasAnyAuthority('admin','user')")
@GetMapping("/searchbygenre")
public List<Book> searchByGenre2(@RequestParam("genre")  Genre genre){
	return bookService.searchByGenre(genre);
}
	@PreAuthorize("hasAnyRole('admin','user')")
@GetMapping("/books")
public List<Book> allBooks(){
	return bookService.allBooks();
}
	@PreAuthorize("hasAnyRole('admin','user')")
  @GetMapping("/books/query")
	public Page<Book> allBookswithPagination( @RequestParam("pgno") int pageNo,@RequestParam("size")int size){
	return bookService.allBookswithPagination(pageNo, size);
}
@GetMapping("/searchbyauthour")
public   ResponseEntity<List<Book>> searchByAuthour(@RequestParam("authourId")  int authourId){
	  List<Book> books= bookService.searchByAuthour(authourId);
	  if(books.size()>0)		  
	      return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	   return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
}
public List<Book> searchByGenre(Genre genre){
	return null;
}
@PutMapping("/books/{bookId}")
public BookDto updateBook(@RequestBody  BookDto book, @PathVariable("bookId") int bookId) {
	bookService.updateBook(book, bookId);
	return book;
}
@PatchMapping("/books/{bookId}/{cost}")
public int updateCost( @PathVariable("bookId") int bookId, @PathVariable("cost") float cost) {
	return bookService.updateCost(bookId, cost);
}
public void removeBook(int bookId) {
	return ;
}

public List<Book> searchByBookName(String bookName){
	return null;
}

}
