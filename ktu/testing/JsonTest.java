package ktu.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JsonTest {
	
	Json json;
	
	@BeforeEach
	void setUp() throws Exception {
		json = new Json();
		json.put("TEST", 10);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPut() {
		json.put("testas", true);
		assertEquals(true, json.get("testas"));
	}

	@Test
	void testRemoveWhenKeyDoesntExist() {
		boolean val = json.remove("key");
		assertEquals(false, val);
	}

	@Test
	void testRemoveWhenKeyExist() {
		boolean val = json.remove("TEST");
		assertEquals(true, val);
	}

	@Test
	void testToString() {
		String val = json.toString();
		assertEquals("{'TEST':10}", val);
	}

	@Test
	void testGetWhenKeyExist() {
		Object val = json.get("TEST");
		assertEquals(10, val);
	}

	@Test
	void testGetWhenKeyDoesntExist() {
		Object val = json.get("key");
		assertEquals(null, val);
	}

}
