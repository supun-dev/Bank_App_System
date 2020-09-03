package com.bankapp.card_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.card_service.model.CardListResp;
import com.bankapp.card_service.model.Card_Main;
import com.bankapp.card_service.model.rest.Request;
import com.bankapp.card_service.model.rest.Response;
import com.bankapp.card_service.services.RouterServices;
import com.bankapp.card_service.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/card_service")
public class CardController {

	@Autowired
	RouterServices routerService;
	
	@PostMapping("/addNewCard")
	public Card_Main addNewCard(@RequestBody Card_Main newCardReq)
	{
		log.info("----- Preparing to add a new card {} " , newCardReq );
		
		Request request = new Request();
		request.setMessageId(Constants.CONST_ADD_NEW_CARD);
		request.setMessageContent(newCardReq);
	
		Response response = routerService.routRequest(request);
		Card_Main cardResp = (Card_Main) response.getResponse();
		
		log.info("----- Card details retrieved from database : {} " , cardResp );
		return cardResp;
	}
	
	@GetMapping("/getAllCards")
	public CardListResp getAllCards()
	{
		log.info("----- Preparing to retrieve card list from database.");
		
		Request request = new Request();
		request.setMessageId(Constants.CONST_GET_ALL_CARD);
		
		Response response = routerService.routRequest(request);
		CardListResp cardListResp = (CardListResp) response.getResponse();
		
		log.info("----- Card list retrieved from database : {} " , cardListResp );
		return cardListResp;
	}
	
	@GetMapping("/getCardByCardNo/{cardNo}")
	public Card_Main getAllCards(@PathVariable("cardNo") Long cardNo)
	{
		log.info("----- Obtaining card details for card number {} " , cardNo );
		
		Request request = new Request();
		request.setMessageId(Constants.CONST_GET_CARD_BY_CRDNO);
		request.setMessageContent(cardNo);
		
		Response response = routerService.routRequest(request);
		Card_Main cardMainResp = (Card_Main) response.getResponse();
		
		log.info("----- Card details retrieved from database : {} " , cardMainResp );
		return cardMainResp;
	}
	
}
