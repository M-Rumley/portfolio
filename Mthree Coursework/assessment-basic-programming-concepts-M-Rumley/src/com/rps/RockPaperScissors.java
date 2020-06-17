package com.rps;
//Author:Michael Rumley
//Package:rps
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	// Does the player want to play again?
	private static boolean again(Scanner s) {
		System.out.println("Play again? Y(9) or N(0)");
		switch (Integer.parseInt(s.nextLine())) {
		case 9:
			return true;
		default:
			System.out.println("Thanks for playing");
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		CompPlayer comp = new CompPlayer(new Random());
		HumanPlayer player = new HumanPlayer(inputReader);
		//Code loops until player quits
		do {
			//reset the stats every iteration of the do loop
			int userwin = 0, compwin = 0, draw = 0;
			System.out.println("ROCK PAPER SCISSORS\n\n");
			System.out.print("How many rounds do you want to play? ");
			int rounds = Integer.parseInt(inputReader.nextLine());
			if(rounds>10||rounds<1) {
				throw new IllegalArgumentException("Invalid number of rounds");
			}
			//for however many rounds the user wants to play
			for (int i = 1; i <= rounds; i++) {
				//both players make a choice
				String playerchoice = player.choice();
				String compchoice = comp.choice();
				System.out.println(playerchoice + " plays " + compchoice);
				//if the choices are the same
				if (playerchoice.equals(compchoice)) {
					System.out.println("TIE");
					draw++;
				//else if the player wins
				} else if ((("ROCK".equals(playerchoice) && "SCISSORS".equals(compchoice))
						|| ("SCISSORS".equals(playerchoice) && "PAPER".equals(compchoice))
						|| ("PAPER".equals(playerchoice) && "ROCK".equals(compchoice)))) {
					System.out.println("YOU WIN");
					userwin++;
				//otherwise the computer has won- assert statement confirms this
				} else {
					assert (("ROCK".equals(compchoice) && "SCISSORS".equals(playerchoice))
							|| ("SCISSORS".equals(compchoice) && "PAPER".equals(playerchoice))
							|| ("PAPER".equals(compchoice) && "ROCK".equals(playerchoice)));
					System.out.println("COMPUTER WINS");
					compwin++;

				}

			}
			//if the user has won the most rounds
			if (userwin >= compwin && userwin >= draw) {
				System.out.println("Overall winner is you!");
			//if the computer has won the most
			} else if (compwin >= draw) {
				System.out.println("Overall winner is the computer");
			}
			//otherwise the game is a draw
			else {
				System.out.println("The game was a draw...");
			}

		} while (again(inputReader));

		inputReader.close();

	}

}
