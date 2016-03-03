package dicegames;

import java.util.Scanner;

public class PlayCraps {
	private Die die1, die2;					//The first and second die in the pair.
	private Scanner scan;					
	private int comeOutRoll;				//The value of the first roll.
	private int nextRoll;
	private int gamesWon = 0;				//Number of games won before quitting.
	private int gamesLost = 0;				//Number of games lost before quitting.
	private int gameWon = 0;
	private boolean firstRoll = true;
	private boolean finished = false;	
	private boolean playGame = true;
	
	//Constructor.
	public PlayCraps() {
		die1 = new Die();
		die2 = new Die();
		scan = new Scanner(System.in);
	}
	
	//Prints out a welcome message to the player.
	public void welcomeToGame() {
		System.out.println("Welcome to the game Craps. ");
	}
	
	//Prints out the result when the game is over.
	public void gameOver() {
		System.out.println("-----------------------------");
		System.out.println("Thank you for playing.");
		System.out.println("Games won: " + gamesWon + ".");
		System.out.println("Games won: " + gamesLost + ".");
		
		scan.close();
	}
	
	//Rolls the dice and determines if the player have won, lost or is able to continue.
	public void takeTurn() {		
		while (playGame == true) {
			die1.roll();
			die2.roll();
			
			//First roll goes here.
			if (firstRoll == true) {
				comeOutRoll = die1.getFaceValue() + die2.getFaceValue();
				if (comeOutRoll == 7 || comeOutRoll == 11) {
					gameWon = 1;
					System.out.println("You rolled " + comeOutRoll + ".");
				} else if (comeOutRoll == 2 || comeOutRoll == 3 || comeOutRoll == 12) {
					gameWon = 2;
					System.out.println("You rolled " + comeOutRoll + ".");
				} else {
					firstRoll = false;
					System.out.println("You rolled " + comeOutRoll + ".");
				}
			//Second+ roll goes here.
			} else {
				nextRoll = die1.getFaceValue() + die2.getFaceValue();
				if (nextRoll == 7) {
					gameWon = 2;
					System.out.println("You rolled " + nextRoll + ".");
				} else if (comeOutRoll == nextRoll) {
					gameWon = 1;
					System.out.println("You rolled " + nextRoll + ".");
				} else
					System.out.println("You rolled " + nextRoll + ".");
			}
		
			//Counts games won and lost. Continues if the current game hasn't ended yet.
			if (gameWon == 1) {
				System.out.println("You won!");
				gameWon = 0;
				gamesWon++;
			} else if (gameWon == 2){
				System.out.println("You lost.");
				gameWon = 0;
				gamesLost++;
			}
		
			//Asks if the player wants to roll again.
			System.out.println("Do you want to roll again? Choose yes or no: ");
			String rollAgain = scan.nextLine();
			if (rollAgain.equalsIgnoreCase("no")) {
				playGame = false;
				finished = true;
			}
		}
	}
	
	public void startGame() {
		welcomeToGame();
		
		while (!finished) {
			System.out.println("Do you want to roll the dice? Choose yes or no:");
			String proceedWithGame = scan.nextLine();
			if (proceedWithGame.equalsIgnoreCase("no"))
				finished = true;
			else
				takeTurn();
		}
		gameOver();
	}
	
}
