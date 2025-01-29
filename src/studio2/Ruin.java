package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int startAmount;
		double winChance;
		int winLimit;
		int totalSimulations;
		int loseCount = 0;
		String winMessage;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("What is your start amount?");
		startAmount = in.nextInt();
		int startAmountInitial = startAmount;
		
		System.out.println("What is your win chance?");
		winChance = in.nextDouble();
		
		System.out.println("What is your win limit?");
		winLimit = in.nextInt();
		
		System.out.println("How many days would you like to play?");
		totalSimulations = in.nextInt();
		
		for (int x = 1; x <= totalSimulations; x++){
			int i = 0;
			startAmount = startAmountInitial;
			while (startAmount>0 && startAmount<winLimit) {
				i++;
				double r = Math.random();
				if (r>winChance) {
				
					startAmount--;
				}
				else {
					
					startAmount++;
				}
				
				
			}
			if (startAmount==0) {
				winMessage = "LOSE";
				loseCount++;
			}
			else {
				winMessage = "WIN";
			}
			System.out.println("Simulation " + x + ": " + i + " " + winMessage);
		}
		
		double expectedRuin;
		double a = (1-winChance)/winChance;
		
		if (winChance == 0.5) {
			expectedRuin = 1.0 - ((double)startAmountInitial/(double)winLimit);
		}
		else {
			expectedRuin = (Math.pow(a, startAmountInitial)-Math.pow(a, winLimit))/(1-Math.pow(a, winLimit));
		}
		double ruinRateSimulation = (double)loseCount/(double)totalSimulations;
		System.out.println("Losses: " + loseCount + ". Simulations: " + totalSimulations);
		System.out.println("Expected Ruin Rate: " + expectedRuin);
		System.out.println("Ruin Rate from Simulation: " + ruinRateSimulation);
		
		
	
		
		

	}

}
