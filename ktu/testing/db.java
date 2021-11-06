package ktu.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class db {
	
	private static List<List<String>> servers = new ArrayList<>(Arrays.asList(
			Arrays.asList("1", "key1", "1000"),
			Arrays.asList("2", "key2", "2000"),
			Arrays.asList("3", "key3", "3000"),
			Arrays.asList("4", "key4", "4000"),
			Arrays.asList("5", "key5", "5000"),
			Arrays.asList("6", "key6", "6000"),
			Arrays.asList("7", "key7", "7000"),
			Arrays.asList("8", "key8", "8000"),
			Arrays.asList("9", "key9", "9000"),
			Arrays.asList("10", "key10", "10000")
			));
	
	private static List<List<String>> voted = new ArrayList<>(Arrays.asList(
			Arrays.asList("Name1", "1"),
			Arrays.asList("Name3", "1"),
			Arrays.asList("Name4", "3"),
			Arrays.asList("Name5", "6"),
			Arrays.asList("Name6", "8"),
			Arrays.asList("Name7", "3"),
			Arrays.asList("Name8", "1")
			));
	
	public static boolean serverExist(int id) {
		for (List<String> server : servers) {
			int tempId = Integer.parseInt(server.get(0));
			if (id == tempId) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean keyCorrect(int id, String key) {
		if (serverExist(id)) {
			for (List<String> server : servers) {
				int tempId = Integer.parseInt(server.get(0));
				if (id == tempId) {
					return server.get(1).equals(key);
				}
			}
		}
		return false;
	}
	
	public static int getVotes(int id, String key) {
		if (serverExist(id)) {
			if (keyCorrect(id, key)) {
				for (List<String> server : servers) {
					int tempId = Integer.parseInt(server.get(0));
					if (id == tempId) {
						return Integer.parseInt(server.get(2));
					}
				}
			}
		}
		return -1;
	}
	
	public static boolean didVote(int id, String key, String name) {
		if (serverExist(id)) {
			if (keyCorrect(id, key)) {
				for (List<String> line : voted) {
					if (line.get(0).equals(name) && Integer.parseInt(line.get(1)) == id) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
