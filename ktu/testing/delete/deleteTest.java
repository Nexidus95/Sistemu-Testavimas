package ktu.testing.delete;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ktu.testing.Json;

class deleteTest {
	
	String[] args1;
	String[] args2;
	String[] args3;

	@BeforeEach
	void setUp() throws Exception {
		args1 = new String[] {"", "1aaa", "key1"};
		args2 = new String[] {"", "1"};
		args3 = new String[] {"", "1", "key1"};
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDeleteInfo() {
		Json val = (new delete()).deleteInfo(Integer.parseInt(this.args3[1]), this.args3[2]);
		assertEquals(0, val.get("error"));
	}

	@Test
	void testGetKey1() {
		String val = (new delete(this.args1)).getKey();
		assertEquals("key1", val);
	}

	@Test
	void testGetKey2() {
		Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			String val = (new delete(this.args2)).getKey();
			assertEquals("key1", val);
	    });
		
	    String expectedMessage = "Index 2 out of bounds for length 2";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void testGetID1() {
		int val = (new delete(this.args1)).getID();
		assertEquals(-1, val);
	}

	@Test
	void testGetID2() {
		int val = (new delete(this.args2)).getID();
		assertEquals(1, val);
	}

	@Test
	void testIsNumber1() {
		boolean val = (new delete()).isNumber(this.args1[1]);
		assertFalse(val);
	}

	@Test
	void testIsNumber2() {
		boolean val = (new delete()).isNumber(this.args2[1]);
		assertTrue(val);
	}

	@Test
	void testEnoughArgs1() {
		boolean val = (new delete(this.args1)).enoughArgs();
		assertTrue(val);
	}

	@Test
	void testEnoughArgs2() {
		boolean val = (new delete(this.args2)).enoughArgs();
		assertFalse(val);
	}

}
