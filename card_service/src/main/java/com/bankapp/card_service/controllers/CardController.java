package com.bankapp.card_service.controllers;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.card_service.model.Card_Main;
import com.bankapp.card_service.model.Response;
import com.bankapp.card_service.repo.CardMainRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/card_service")
public class CardController {

	@Autowired
	private CardMainRepo cardMainRepo;
	
	@Autowired
	private Response response;
	
	@PostMapping("/addNewCard")
	public Card_Main addNewCard(@RequestBody Card_Main newCardReq)
	{
		log.info("Add New Card Request \n {} " , newCardReq );
		
		Date currentDate = new Date();
		
		newCardReq.setIssueDate(currentDate);
		newCardReq.setAddedDate(currentDate);
		newCardReq.setModifiedDate(currentDate);	
		newCardReq.setExpireDate(DateUtils.addYears(currentDate, 3));
		
		cardMainRepo.save(newCardReq);
		log.info("Add New Card Request \n {} " , newCardReq );
		return newCardReq;
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
