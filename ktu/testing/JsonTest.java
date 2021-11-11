package ktu.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

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
	void testRemove1() {
		boolean val = json.remove("key");
		assertEquals(false, val);
	}

	@Test
	void testRemove2() {
		boolean val = json.remove("TEST");
		assertEquals(true, val);
	}

	@Test
	void testToString() {
		String val = json.toString();
		assertEquals("{'TEST':10}", val);
	}

	@Test
	void testGet1() {
		Object val = json.get("TEST");
		assertEquals(10, val);
	}

	@Test
	void testGet2() {
		Object val = json.get("key");
		assertEquals(null, val);
	}

}
