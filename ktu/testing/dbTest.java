package ktu.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ktu.testing.delete.delete;

class dbTest {
	
	int a;
	int b;
	String key1;
	String key2;
	int votes1;
	int votes2;

	@BeforeEach
	void setUp() throws Exception {
		a = 5;
		b = 11;
		key1 = "key5";
		key2 = "key6";
		votes1 = 5000;
		votes2 = 66;
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testServerExist() {
		boolean val = (new db().serverExist(a));
		assertTrue(val);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testServerNotExist() {
		boolean val = (new db().serverExist(b));
		assertFalse(val);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testIDAndKeyCorrect() {
		boolean val = (new db().keyCorrect(a,key1));
		assertTrue(val);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testIDAndKeyNotCorrect1() {
		boolean val = (new db().keyCorrect(a,key2));
		assertFalse(val);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testIDAndKeyNotCorrect2() {
		boolean val = (new db().keyCorrect(b,key1));
		assertFalse(val);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testIDAndKeyNotCorrect3() {
		boolean val = (new db().keyCorrect(b,key2));
		assertFalse(val);
	}
	@SuppressWarnings("static-access")
	@Test
	void testGetRightVotes() {
		int val = (new db().getVotes(a,key1));
		boolean chek = false;
		if(votes2 == val) {
			chek = true;
			assertTrue(chek);
		}
		else {
			assertFalse(chek);
		}
	}
	@SuppressWarnings("static-access")
	@Test
	void testGetBadVotes() {
		int val = (new db().getVotes(a,key1));
		boolean chek = false;
		if(votes2 == val) {
			chek = true;
			assertTrue(chek);
		}
		else {
			assertFalse(chek);
		}
	}
	@SuppressWarnings("static-access")
	@Test
	void testGetBadKeyAndRightVotes() {
		int val = (new db().getVotes(a,key2));
		boolean chek = false;
		if(votes1 == val) {
			chek = true;
			assertTrue(chek);
		}
		else {
			assertFalse(chek);
		}
	}
	@SuppressWarnings("static-access")
	@Test
	void testGetBadKeyAndBadVotes() {
		int val = (new db().getVotes(a,key2));
		boolean chek = false;
		if(votes2 == val) {
			chek = true;
			assertTrue(chek);
		}
		else {
			assertFalse(chek);
		}
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testGetBadKeyAndBadVotes4() {
		int val = (new db().getVotes(b,key1));
		boolean chek = false;
		if(votes1 == val) {
			chek = true;
			assertTrue(chek);
		}
		else {
			assertFalse(chek);
		}
	}
	@SuppressWarnings("static-access")
	@Test
	void testGetBadKeyAndBadVotes1() {
		int val = (new db().getVotes(b,key1));
		boolean chek = false;
		if(votes2 == val) {
			chek = true;
			assertTrue(chek);
		}
		else {
			assertFalse(chek);
		}
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testGetBadKeyAndBadVotes2() {
		int val = (new db().getVotes(b,key2));
		boolean chek = false;
		if(votes1 == val) {
			chek = true;
			assertTrue(chek);
		}
		else {
			assertFalse(chek);
		}
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testGetBadKeyAndBadVotes3() {
		int val = (new db().getVotes(b,key2));
		boolean chek = false;
		if(votes2 == val) {
			chek = true;
			assertTrue(chek);
		}
		else {
			assertFalse(chek);
		}
	}

	@SuppressWarnings("static-access")
	@Test
	void testDidBadVote1() {
		boolean val = (new db().didVote(a,key1, "Name5"));
		assertFalse(val);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testDidBadVote2() {
		boolean val = (new db().didVote(a,key1, "Name4"));
		assertFalse(val);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testDidBadVote3() {
		boolean val = (new db().didVote(a,key1, "Name2"));
		assertFalse(val);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testDidBadVote4() {
		boolean val = (new db().didVote(a,key1, "Name3"));
		assertFalse(val);
	}
	@SuppressWarnings("static-access")
	@Test
	void testDidCorrectVote() {
		boolean val = (new db().didVote(1,"key1", "Name3"));
		assertTrue(val);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testGetServers() {
		List<List<String>> val = (new db().getServers());
		assertNotNull(val);
	}

}
