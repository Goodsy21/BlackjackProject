package com.skilldistillery.cardgame;

import java.util.ArrayList;

import com.skilldistillery.cards.Card;

public class BlackjackHand extends Hand {
	public boolean isBlackjack() {
		if(getHandValue()==21) {
			System.out.println("BlackJack! You win!");
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public int getHandValue() {
		int total = 0;
		for (Card card : cardList) {
			total += card.getValue();
			
		}
		return total; 
	}
	public boolean isBust() {
		int handValue = getHandValue();
		if (handValue >= 22) {
			return true;}
		else {
			return false;
		}
	}
	public void showDealerHand() {
		System.out.println("Dealer has" + cardList.get(0));
		System.out.println("DOWN CARD");
	}
	public BlackjackHand() {
		cardList = new ArrayList<>();
	}
	public void showPlayerHand() {
		System.out.println("Player has");
		for (Card card : cardList) {
			System.out.println(card);
	}}
	public void revealDealerHand() {
		System.out.println("Dealer has");
		for (Card card : cardList) {
			System.out.println(card);
		}
		
	}
}
