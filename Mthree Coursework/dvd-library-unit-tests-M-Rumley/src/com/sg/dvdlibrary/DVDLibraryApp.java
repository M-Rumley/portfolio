package com.sg.dvdlibrary;

public class DVDLibraryApp {
	public static void main(String[] args) throws Exception {
		DVDLibraryController app = new DVDLibraryController(new DVDLibraryDAOImpl(), new DVDLibraryView(), "DVDLib");
		app.execute();
	}
}
