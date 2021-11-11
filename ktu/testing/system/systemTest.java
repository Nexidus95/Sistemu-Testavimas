package ktu.testing.system;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ktu.testing.Json;

class systemTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetPlayers1() {
		Json val = (new system()).getPlayers("1", "kaimux.lt", 25565);
		assertNotEquals("Offline", val.get("MOTD"));
	}

	@Test
	void testGetPlayers2() {
		Json val = (new system()).getPlayers("1", "donotexist", 25565);
		assertEquals("Offline", val.get("MOTD"));
	}

	@Test
	void testConnect1() {
		String[] val = (new system()).connect("kaimux.lt", 25565);
		assertNotEquals("Offline", val[2]);
	}

	@Test
	void testConnect2() {
		String[] val = (new system()).connect("donotexist", 25565);
		assertEquals("Offline", val[2]);
	}

}
