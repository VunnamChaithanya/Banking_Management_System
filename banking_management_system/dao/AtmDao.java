package com.qsp.banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_management_system.dto.Atm;
import com.qsp.banking_management_system.repo.AtmRepo;

@Repository
public class AtmDao {
	@Autowired
	AtmRepo atmRepo;
	
	public Atm saveAtm(Atm atm) {
		return atmRepo.save(atm);
	}
	public Atm fetchAtmById(int atmId) {
		Optional<Atm> atm= atmRepo.findById(atmId);
		if(atm.isPresent()) {
			return atm.get();
		}
		else {
			return null;
		}
	}
	public Atm upateAtmById(int oldId, Atm newAtm) {
		newAtm.setAtmId(oldId);
		return atmRepo.save(newAtm);
	}
	public Atm deleteAtmById(int atmId) {
		Atm atm=atmRepo.findById(atmId).get();
		atmRepo.delete(atm);
		return atm;
	}
	public List<Atm> fetchAllAtms() {
		return atmRepo.findAll();
	}
}
