package com.sg.dvdlibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DVDLibraryDAOTest {
	DVDLibraryDAOImpl testDAO;
	public DVDLibraryDAOTest() {}
	
	@BeforeEach
	public void setUp() {
		testDAO = new DVDLibraryDAOImpl();
	}
	@Test
	public void testAdd() throws Exception {
		DVDLibraryDTO testDVD = new DVDLibraryDTO();
		testDVD.setTitle("Star Wars");
		testDVD.setReleaseDateS("01/01/1997");
		testDVD.setRating("U");
		testDVD.setDirector("George Lucas");
		testDVD.setStudio("Disney");
		testDVD.setNote("The first test dvd");
		
		testDAO.add(testDVD);
		DVDLibraryDTO retrievedDVD = testDAO.getOne("Star Wars");
		
		assertEquals("Checking DVD Title",testDVD.getTitle(),retrievedDVD.getTitle());
		assertEquals("Checking DVD Release Date",testDVD.getReleaseDate(),retrievedDVD.getReleaseDate());
		assertEquals("Checking DVD Rating",testDVD.getRating(),retrievedDVD.getRating());
		assertEquals("Checking DVD Director",testDVD.getDirector(),retrievedDVD.getDirector());
		assertEquals("Checking DVD Studio",testDVD.getStudio(),retrievedDVD.getStudio());
		assertEquals("Checking DVD Notes",testDVD.getNote(),retrievedDVD.getNote());
	}
	@Test
	public void testAddGetAll() throws Exception {
		DVDLibraryDTO testDVD = new DVDLibraryDTO();
		testDVD.setTitle("Star Wars");
		testDVD.setReleaseDateS("1997");
		testDVD.setRating("U");
		testDVD.setDirector("George Lucas");
		testDVD.setStudio("Disney");
		testDVD.setNote("The first test dvd");
		
		DVDLibraryDTO testDVD2 = new DVDLibraryDTO();
		testDVD2.setTitle("The Dark Knight");
		testDVD2.setReleaseDateS("2008");
		testDVD2.setRating("12");
		testDVD2.setDirector("Christopher Nolan");
		testDVD2.setStudio("Warner Bros");
		testDVD2.setNote("The second test dvd");
		
		testDAO.add(testDVD);
		testDAO.add(testDVD2);
		
		List<DVDLibraryDTO> allDVDs = testDAO.getAll();
		
		assertNotNull("The list of dvds must not be null",allDVDs);
		assertEquals("The list should have 2 dvds in",2,allDVDs.size());
		
		assertTrue("The list of DVDs should include Star wars",testDAO.getAll().contains(testDVD));
		assertTrue("The list of DVDs should include Batman",testDAO.getAll().contains(testDVD2));
	}
	@Test
	public void testRemove() throws Exception {
		DVDLibraryDTO testDVD = new DVDLibraryDTO();
		testDVD.setTitle("Star Wars");
		testDVD.setReleaseDateS("1997");
		testDVD.setRating("U");
		testDVD.setDirector("George Lucas");
		testDVD.setStudio("Disney");
		testDVD.setNote("The first test dvd");
		
		DVDLibraryDTO testDVD2 = new DVDLibraryDTO();
		testDVD2.setTitle("The Dark Knight");
		testDVD2.setReleaseDateS("2008");
		testDVD2.setRating("12");
		testDVD2.setDirector("Christopher Nolan");
		testDVD2.setStudio("Warner Bros");
		testDVD2.setNote("The second test dvd");
		
		testDAO.add(testDVD);
		testDAO.add(testDVD2);
		
		DVDLibraryDTO removedDVD = testDAO.remove(testDVD);
		assertEquals("The removed dvd should be star wars",removedDVD,testDVD);
		
		List<DVDLibraryDTO> allDVDs = testDAO.getAll();
		assertNotNull("The list of dvds must not be null",allDVDs);
		assertEquals("The list should have 1 dvd in",1,allDVDs.size());
		
		assertFalse("All dvds should not include star wars",allDVDs.contains(testDVD));
		assertTrue("All dvds should contain batman",allDVDs.contains(testDVD2));
		
		removedDVD = testDAO.remove(testDVD2);
		assertEquals("The removed dvd should be batman",removedDVD,testDVD2);
		
		allDVDs = testDAO.getAll();
		
		assertTrue("The list of dvds should now be empty",allDVDs.isEmpty());
		DVDLibraryDTO retrievedDVD = testDAO.getOne(testDVD);
		assertNull("Star wars was removed, should be null",retrievedDVD);
		retrievedDVD = testDAO.getOne(testDVD2);
		assertNull("Batman was removed, should be null",retrievedDVD);
		
	}
	
}
