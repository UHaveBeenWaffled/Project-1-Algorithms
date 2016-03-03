package dicegames;

import java.util.Scanner;

/**
 * This application instantiates the PlayRollDie game and starts it.
 */
public class GameTesterApp {

    /**
     * The main method. Don't call this one directly.
     * @param args the program arguments
     */
	public static void main(String[] args) {
		
		//Game menu welcome message.
		System.out.println("Welcome to the game menu.\n"
				+ "Which game would you like to play today?\n"
				+ "You can choose between:\n"
				+ "[1] Pair of Dice\n"
				+ "[2] Craps\n"
				+ "[3] Pig");
		
		Scanner scan = new Scanner(System.in);
		int pickGame = scan.nextInt();
		
		//Choose a game to play. 			
		switch (pickGame) {
		case 1: PlayPairOfDice gamePairOfDice = new PlayPairOfDice();
				gamePairOfDice.startGame(); break;
		case 2: PlayCraps gameCraps = new PlayCraps();
				gameCraps.startGame(); break;
		case 3: PlayPig gamePig = new PlayPig();
				gamePig.startGame(); break;
		default : System.out.println("You need to choose a number between 1 and 3.");
		}
		
	}

}
