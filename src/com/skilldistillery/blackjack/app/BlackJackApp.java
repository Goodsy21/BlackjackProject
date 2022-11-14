package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.cardgame.BlackjackHand;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.players.Dealer;
import com.skilldistillery.players.Player;

public class BlackJackApp {

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.run();
		try (Scanner sc = new Scanner(System.in)) {
			Dealer dealer = new Dealer();
			Player player = new Player();
			dealer.setDeck(new Deck());
			dealer.getDeck().shuffle();
			int playAnswer = 0;

			System.out.println("Welcome to BlackJack\nWant to play a hand? \n1 - Yes \n2 - No");
			playAnswer = sc.nextInt();

			do {
				if (playAnswer == 1) {
					dealNewHand(player, dealer);
				} else {
					System.out.println("Have a great day");
					System.exit(0);
				}
				reshuffleIfNeeded(dealer);
				if(!player.getHand().isBlackjack()) {
					playerTurn(dealer, player);
				}
				dealerTurn(dealer);
				checkWinner(dealer, player);
				System.out.println("Want to play again? \n1 - Yes \n2 - No");
				playAnswer = sc.nextInt();
			} while (playAnswer == 1);
		}
	}

	private static void checkWinner(Dealer dealer, Player player) {
		dealer.getHand().revealDealerHand();
		player.getHand().showPlayerHand();
		if (dealer.getHand().isBlackjack() && player.getHand().isBlackjack()) {
			System.out.println("Blackjacks push... At least you didn't lose");
		}else if(dealer.getHand().isBust()
				|| !player.getHand().isBust() && player.getHand().getHandValue() > dealer.getHand().getHandValue()) {
			System.out.println("Player Won");
		}else if(dealer.getHand().getHandValue() == player.getHand().getHandValue()) {
			System.out.println("Push");
		}
			else {
			System.out.println("You Lost");
			
		}
	
	}

	private static void dealerTurn(Dealer dealer) {
		do {
			System.out.println("Dealer Hand Value: " + dealer.getHand().getHandValue());
			if (!dealer.getHand().isBust() && dealer.getHand().getHandValue() < 17) {
				dealer.dealCardUp(dealer);
				System.out.println("Dealer Hits. Now at: " + dealer.getHand().getHandValue());
			} else if (dealer.getHand().isBust()) {
				System.out.println("Dealer busted");
			} else {
				System.out.println("Dealer Stays at: " + dealer.getHand().getHandValue());
			}
			if (dealer.getHand().getHandValue() > 21) {
				System.out.println("Dealer Busts!");
			}
			dealer.getHand().showDealerHand();
		} while (!dealer.getHand().isBust() && dealer.getHand().getHandValue() < 17);
	}

	private static void playerTurn(Dealer dealer, Player player) {
		int hit = 0;
		Scanner sc = new Scanner(System.in);
		do {
			if (!player.getHand().isBust()) {
				System.out.println("Player Hand Value: " + player.getHand().getHandValue());
				System.out.println("Would you like to hit? \n1 - Yes \n2 - No");
				hit = sc.nextInt();
				if (hit ==1) {
					dealer.dealCardUp(player);
					System.out.println("Player New Hand Value: " + player.getHand().getHandValue());
				}
			}
			if (player.getHand().isBust()) {
				System.out.println("You busted");
			}
			player.getHand().showPlayerHand();
		} while (!player.getHand().isBust() && hit == 1);
	}

	private static void reshuffleIfNeeded(Dealer dealer) {
		if (dealer.getDeck().checkDeckSize() < 20) {
			dealer.setDeck(new Deck());
			dealer.getDeck().shuffle();
		}
	}


	private void run() {

	}

	public static void dealNewHand(Player player, Dealer dealer) {
		if (player.getHand() != null) {
            player.setHand(new BlackjackHand());
            dealer.setHand(new BlackjackHand());
        }
		dealer.dealCardUp(player);
		dealer.dealCardUp(dealer);
		dealer.dealCardUp(player);
		dealer.dealCardUp(dealer);
		dealer.getHand().showDealerHand();
		player.getHand().showPlayerHand();
		
	}

}
