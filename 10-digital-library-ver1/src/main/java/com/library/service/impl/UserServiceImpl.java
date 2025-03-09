package com.library.service.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.BorrowBookDto;
import com.library.entity.Book;
import com.library.entity.Penalty;
import com.library.entity.Transaction;
import com.library.entity.User;
import com.library.repository.BookRepository;
import com.library.repository.PenaltyRepository;
import com.library.repository.TransactiionRepository;
import com.library.repository.UserRepository;
import com.library.service.UserService;
@Service
public class UserServiceImpl  implements UserService{
private UserRepository userRepo;
@Autowired
private BookRepository bookRepo;
@Autowired
private TransactiionRepository transRepo;
@Autowired
private PenaltyRepository penaltyRepo;

	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	@Override
	public User addNewUser(User u) {
		return userRepo.save(u);
	}

	@Override
	public Book borrowBook(BorrowBookDto borrowDto, String uname) {
		User user=userRepo.findById(borrowDto.getUserId()).orElseThrow(()-> new RuntimeException("user not found"));
		Book book=bookRepo.findById(borrowDto.getBookId()).orElseThrow(()-> new RuntimeException("Book not found"));
		Transaction t=new Transaction();
		t.setBorrowDate(LocalDate.now());
		t.setBook(book);
		t.setUser(user);
		t.setStatus("BORROWED"); //shud use ENUM
		book.setStock(book.getStock()-1);
		bookRepo.save(book);
		transRepo.save(t);
		return book;
	}

	@Override
	public Book returnBook(int tid) {
		Transaction t=transRepo.findById(tid).orElseThrow(()-> new RuntimeException("invalid transaction id") );
		//Book b=bookRepo.findById(t.getBook().getBookId()).orElseThrow(()-> new RuntimeException("incorrect id"));
		Book b=t.getBook();
		if(t.getStatus().equals("BORROWED")) {
	    //convert localdate into localtime
		LocalDateTime borrowedDate=t.getBorrowDate().atStartOfDay();
		Duration duration=Duration.between(borrowedDate, LocalDateTime.now());
		long dateDiff= duration.toDays();
		if(dateDiff>30) {
			int perDayFine=50;
			Penalty p=new Penalty();
			p.setAmount(perDayFine*(dateDiff-30));
			p.setNoOfDays((int)dateDiff);
			p.setRemarks("Late fees");
			t.setPenalty(p);
			penaltyRepo.save(p);
		}
		t.setReturnedDate(LocalDate.now());
		t.setStatus("RETURNED");
		b.setStock(b.getStock()+1);
		transRepo.save(t);
		}
		return b;
	}
	public boolean checkAvailability(int bookId) {
		Optional<Book> optional=bookRepo.findById(bookId);
		
				if(optional.isPresent()) {
					Book book=optional.get();
					if(book.getStock()>0)
						return true;
					return false;
				}
		
		throw new RuntimeException("Book not found");
	}

	@Override
	public List<Transaction> chkTransactionByUser(int userId) {
		return null;
	}

}
