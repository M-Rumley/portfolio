package com.rps;
//Author:Michael Rumley
//Package:rps
import java.util.Random;

public class CompPlayer {
	//array of possible choices
	private String[] choices = new String[] {"ROCK","PAPER","SCISSORS"};
	private Random rand;
	//computer player constructor needs a random to make choices
	public CompPlayer(Random r) {
		this.rand=r;
	}
	//returns a random element of the choices array
	public String choice() {
		return choices[this.rand.nextInt(choices.length)];
	}
}
