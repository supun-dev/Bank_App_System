package com.bankapp.card_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.card_service.model.Card_Main;
import com.bankapp.card_service.model.Response;
import com.bankapp.card_service.repo.CardMainRepo;

@RestController
@RequestMapping("/card_service")
public class CardController {

	@Autowired
	private CardMainRepo cardMainRepo;
	
	@Autowired
	private Response response;
	
	@PostMapping("/addNewCard")
	public Card_Main addNewCard()
	{
		Card_Main cardMain = new Card_Main();
		cardMain.setAddedBy("ABC");
		cardMainRepo.save(cardMain);
		return cardMain;
	}
	
	@GetMapping("/getAllCards")
	public Response getAllCards()
	{
		List<Card_Main> listCardMain = cardMainRepo.findAll();
		
		response.setStatusCode(1);
		response.setResponse(listCardMain);
		return response;
	}
	
}
