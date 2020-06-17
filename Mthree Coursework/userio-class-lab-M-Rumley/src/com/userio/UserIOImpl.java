package com.userio;

import java.util.Scanner;

public class UserIOImpl implements UserIO {
	Scanner in = new Scanner(System.in);

	@Override
	public void print(String message) {
		System.out.println(message);

	}

	@Override
	public String readString(String prompt) {
		print(prompt);
		return in.nextLine();

	}

	@Override
	public int readInt(String prompt) {
		print(prompt);
		return Integer.parseInt(in.nextLine());

	}

	@Override
	public int readInt(String prompt, int min, int max) {
		int input = 0;
		print(prompt);
		input = Integer.parseInt(in.nextLine());
		if (input > max || input < min) {
			return readInt(prompt, min, max);
		}

		return input;

	}

	@Override
	public double readDouble(String prompt) {
		print(prompt);
		return Double.parseDouble(in.nextLine());
	}

	@Override
	public double readDouble(String prompt, double min, double max) {
		double input = 0;
		print(prompt);
		input = Double.parseDouble(in.nextLine());
		if (input > max || input < min) {
			return readDouble(prompt, min, max);
		}
		return input;
	}

	@Override
	public float readFloat(String prompt) {
		print(prompt);
		return Float.parseFloat(in.nextLine());
	}

	@Override
	public float readFloat(String prompt, float min, float max) {
		float input = 0;
		print(prompt);
		input = Float.parseFloat(in.nextLine());
		if (input > max || input < min) {
			return readFloat(prompt, min, max);
		}
		return input;
	}

	@Override
	public long readLong(String prompt) {
		print(prompt);
		return Long.parseLong(in.nextLine());
	}

	@Override
	public long readLong(String prompt, long min, long max) {
		long input = 0;
		print(prompt);
		input = Long.parseLong(in.nextLine());
		if (input > max || input < min) {
			return readLong(prompt, min, max);
		}

		return input;

	}

}
