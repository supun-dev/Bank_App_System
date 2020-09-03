package com.bankapp.card_service.services;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.card_service.model.CardListResp;
import com.bankapp.card_service.model.Card_Main;
import com.bankapp.card_service.model.rest.Request;
import com.bankapp.card_service.model.rest.Response;
import com.bankapp.card_service.repo.CardMainRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CardService {

	@Autowired
	private CardMainRepo cardMainRepo;
	
	@Autowired
	private CardListResp cardListResp;

	public Response addNewCard(Request request) {

		log.info("Inside CardService =====> addNewCard ");

		Response response = new Response();
		Card_Main newCardReq = (Card_Main) request.getMessageContent();

		Date currentDate = new Date();

		newCardReq.setIssueDate(currentDate);
		newCardReq.setAddedDate(currentDate);
		newCardReq.setModifiedDate(currentDate);
		newCardReq.setExpireDate(DateUtils.addYears(currentDate, 3));

		cardMainRepo.save(newCardReq);

		response.setStatusCode(1);
		response.setResponse(newCardReq);

		return response;
	}

	public Response getAllCards(Request request) {

		log.info("Inside CardService =====> getAllCards ");

		Response response = new Response();

		List<Card_Main> listCardMain = cardMainRepo.findAll();
		cardListResp.setListCards(listCardMain);

		response.setStatusCode(1);
		response.setResponse(cardListResp);

		return response;
	}

	public Response getCardByCardNo(Request request) {

		log.info("Inside CardService =====> getCardByCardNo ");

		Response response = new Response();
		Long cardNo = (Long) request.getMessageContent();

		Card_Main cardMain = cardMainRepo.findById(cardNo).get();	
		response.setStatusCode(1);
		response.setResponse(cardMain);

		return response;
	}

}
