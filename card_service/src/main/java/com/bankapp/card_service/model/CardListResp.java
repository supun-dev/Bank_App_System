package com.bankapp.card_service.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CardListResp {

	private List<Card_Main> listCards;
}
