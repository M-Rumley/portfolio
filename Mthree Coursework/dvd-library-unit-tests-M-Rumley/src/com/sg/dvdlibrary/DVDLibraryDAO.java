package com.sg.dvdlibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

public interface DVDLibraryDAO {
	public void read(String fName) throws IOException;
	public void saveToFile(String fName) throws IOException;
	public void add(DVDLibraryDTO dvd) throws Exception;
	public ArrayList<DVDLibraryDTO> getAll() throws Exception;
	public DVDLibraryDTO getOne(DVDLibraryDTO dvd) throws Exception;
	public DVDLibraryDTO getOne(String title) throws Exception;
	public DVDLibraryDTO remove(DVDLibraryDTO dvd) throws Exception;
	public Stream<DVDLibraryDTO> moviesReleasedInYr (int year);
	public Stream<DVDLibraryDTO> moviesWRating (String rating);
	public Stream<DVDLibraryDTO> moviesByDir (String dir);
	public Stream<DVDLibraryDTO> moviesByStudio (String studio);
	public int avgAge();
	public DVDLibraryDTO newest();
	public DVDLibraryDTO oldest();
}
