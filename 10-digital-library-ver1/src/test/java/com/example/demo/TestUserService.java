package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.library.entity.Book;
import com.library.entity.Penalty;
import com.library.entity.Transaction;
import com.library.repository.BookRepository;
import com.library.repository.PenaltyRepository;
import com.library.repository.TransactiionRepository;
import com.library.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestUserService {
	@Mock
private BookRepository bookRepo;
	@Mock
	private TransactiionRepository transRepo;
	@Mock
	private PenaltyRepository penaltyRepo;
	@InjectMocks
private UserServiceImpl userService;
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this); //initialize mocks and injects 
	}
	@Test
	public void testCheckAvailabilityWithTrue() {
		Book mockBook=new Book();
		mockBook.setBookId(101);
		mockBook.setBookName("Testbook");
		mockBook.setCost(100);
		mockBook.setStock(10);
		//PRE-CONDITION for mocks
		when(bookRepo.findById(101)).thenReturn(Optional.of(mockBook));
		boolean result=userService.checkAvailability(101);
		assertEquals(true,result);
		
		//to ensure bookRepo.findById(101) is called exactly 1 time in the service
		verify(bookRepo,times(1)).findById(101);
	}
	@Test
	public void testCheckAvailabilityWithFalse() {
		Book mockBook=new Book();
		mockBook.setBookId(101);
		mockBook.setBookName("Testbook");
		mockBook.setCost(100);
		mockBook.setStock(0);
		//PRE-CONDITION for mocks
		when(bookRepo.findById(101)).thenReturn(Optional.of(mockBook));
		boolean result=userService.checkAvailability(101);
		assertEquals(false,result);
	}
	@Test
	public void testReturnBook() {
		Transaction mockTransaction= new Transaction();
		mockTransaction.setTransactionId(1);
		mockTransaction.setBorrowDate(LocalDate.of(2025, 2, 5));//Feb 5
		mockTransaction.setStatus("BORROWED");
		
		Book mockBook=new Book();
		mockBook.setBookId(101);
		mockBook.setBookName("Testbook");
		mockBook.setCost(100);
		mockBook.setStock(10);
		
		mockTransaction.setBook(mockBook);
		when(transRepo.findById(1)).thenReturn(Optional.of(mockTransaction));
		Book b= userService.returnBook(1);
		assertEquals(11, b.getStock());
		Penalty p=mockTransaction.getPenalty();
		assertEquals(100, p.getAmount());
		assertEquals("RETURNED", mockTransaction.getStatus());
		assertEquals("Late fees", p.getRemarks());
		
	    verify(transRepo,times(1)).findById(1);
	}
}
