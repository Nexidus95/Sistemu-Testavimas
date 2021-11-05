package ktu.testing;

import java.util.HashMap;
import java.util.Map;

public class Json {
	
	private Map<String, Object> map = new HashMap<>();

	public void put(String key, Object value) {
		map.put(key, value);
	}
	
	public void remove(String key) {
		map.remove(key);
	}
	
	@Override
	public String toString() {
		String toReturn = "{";
		for (String key : map.keySet()) {
			if (!toReturn.equals("{")) {
				toReturn += ",";
			}
			toReturn += "'" + key + "':";
			Object value = map.get(key);
			if (value instanceof Integer)
				toReturn += String.valueOf(value);
			else
				toReturn += "'" + String.valueOf(value) + "'";
		}
		toReturn += "}";
		return toReturn;
	}
}
