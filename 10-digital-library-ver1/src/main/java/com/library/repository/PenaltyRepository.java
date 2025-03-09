package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.Penalty;

public interface PenaltyRepository  extends  JpaRepository<Penalty, Integer> {

}
