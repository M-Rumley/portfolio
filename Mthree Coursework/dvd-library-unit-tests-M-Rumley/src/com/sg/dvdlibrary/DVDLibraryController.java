package com.sg.dvdlibrary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DVDLibraryController {
	private DVDLibraryDAOImpl dao;
	private DVDLibraryView view;
	private String fName;

	public DVDLibraryController(DVDLibraryDAOImpl dao, DVDLibraryView view, String fName) {
		this.dao = dao;
		this.view = view;
		this.fName = fName;

	}

	public void execute() throws Exception {
		boolean flag = true;
		int mmchoice;
		view.welcome();
		dao.read(fName);
		while (flag) {
			mmchoice = view.mainMenuChoice();
			switch (mmchoice) {
			case 1:
				try {
					view.printDVDTitles(dao.getAll());
				} catch (Exception e) {
					view.collectionemptyexception();
				}

				break;
			case 2:
				String title = view.getDVDAttribute("Title");

				DVDLibraryDTO selected;
				try {
					selected = dao.getOne(title);
				} catch (Exception e) {
					view.nosuchdvdexception(title);
					break;
				}
				view.printDVDTitle(selected);
				boolean onedvd = true;
				while (onedvd) {
					int dvdchoice = view.DVDChoice();
					switch (dvdchoice) {
					case 1:
						selected.print();
						break;
					case 2:
						boolean editing = true;
						while (editing) {
							int editchoice = view.EditingChoice(selected);
							switch (editchoice) {
							case 1:
								selected.setTitle(view.getDVDAttribute("Title"));
								break;
							case 2:
								String releaseDate = view.getDVDAttribute("Release Date");
								selected.setReleaseDate(
										LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
								break;
							case 3:
								selected.setRating(view.getDVDAttribute("Rating"));
								break;
							case 4:
								selected.setDirector(view.getDVDAttribute("Director"));
								break;
							case 5:
								selected.setStudio(view.getDVDAttribute("Studio"));
								break;
							case 6:
								selected.setNote(view.getDVDAttribute("Notes"));
								break;
							case 0:
								editing = false;
								break;

							}

						}
						break;
					case 3:
						dao.remove(selected);
						view.removedmessage(selected);
						break;
					case 0:
						onedvd = false;
						break;
					}
					break;
				}
				break;
			case 3:
				String titletoadd = view.getDVDAttribute("Title");
				String rdatetoadd = view.getDVDAttribute("Release Date");
				String ratingtoadd = view.getDVDAttribute("Rating");
				String directortoadd = view.getDVDAttribute("Director");
				String studiotoadd = view.getDVDAttribute("Studio");
				String notetoadd = view.getDVDAttribute("Note");
				DVDLibraryDTO toadd = new DVDLibraryDTO(titletoadd, rdatetoadd, ratingtoadd, directortoadd, studiotoadd,
						notetoadd);
				dao.add(toadd);
				break;
			case 4:
				boolean searching = true;
				while (searching) {
					int searchChoice = view.SearchingChoice();
					switch (searchChoice) {
					case 0:
						searching = false;
						break;
					case 1:
						String nyears = view.getDVDAttribute("Age");
						view.printStream(dao.moviesReleasedInYr(Integer.parseInt(nyears)));
						break;
					case 2:
						String dir = view.getDVDAttribute("Director");
						view.printStream(dao.moviesByDir(dir));
						break;
					case 3:
						String ratingtosearch = view.getDVDAttribute("Rating to search");
						view.printStream(dao.moviesWRating(ratingtosearch));
						break;
					case 4:
						String studiotosearch = view.getDVDAttribute("Studio");
						view.printStream(dao.moviesByStudio(studiotosearch));
						break;
					case 5:
						view.avgAge(dao.avgAge());
						view.newest(dao.newest());
						view.oldest(dao.oldest());
						break;

					}
				}

				break;
			case 0:
				flag = false;
				view.goodbye();
				break;

			}

		}
		dao.saveToFile(fName);
	}
}
