package com.bankapp.card_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.card_service.model.rest.Request;
import com.bankapp.card_service.model.rest.Response;
import com.bankapp.card_service.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RouterServices {
	
	@Autowired
	CardService crdServ;
	
	@Autowired
	TransactionService trxServ;

	public Response routRequest(Request request)
	{
		Response response = null;
		
		switch(request.getMessageId())
		{
			case Constants.CONST_ADD_NEW_CARD:
				log.info("Routing to : {} " , Constants.CONST_ADD_NEW_CARD);
				response = crdServ.addNewCard(request);
				break;
			case Constants.CONST_GET_ALL_CARD:
				log.info("Routing to : {} " , Constants.CONST_GET_ALL_CARD);
				response = crdServ.getAllCards(request);
				break;
			case Constants.CONST_GET_CARD_BY_CRDNO:
				log.info("Routing to : {} " , Constants.CONST_GET_CARD_BY_CRDNO);
				response = crdServ.getCardByCardNo(request);
				break;
			
		}
		
		
		log.info("Returning response : {} " , response);
		return response;
	}

}
