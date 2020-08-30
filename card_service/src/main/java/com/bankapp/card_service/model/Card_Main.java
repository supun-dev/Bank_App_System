package com.bankapp.card_service.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class Card_Main {

	@JsonProperty("Status_Code")
	private int statusCode;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("Card_Serial_No")
	private Integer  cardSerialNo;
	
	@JsonProperty("Card_No")
	private String cardNo;
	
	@JsonProperty("Added_By")
	private String addedBy;
	
	@JsonProperty("Card_Type")
	private String cardType;
	
	@JsonProperty("Issue_Type")
	private String issueType;
	
	@JsonProperty("Modified_By")
	private String modifiedBy;
	
	@JsonProperty("Name_On_Card")
	private String nameOnCard;
	
	@JsonProperty("Primary_Acc_No")
	private String primaryAccNo;
	
	@JsonProperty("Issue_Date")
	private Date issueDate;
	
	@JsonProperty("Expire_Date")
	private Date expireDate;
	
	@JsonProperty("Added_Date")
	private Date addedDate;
	
	@JsonProperty("Modified_Date")
	private Date modifiedDate;
	
	
}
