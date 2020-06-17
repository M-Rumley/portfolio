package com.healthyhearts;
//Author: Michael Rumley
import java.util.Scanner;
public class HealthyHearts {

	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		int age,max;
		//Ask user their age
		System.out.println("What is your age?");
		age= Integer.parseInt(inputReader.nextLine());
		//Compute and display max and target HRs as per formulas in exercise specification
		max = 220-age;
		System.out.println("Your maximum heart rate should be "+max+" beats per minute");
		System.out.println("Your target HR Zone is "+(max*0.5)+"-"+(max*0.85)+" beats per minute");
		
		inputReader.close();
	}

}
