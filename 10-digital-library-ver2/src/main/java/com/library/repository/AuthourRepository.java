package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.Authour;

public interface AuthourRepository extends JpaRepository<Authour, Integer>{

}
