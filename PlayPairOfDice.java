package dicegames;

import java.util.Scanner;

public class PlayPairOfDice {
	private Scanner scan;
	private PairOfDice game = null;
	
	//Constructor.
	public PlayPairOfDice()  {
		this.game = new PairOfDice();
		scan = new Scanner(System.in);
	}
	
	//Prints out a welcome message to the player.
	private void welcomeToGame() {
		System.out.println("Welcome to the game Pair of Dice.");
	}
	
	//Rolls the dice again.
	private void takeTurn() {
		game.rollBothDice();
	}
	
	//Prints out the result when the game is over.
	private void gameOver() {
		game.printScore();
		scan.close();
	}
	
	//Start the game loop.
	//The game is finished when the player chooses to not roll the die anymore.
	public void startGame() {
		welcomeToGame();
		
		boolean finished = false;
		
		while (!finished) {
			System.out.println("Do you want to roll the dice? Choose yes or no: ");
			String proceedWithGame = scan.nextLine();
			if (proceedWithGame.equalsIgnoreCase("no"))
				finished = true;
			else
				takeTurn();
		}
		
		gameOver();
	}
}
	
	
