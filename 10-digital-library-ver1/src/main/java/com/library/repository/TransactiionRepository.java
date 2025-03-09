package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.Transaction;

public interface TransactiionRepository  extends JpaRepository<Transaction, Integer>{

}
