package dicegames;

import java.util.Scanner;

public class PlayPig {
	private Die die;
	private Scanner scan;						
	private int point1;							//Points of player 1.
	private int point2; 						//Points of player 2.
	private boolean firstPlayer = true;			//Boolean to change players.
	
	//Constructor.
	public PlayPig() {
		this.die = new Die();
		this.scan = new Scanner(System.in);
		this.point1 = 0;
		this.point2 = 0;
	}
	
	//Prints out a welcome message to the player.
	public void welcomeToGame() {
		System.out.println("Welcome to the game Pig.");
	}
	
	//Prints out the result when the game is over.
	public void gameOver() {
		
		
		scan.close();
	}
	
	//Rolls the dice and determines if the player have won, lost or is able to continue.
	public void takeTurn() {
		
		while (firstPlayer == true) {
			die.roll();
			point1 += die.getFaceValue();
			System.out.println("Player 1 rolled " + die.getFaceValue() + ".");
			System.out.println("Player 1 has " + point1 + " points.");
			System.out.println("Do you want to continue? Choose yes or no: ");
			String proceed = scan.nextLine();
			if (proceed.equalsIgnoreCase("no")) {
				firstPlayer = !firstPlayer;
				System.out.println("Changing to player 2. "
						+ "Do you want to roll the dice? Choose yes or no: ");
				String scan1 = scan.nextLine();
				if (scan1.equalsIgnoreCase("no")) {
					firstPlayer = !firstPlayer;
				}
			}
		} 
		while (firstPlayer == false){
			die.roll();
			point2 += die.getFaceValue();
			System.out.println("Player 2 rolled " + die.getFaceValue() + ".");
			System.out.println("Player 2 has " + point2 + " points.");
			System.out.println("Do you want to continue? Choose yes or no: ");
			String proceed1 = scan.nextLine();
			if (proceed1.equalsIgnoreCase("no")) {
				firstPlayer = !firstPlayer;
				System.out.println("Chaning to player 1. "
						+ "Do you want to roll the dice? Choose yes or no: ");
				String scan2 = scan.nextLine();
				if (scan2.equalsIgnoreCase("no")) {
					firstPlayer = !firstPlayer;
				}
			}
		}
	}
	
	public void startGame() {
		PlayPig player1 = new PlayPig();
		PlayPig player2 = new PlayPig();
		
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
