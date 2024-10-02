package com.qsp.banking_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.banking_management_system.dto.Atm;

public interface AtmRepo extends JpaRepository<Atm, Integer> {

}
