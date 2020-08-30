package com.bankapp.card_service.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data
@Entity
@JsonInclude(Include.NON_NULL)
public class Card_Main {

	@Id
	@JsonProperty("Card_No")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cardNoSeq")
	@SequenceGenerator(name = "cardNoSeq", sequenceName = "card_main_card_no_seq", allocationSize = 1)
	private Long cardNo;
	
	@JsonProperty("Status_Code")
	private int statusCode;
	
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

	@Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = "";
        try {
            //mapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonString = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;
    }
}
