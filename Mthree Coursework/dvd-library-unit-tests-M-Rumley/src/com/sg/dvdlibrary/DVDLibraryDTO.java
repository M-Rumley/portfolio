package com.sg.dvdlibrary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.userio.*;

public class DVDLibraryDTO {

	private UserIO ui = new UserIOImpl();
	private String title;
	private LocalDate releaseDate;
	private String rating;
	private String director;
	private String studio;
	private String note;

	public DVDLibraryDTO(String title, String releaseDate, String rating, String director, String studio, String note) {
		this.title = title;
		this.releaseDate = LocalDate.parse(releaseDate,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.rating = rating;
		this.director = director;
		this.studio = studio;
		this.note = note;
	}

	public DVDLibraryDTO() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public void setReleaseDateS(String string) {
		LocalDate d = LocalDate.parse(string,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		setReleaseDate(d);
	}


	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void print() {
		ui.print(title.toUpperCase() + "\nReleased: " + releaseDate + "\nRating: " + rating + "\nDirector: " + director
				+ "\nStudio: " + studio + "\nNotes: " + note);

	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + Objects.hash(this.title);
		hash = 89 * hash + Objects.hash(this.releaseDate);
		hash = 89 * hash + Objects.hash(this.rating);
		hash = 89 * hash + Objects.hash(this.director);
		hash = 89 * hash + Objects.hash(this.note);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final DVDLibraryDTO other = (DVDLibraryDTO) obj;
		if (!Objects.equals(this.title, other.title)) {
			return false;
		}
		if (!Objects.equals(this.releaseDate, other.releaseDate)) {
			return false;
		}
		if (!Objects.equals(this.rating, other.rating)) {
			return false;
		}
		if (!Objects.equals(this.director, other.director)) {
			return false;
		}
		if (!Objects.equals(this.studio, other.studio)) {
			return false;
		}
		if (!Objects.equals(this.note, other.note)) {
			return false;
		}
		return true;

	}

	
}
