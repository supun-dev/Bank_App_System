package com.bankapp.card_service.repo;

import com.bankapp.card_service.model.Card_Main;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardMainRepo extends JpaRepository<Card_Main, Long> {

}
