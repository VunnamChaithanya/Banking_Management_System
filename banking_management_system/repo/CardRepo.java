package com.qsp.banking_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.banking_management_system.dto.Card;

public interface CardRepo extends JpaRepository<Card, Integer> {

}
