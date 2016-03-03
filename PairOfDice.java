package dicegames;

/**
 * This class models one pair of dices. This is useful for games where you have to
 * throw two dice at once.
 */
public class PairOfDice {
	private Die die1, die2;				//The first and second die in the pair.
	private int numberOfOne = 0;		//The number of times the player rolls 
	private int numberOfTwo = 0;		//each of the six die values.
	private int numberOfThree = 0;
	private int numberOfFour = 0;
	private int numberOfFive = 0;
	private int numberOfSix = 0;
	private int pairCounter = 0;		//Counts the number of pairs rolled.
	private int biggestSum = 0;			//The biggest sum of face value rolled.
	private int numberOfRolls = 0;		//Total number of rolls.

	//Constructor for objects of class PairOfDice.
	public PairOfDice() {
		die1 = new Die();
		die2 = new Die();
	}
	
	//Constructor for objects of class PairOfDice with sides as parameter.
	public PairOfDice(int sides) {
		die1 = new Die();
		die2 = new Die();
	}
	
	//Rolls both dice.
	public void rollBothDice() {
		die1.roll();
		die2.roll();
		numberOfRolls++;
		
		//Prints die face values.
		System.out.printf("You have rolled %d and %d.\n", die1.getFaceValue(), 
				die2.getFaceValue());
	
		//Counts number of occurrences of face value of die1.
		switch (die1.getFaceValue()) {
			case 1: numberOfOne++; break;
			case 2: numberOfTwo++; break;
			case 3: numberOfThree++; break;
			case 4: numberOfFour++; break;
			case 5: numberOfFive++; break;
			case 6: numberOfSix++; break;
		}
		
		//Counts number of occurrences of face value of die2.
		switch (die2.getFaceValue()) {
			case 1: numberOfOne++; break;
			case 2: numberOfTwo++; break;
			case 3: numberOfThree++; break;
			case 4: numberOfFour++; break;
			case 5: numberOfFive++; break;
			case 6: numberOfSix++; break;
		}
		
		//Counts pairs.
		if (die1.getFaceValue() == die2.getFaceValue())
			pairCounter++;
		
		//Biggest sum of face value rolled.
		if (sumOfDice() > biggestSum)
			biggestSum = sumOfDice();
		return ;
	}
	
	//Returns the sum of the face values of the two dice.
	public int sumOfDice() {
		int sumOfDice = die1.getFaceValue() + die2.getFaceValue();
		return sumOfDice;
	}
	
	//Resets all variables
	public void resetPairOfDice() {
		this.numberOfOne = 0;
		this.numberOfTwo = 0;
		this.numberOfThree = 0;
		this.numberOfFour = 0;
		this.numberOfFive = 0;
		this.numberOfSix = 0;
		this.numberOfRolls = 0;
		this.pairCounter = 0;
		this.biggestSum = 0;
	}
	
	//Prints score after game has ended
	public void printScore() {
		System.out.println("--------------------------------------------");
		System.out.println("Thank you for playing. Here is your score: ");
		System.out.println("Times you rolled a pair: " + pairCounter + ".");
		System.out.println("You biggest roll: " + biggestSum + ".");
		System.out.println("Times you rolled 1: " + numberOfOne + ".");
		System.out.println("Times you rolled 2: " + numberOfTwo + ".");
		System.out.println("Times you rolled 3: " + numberOfThree + ".");
		System.out.println("Times you rolled 4: " + numberOfFour + ".");
		System.out.println("Times you rolled 5: " + numberOfFive + ".");
		System.out.println("Times you rolled 6: " + numberOfSix + ".");
		System.out.println("Total rolls: " + numberOfRolls + ".");
	}
}
