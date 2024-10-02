package com.qsp.banking_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.banking_management_system.dto.Card;
import com.qsp.banking_management_system.service.CardService;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;
@RestController
public class CardController {
	@Autowired
	CardService cardService;
	
	@PostMapping("/saveCard")
	public ResponseStructure<Card> saveCard(@RequestBody Card card) {
		return cardService.saveCard(card);
	}
	@GetMapping("/fetchCardById")
	public ResponseStructure<Card> fetchCardById(@RequestParam int cardId) {
		return cardService.fetchCardById(cardId);
	}
	@PutMapping("/updateCardById")
	public ResponseStructure<Card> updateCardById(@RequestParam int oldId,@RequestBody Card newCard) {
		return cardService.updateCardById(oldId, newCard);
	}
	@DeleteMapping("/deleteCardById")
	public ResponseStructure<Card> deleteCardById(@RequestParam int cardId) {
		return cardService.deleteCardById(cardId);
	}
	@GetMapping("/fetchAllCards")
	public ResponseStructureList<Card> fetchAllCards() {
		return cardService.fetchAllCards();
	}
}
