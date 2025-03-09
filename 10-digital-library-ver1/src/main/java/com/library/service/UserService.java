package com.library.service;

import java.util.List;

import com.library.dto.BorrowBookDto;
import com.library.entity.Book;
import com.library.entity.Transaction;
import com.library.entity.User;

public interface UserService {
	User addNewUser(User u);
	//need later....
    Book borrowBook(BorrowBookDto borrowDto, String uname);
	Book returnBook(int tid);
	boolean checkAvailability(int bookId);
	List<Transaction>  chkTransactionByUser(int userId);
}
