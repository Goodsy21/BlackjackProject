package com.skilldistillery.cardgame;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public abstract class Hand {
	protected List <Card> cardList;
	public void addCard(Card card){
		cardList.add(card);
	}
	public void clear() {
		cardList = new ArrayList<Card>();
	}
	
	public abstract int getHandValue();
	@Override
	public String toString() {
		return cardList + ", getHandValue()=" + getHandValue() + ".";
	}
	public void showHand() {
		for (Card card : cardList) {
			System.out.println(card);
			
		}
		
	}
	
	
}
