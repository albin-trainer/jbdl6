package com.example.service;

import com.example.dto.UserDto;

public interface TransactionService {
UserDto getBalance(int uid);
}
