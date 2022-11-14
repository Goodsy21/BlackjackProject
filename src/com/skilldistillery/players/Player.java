package com.skilldistillery.players;

import com.skilldistillery.cardgame.BlackjackHand;
import com.skilldistillery.cards.Card;

public class Player {
	private BlackjackHand hand = new BlackjackHand();

	public void receiveCard(Card card) {
		getHand().addCard(card);
		getHand().getHandValue();
		System.out.println();
	}

	public BlackjackHand getHand() {
		return hand;
	}

	public void setHand(BlackjackHand hand) {
		this.hand = hand;
	}
	
}
