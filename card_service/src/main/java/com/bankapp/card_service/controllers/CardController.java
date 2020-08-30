package com.bankapp.card_service.controllers;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public Response addNewCard(@RequestBody Card_Main newCardReq)
	{
		log.info("----- Preparing to add a new card {} " , newCardReq );
		
		Date currentDate = new Date();
		
		newCardReq.setIssueDate(currentDate);
		newCardReq.setAddedDate(currentDate);
		newCardReq.setModifiedDate(currentDate);	
		newCardReq.setExpireDate(DateUtils.addYears(currentDate, 3));
		
		cardMainRepo.save(newCardReq);
		
		response.setStatusCode(1);
		response.setResponse(newCardReq);
		
		log.info("----- Card details retrieved from database : {} " , newCardReq );
		return response;
	}
	
	@GetMapping("/getAllCards")
	public Response getAllCards()
	{
		log.info("----- Preparing to retrieve card list from database.");
		
		List<Card_Main> listCardMain = cardMainRepo.findAll();
		response.setStatusCode(1);
		response.setResponse(listCardMain);
		
		log.info("----- Card list retrieved from database : {} " , listCardMain );
		return response;
	}
	
	@GetMapping("/getCardByCardNo/{cardNo}")
	public Response getAllCards(@PathVariable("cardNo") Long cardNo)
	{
		log.info("----- Obtaining card details for card number {} " , cardNo );
		
		Card_Main cardMain = cardMainRepo.findById(cardNo).get();	
		response.setStatusCode(1);
		response.setResponse(cardMain);
		
		log.info("----- Card details retrieved from database : {} " , cardMain );
		return response;
	}
	
}
