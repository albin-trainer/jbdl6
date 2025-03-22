package com.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.library.dto.BookDto;
import com.library.entity.Authour;
import com.library.entity.Book;
import com.library.entity.Genre;
import com.library.exception.AuthourNotFoundException;
import com.library.repository.AuthourRepository;
import com.library.repository.BookRepository;
import com.library.service.BookService;

import jakarta.transaction.Transactional;
//@Component
@Service//more readable
@Transactional
public class BookServiceImpl implements BookService{
  @Autowired
	private AuthourRepository authRepo;
  @Autowired
    private BookRepository bookRepo;
	@Override
	public Authour addAuthour(Authour authour) {
		return authRepo.save(authour);
	}
	public Book addBook(BookDto book) {
	//	Optional<Authour> optional=	authRepo.findById(book.getAuthourId());
		//if(optional.isPresent()) {
			//Authour a=optional.get();
		//NoSuchElementException will occur here if authour id not found
		 //  Authour a=authRepo.findById(book.getAuthourId()).get();
		Authour a=authRepo.findById(book.getAuthourId()).
				orElseThrow(()-> new AuthourNotFoundException(book.getAuthourId() +" authour id Not found"));
			Book b=new Book();
//			b.setBookId(book.getBookId());
//			b.setBookName(book.getBookName());
//			b.setCost(book.getCost());
//			b.setGenre(book.getGenre());
//			b.setStock(book.getStock());
			BeanUtils.copyProperties(book, b);
			b.setAuthour(a);
			return bookRepo.save(b);
		//}
	//	else
		//{
		//throw new RuntimeException("Authour not found");
		//}
		//return null;
	}

	@Override
	public List<Book> searchByGenre2(Genre genre) {
		return null;
	}

	@Override
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	@Override
	public Page<Book> allBookswithPagination(int pageNo, int size) {
		Pageable page=PageRequest.of(pageNo, size);
		// TODO Auto-generated method stub
		return bookRepo.findAll(page);
	}

	@Override
	public List<Book> searchByAuthour(int authourId) {
		// TODO Auto-generated method stub
		return bookRepo.searchByAuthour(authourId);
	}

	@Override
	public List<Book> searchByGenre(Genre genre) {
		return bookRepo.findByGenre(genre);
	}

	@Override
	public Book updateBook(BookDto book, int bookId) {
	Book b=	bookRepo.findById(bookId).orElseThrow(()-> new  RuntimeException("Book "+bookId+" not found"));
	BeanUtils.copyProperties(book, b);
	bookRepo.save(b);
		return b;
	}
	@Override
	public void removeBook(int bookId) {
	}
	@Override
	public List<Book> searchByBookName(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int updateCost(int bookId, float cost) {
		return bookRepo.updateCost(bookId, cost);
	}

}
