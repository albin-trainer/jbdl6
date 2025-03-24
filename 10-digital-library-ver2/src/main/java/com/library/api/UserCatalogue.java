package com.library.api;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.BorrowBookDto;
import com.library.entity.Book;
import com.library.entity.Transaction;
import com.library.entity.User;
import com.library.secure.repo.UserRepository;
import com.library.service.UserService;
@RestController
@RequestMapping("/users")
public class UserCatalogue {
	@Autowired
	private UserService userService;
	@Autowired
	UserRepository userRepo; //not a good practice to call repo directly from rest api
//	@PostMapping
//	public User addNewUser(@RequestBody User u) {
//		return userService.addNewUser(u);
//	}
	//need later....
	@PreAuthorize("hasAuthority('user')")
	@PostMapping("/borrowbook")
    public Book borrowBook(@RequestBody int bookId, Principal p) {
		String userName=p.getName();
		User user=userRepo.findByUserName(userName);
		BorrowBookDto borrowDto=new BorrowBookDto();
		borrowDto.setUserId(user.getUserId());
		borrowDto.setBookId(bookId);
    	return userService.borrowBook(borrowDto);
    }
	@PutMapping("/returnbook/{tid}")
	public Book returnBook(@PathVariable("tid") int tid) {
		return userService.returnBook(tid);
	}
	public boolean checkAvailability(int bookId) {
		return false;
	}
	public List<Transaction>  chkTransactionByUser(int userId){
		return null;
	}
}
