package com.sg.dvdlibrary;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.userio.*;

public class DVDLibraryView {
	private UserIO ui = new UserIOImpl();

	public void welcome() {
		ui.print("Welcome to the DVD Library");
	}

	public int mainMenuChoice() {
		int choice = ui.readInt(
				"Enter 1 to view all DVDs in collection, 2 to view a specific DVD, 3 to add a DVD, 4 for searching features or 0 to quit", 0, 4);
		return choice;
	}

	public int DVDChoice() {
		int choice = ui.readInt(
				"Enter 1 to view more info on this DVD, 2 to edit details of this DVD,3 to delete this DVD or 0 to return to the main menu",
				0, 3);
		return choice;
	}

	public int EditingChoice(DVDLibraryDTO toedit) {
		ui.print("You are editing " + toedit.getTitle());
		ui.print("Enter the value to edit");
		int choice = ui.readInt("1:Title, 2:Release Year,3:Rating,4:Director,5:Studio,6:Notes,0:Stop editing", 0, 6);
		return choice;
	}
	public int SearchingChoice() {
		int choice = ui.readInt("Enter 1 to search by age, 2 for director, 3 for rating, 4 for studio, 5 for stats, 0 to return to main menu", 0, 5);
		return choice;
	}

	public String getDVDAttribute(String val) {
		String field = ui.readString("Enter the DVDs " + val);
		return field;
	}

	public void printDVDTitles(ArrayList<DVDLibraryDTO> dvds) {
		for (DVDLibraryDTO dvd : dvds) {
			ui.print(dvd.getTitle());
		}
	}

	public void printDVDTitle(DVDLibraryDTO dvd) {
		ui.print(dvd.getTitle());
	}

	public void goodbye() {
		ui.print("Thanks for using the dvd library");
	}

	public void removedmessage(DVDLibraryDTO dvd) {
		ui.print("Successfully removed " + dvd.getTitle());
	}

	public void collectionemptyexception() {
		ui.print("There are no dvds in the collection");
	}

	public void nosuchdvdexception(String title) {
		ui.print(title + " does not exist in the collection");
	}
	public void printStream(Stream<DVDLibraryDTO> s) {
		s.forEach(dvd->ui.print(dvd.getTitle()));
	}
	public void avgAge(int age) {
		ui.print("The average age of the movies in this collection is "+age);
	}
	public void newest(DVDLibraryDTO dvd) {
		ui.print("The newest DVD is ");
		printDVDTitle(dvd);
	}
	public void oldest(DVDLibraryDTO dvd) {
		ui.print("The oldest DVD is ");
		printDVDTitle(dvd);
	}
}
