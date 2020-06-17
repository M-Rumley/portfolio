package com.doggenetics;
//Author:Michael Rumley
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class DogGenetics {

	public static void main(String[] args) {
		Random r = new Random();
		//List of integers that sum to 100
		ArrayList<Integer> list = new ArrayList<Integer>();
		String dogname;
		//current value and sum
		int val= 0;
		int sum = 0;
		Scanner inputReader = new Scanner(System.in);
		//for loop executes 5 times
		for(int i=1;i<=5;i++) {
			//if it's not the last iteration
			if(!(i==5)) {
				//random number between 1 and however many percentage points are left
				//(divided by the number of iterations to try and get a fairly uniform spread of values)
				val= r.nextInt((100-sum)/(5-i))+1;
				//add to list and running total
				list.add(val);
				sum+=val;
			}
			//on the last iteration
			else {
				// no random needed- will be whatever is left over
				int last = 100-sum;
				list.add(last);
				sum+=last;
			}
		}
		System.out.print("What is your dog's name? ");
		dogname = inputReader.nextLine();
		System.out.println("Well then, I have this highly reliable report on "+dogname+"'s prestigious background right here.\n");
		System.out.println(dogname+" is:\n");
		//accessing each value in arraylist for each percentage
		System.out.println(list.get(0)+"% St. Bernard");
		System.out.println(list.get(1)+"% Chihuahua");
		System.out.println(list.get(2)+"% Dramatic RedNosed Asian Pug");
		System.out.println(list.get(3)+"% Common Cur");
		System.out.println(list.get(4)+"% King Doberman");
		System.out.println("\nWow, that's QUITE the dog!");
		inputReader.close();
	}

}
