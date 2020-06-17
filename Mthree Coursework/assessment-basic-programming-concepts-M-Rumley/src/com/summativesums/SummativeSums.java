package com.summativesums;

import java.util.stream.IntStream;

//Author:Michael Rumley
public class SummativeSums {
	public static int sumArray(int[] tosum) {
		//Convert array to IntStream and use sum method
		return IntStream.of(tosum).sum();
	}
	public static void main(String[] args) {
		//Arrays taken from exercise specification
		int []a = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
		int []b = { 999, -60, -77, 14, 160, 301 };
		int []c= { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
					140, 150, 160, 170, 180, 190, 200, -99 }; 
		
		System.out.println("#1 Array Sum "+sumArray(a));
		System.out.println("#2 Array Sum "+sumArray(b));
		System.out.println("#3 Array Sum "+sumArray(c));
	}

}
