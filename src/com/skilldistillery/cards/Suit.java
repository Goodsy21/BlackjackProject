package com.skilldistillery.cards;

public enum Suit {
	HEARTS("\u2665"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	
	private String name;
	Suit(String name){
		this.name = name;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
	
	
	
}
