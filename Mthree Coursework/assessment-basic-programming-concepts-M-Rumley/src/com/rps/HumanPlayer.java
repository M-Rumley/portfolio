package com.rps;
//Author:Michael Rumley
//Package:rps
import java.util.Scanner;

public class HumanPlayer {
	private Scanner inputReader;
	//array of possible choices
	private String[] choices = new String[] {"ROCK","PAPER","SCISSORS"};
	//human player needs a scanner for user input
	public HumanPlayer(Scanner s) {
		this.inputReader = s;
	}
	//user makes choice based on inputed number
	public String choice() {
		System.out.println("1:Rock, 2:Paper, 3:Scissors");
		int choice = Integer.parseInt(this.inputReader.nextLine());
		//returns element in array corresponding to the correct choice
		switch(choice) {
		case 1:
			return choices[0];
		case 2:
			return choices[1];
		case 3:
			return choices[2];
		default:
			return "ERROR";
		}
		
	}

}
