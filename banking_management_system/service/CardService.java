package com.qsp.banking_management_system.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.banking_management_system.dao.CardDao;
import com.qsp.banking_management_system.dto.Card;
import com.qsp.banking_management_system.exception.cardIdNotFound;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;

@Service
public class CardService {
	@Autowired
	CardDao cardDao;
	@Autowired
	ResponseStructure<Card> responseStructure;
    @Autowired
    ResponseStructureList<Card> responseStructureList;
	public ResponseStructure<Card>  saveCard(Card card) {
		responseStructure.setMessage("Successfully card inserted in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(cardDao.saveCard(card));
		return responseStructure;
	}
	public ResponseStructure<Card> fetchCardById(int cardId) {
		Card card=cardDao.fetchCardById(cardId);
		if(card!=null) {
		responseStructure.setMessage("Successfully card fetched from DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(cardDao.fetchCardById(cardId));
		return responseStructure;
		}else {
			throw new cardIdNotFound();
		}
	}
	public ResponseStructure<Card>  updateCardById(int oldId,Card newCard) {
		Card card=cardDao.fetchCardById(oldId);
		if(card!=null) {
		responseStructure.setMessage("Successfully card updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(cardDao.upateCardById(oldId, newCard));
		return responseStructure;
		}
		else {
			throw new cardIdNotFound();
		}
	}
	public ResponseStructure<Card>  deleteCardById(int cardId) {
		Card card=cardDao.fetchCardById(cardId);
		if(card!=null) {
		responseStructure.setMessage("Successfully card deleted in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(cardDao.deleteCardById(cardId));
		return responseStructure;
		}
		else {
			throw new cardIdNotFound();
		}
	}
	public ResponseStructureList<Card> fetchAllCards(){
		responseStructureList.setMessage("Successfully fetched all cards from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(cardDao.fetchAllCards());
	    return responseStructureList ;
	}
	
}
