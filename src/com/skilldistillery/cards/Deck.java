package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	//has-a / composition / association
	private List<Card> cards;
	
	public Deck() {
		cards = makeDeck();
		}
	
		private List<Card> makeDeck(){
			List<Card> deck = new ArrayList<>(52);
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }
        return deck;
    }
		public int checkDeckSize() {
			return cards.size();
		}
		public void shuffle() {
			Collections.shuffle(cards);
		}
		public Card dealCard() {
			return cards.remove(0);
		}
}
