import java.math.BigDecimal;
import java.util.Scanner;

/* This application calculates the batting average and slugging percentage for one or more baseball/softball players.
 * The application asks the user the number of batters first.
 * Then it asks for the the number of at bats for each player. For each at bat, the application asks for a result.
 * To enter an at-bat the user enters the number of bases earned by the batter.
 */

public class BattingStatistics {
	
	static int numberOfBatters;
	double battingAverage;
	double sluggingPercentage;
	
//This first method asks the user to enter the number of batters.
	int askNumberOfBatters(Scanner input) {
		System.out.println("Please enter the number of batters: ");
		int batterNumber;
		batterNumber = getValidInteger(input);
		return batterNumber;
	}
	//This method finds the batting average of each player and rounds it up to the third decimal place.
	BigDecimal findBattingAverage(int hits, int atBats) {
		battingAverage = (double)hits / atBats;
		BigDecimal batAvg = new BigDecimal(battingAverage);
		BigDecimal formatted = batAvg.setScale(3,  BigDecimal.ROUND_HALF_UP);
		System.out.println("His batting average is: " + formatted);
		return formatted;
	}
	//This method finds the slugging percentage and rounds it to the third decimal place.
	BigDecimal findSluggingPercentage(int sum, int atBats) {
		sluggingPercentage = ((double)sum / atBats);
		BigDecimal sluggingPer = new BigDecimal(sluggingPercentage);
		BigDecimal rounded = sluggingPer.setScale(3, BigDecimal.ROUND_UP);
		System.out.println("His slugging percentage is: " + rounded);
		return rounded;
		
	}
// This method checks that the user inputted a valid integer. 
	public static int getValidInteger(Scanner input) {
		while(!input.hasNextInt()) {
			System.out.println("That's not a number! Please enter a number: ");
			input.nextLine();
		}
		int number = input.nextInt();
		return number;
	}

	//This method checks that the user inputted a valid number in the range specified.
	public static int getValidIntegerInRange (int min, int max, Scanner input) {
		min = 0;
		max = 4;
		int number = getValidInteger(input);
		while(number > max || number < min) {
			System.out.println("Please enter a number between " + min + " and " + max);
		number = getValidInteger(input);
		}
		return number;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int atBats = 0;
		int i;
		int j;
		int hits = 0;
		int sum = 0;
		System.out.println("Welcome to the Batting Average Calculator");
		Scanner input = new Scanner(System.in);
		BattingStatistics user = new BattingStatistics();
		numberOfBatters = user.askNumberOfBatters(input);
		int playerNumber;
		int atBatNumber;
//		int [] [] stats = new int [numberOfBatters] [2];
		int [] [] batters = new int[numberOfBatters] [];
	
		//This for loop runs through the rows of the multi-dimensional array asking the user to enter the number of at bats for each player.
		for (j = 0; j < numberOfBatters; j++) {
			playerNumber = j + 1;
			System.out.println("Please enter the number of at bats for player " + playerNumber);
			atBats = getValidInteger(input); // Validation for a number
			batters [j] = new int[atBats];
			hits = 0;
			sum = 0;
			//This for loop runs through the columns of the multi-dimensional array asking the user to enter the result of each players at bats.
			for (i = 0; i < atBats; i++) {
				atBatNumber = i + 1;
				System.out.println("Please enter the result of at bat " + atBatNumber + " in number of bases:");
				System.out.println("Strike-Out = 0, Single = 1, Double = 2, Triple = 3, Home-Run = 4");
				batters[j][i] = getValidIntegerInRange(0, 4, input); // Validation for a number as well as range
				//This if statement counts the number of hits by adding 1 whenever the result of the at bat is a number greater than 1.
				if(batters[j][i] > 0) {
					hits = hits + 1;
					sum += batters[j][i];
					continue;
				}
			}
		BigDecimal battingAvg = user.findBattingAverage(hits, atBats);
		BigDecimal sluggingPerc = user.findSluggingPercentage(sum, atBats);
		}

	}
}
