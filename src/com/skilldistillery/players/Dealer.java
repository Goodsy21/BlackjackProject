package com.skilldistillery.players;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealer extends Player{
	private Deck deck;
	public Card dealCardUp(Player player) {
		Card card = deck.dealCard();
		player.receiveCard(card);
		return card;
	}
	public Deck getDeck() {
		deck.shuffle();
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
		deck.shuffle();
	}
	
	
}
