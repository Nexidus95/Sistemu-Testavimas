package ktu.testing.index;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ktu.testing.Json;
import ktu.testing.delete.delete;

class indexTest {

	String[] args1;
	String[] args2;
	String[] args3;
	
	@BeforeEach
	void setUp() throws Exception {
		args1 = new String[] {"", "1aaa", "key1", "arab"};
		args2 = new String[] {"", "1"};
		args3 = new String[] {"", "1", "key1","kebab"};
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAnwser() {
		Json val = (new index()).getAnwser(Integer.parseInt(this.args3[1]), this.args3[2],this.args3[3]);
		assertEquals(0, val.get("error"));
	}

	@Test
	void testGetRightName() {
		String val = (new index(this.args1)).getName();
		assertEquals("arab", val);
	}

	@Test
	void testGetBadName() {
		String val = (new index(this.args2)).getName();
		assertEquals(null, val);
	}

	@Test
	void testGetRightKey() {
		String val = (new index(this.args1)).getKey();
		assertEquals("key1", val);
	}

	@Test
	void testGetBadKey2() {
		Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			String val = (new index(this.args2)).getKey();
			assertEquals("key1", val);
	    });
		
	    String expectedMessage = "Index 2 out of bounds for length 2";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void testGetBadID() {
		int val = (new index(this.args1)).getID();
		assertEquals(-1, val);
	}

	@Test
	void testGetRightID() {
		int val = (new index(this.args2)).getID();
		assertEquals(1, val);
	}

	@Test
	void testIsBadNumber() {
		boolean val = (new index()).isNumber(this.args1[1]);
		assertFalse(val);
	}

	@Test
	void testIsRightNumber() {
		boolean val = (new index()).isNumber(this.args2[1]);
		assertTrue(val);
	}

	@Test
	void testEnoughArgs() {
		boolean val = (new index(this.args1)).enoughArgs();
		assertTrue(val);
	}

	@Test
	void testNotEnoughArgs() {
		boolean val = (new index(this.args2)).enoughArgs();
		assertFalse(val);
	}

}
