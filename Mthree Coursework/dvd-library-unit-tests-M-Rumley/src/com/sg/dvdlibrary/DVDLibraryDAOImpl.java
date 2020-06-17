package com.sg.dvdlibrary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Stream;

public class DVDLibraryDAOImpl implements DVDLibraryDAO {
	private ArrayList<DVDLibraryDTO> collection;

	public DVDLibraryDAOImpl() {
		collection = new ArrayList<DVDLibraryDTO>();
	}

	public void read(String fName) throws IOException {
		File f = new File(fName);
		try {
			f.createNewFile();
		} catch (IOException e) {
			throw new IOException();
		}
		BufferedReader reader = new BufferedReader(new FileReader((fName)));
		String line;
		Scanner scanner;
		int index = 0;
		while ((line = reader.readLine()) != null) {
			DVDLibraryDTO dvd = new DVDLibraryDTO();
			scanner = new Scanner(line);
			scanner.useDelimiter("::");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0) {
					dvd.setTitle(data);
				} else if (index == 1) {
					dvd.setReleaseDate(LocalDate.parse(data));
				} else if (index == 2) {
					dvd.setRating(data);
				} else if (index == 3) {
					dvd.setDirector(data);
				} else if (index == 4) {
					dvd.setStudio(data);
				} else if (index == 5) {
					dvd.setNote(data);
				}
				index++;

			}
			index = 0;
			collection.add(dvd);
		}
		reader.close();
	}

	public void saveToFile(String fName) throws IOException {
		try {
			FileWriter w = new FileWriter(fName);
			for (DVDLibraryDTO dvd : collection) {
				w.write(dvd.getTitle() + "::" + dvd.getReleaseDate() + "::" + dvd.getRating() + "::" + dvd.getDirector()
						+ "::" + dvd.getStudio() + "::" + dvd.getNote() + System.lineSeparator());
			}
			w.close();
		} catch (IOException e) {
			throw new IOException();
		}

	}

	public void add(DVDLibraryDTO dvd) throws Exception {
		for (DVDLibraryDTO stored : collection) {
			if (stored.equals(dvd)) {
				throw new Exception("DVD already in collection");
			}
		}
		collection.add(dvd);
	}

	public ArrayList<DVDLibraryDTO> getAll() throws Exception {
		
		 if (collection.isEmpty()) { throw new Exception("DVD collection is empty"); }
		 
		return collection;
	}

	public DVDLibraryDTO getOne(DVDLibraryDTO dvd) throws Exception {
		for (DVDLibraryDTO stored : collection) {
			if (stored.equals(dvd)) {
				return stored;
			}
		}
		throw new Exception("DVD doesn't exist");
		
	}

	public DVDLibraryDTO getOne(String title) throws Exception {
		for (DVDLibraryDTO stored : collection) {
			if (stored.getTitle().equals(title)) {
				return stored;
			}
		}
		throw new Exception("DVD doesn't exist");
		
	}

	public DVDLibraryDTO remove(DVDLibraryDTO dvd) throws Exception {
		
		for (DVDLibraryDTO stored : collection) {
			if (stored.equals(dvd)) {
				collection.remove(stored);
				
				return dvd;
			}
		}
		
		return null;
	}
	public Stream<DVDLibraryDTO> moviesReleasedInYr (int year) {
		int currentyear = LocalDate.now().getYear();
		Stream<DVDLibraryDTO> s = collection.stream().filter((m)->m.getReleaseDate().getYear()>=currentyear-year);
		return s;
	}

	@Override
	public Stream<DVDLibraryDTO> moviesWRating(String rating) {
		Stream<DVDLibraryDTO> s = collection.stream().filter((m)->m.getRating().equals(rating));
		return s;
	}

	@Override
	public Stream<DVDLibraryDTO> moviesByDir(String dir) {
		Stream<DVDLibraryDTO> s = collection.stream().filter((m)->m.getDirector().equals(dir));
		return s;
	}

	@Override
	public Stream<DVDLibraryDTO> moviesByStudio(String studio) {
		Stream<DVDLibraryDTO> s = collection.stream().filter((m)->m.getStudio().equals(studio));
		return s;
	}

	@Override
	public int avgAge() {
		OptionalDouble avg = collection.stream().mapToInt((p)->p.getReleaseDate().getYear()).average();
		int avgyr = (int) avg.orElse(-1);
		return LocalDate.now().getYear()-avgyr;
	}

	@Override
	public DVDLibraryDTO newest() {
		return collection.stream().reduce((dvd1,dvd2)->dvd1.getReleaseDate().isAfter(dvd2.getReleaseDate())?dvd1:dvd2).get();
	}

	@Override
	public DVDLibraryDTO oldest() {
		return collection.stream().reduce((dvd1,dvd2)->dvd1.getReleaseDate().isBefore(dvd2.getReleaseDate())?dvd1:dvd2).get();
	}

}
