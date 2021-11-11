package ktu.testing.delete;

import ktu.testing.Json;
import ktu.testing.db;

public class delete {
	
	private String[] args;
	
	public delete() {
		
	}

	public delete(String[] args) {
		this.args = args;
	}
	
	public void run() {
		if (!enoughArgs()) {
			Json json = new Json();
			json.put("error", 1);
			json.put("error_message", "Key or ID doesn't match! Please check them again.");
			System.out.println(json.toString());
			return;
		}

		int id = getID();
		if (id == -1)
			throw new NumberFormatException("Invalid ID");
		String key = getKey();
		
		Json jo = deleteInfo(id, key);
		System.out.println(jo.toString());
	}


	public Json deleteInfo(int id, String key) {
		Json json = new Json();
		if (db.serverExist(id)) {
			if (db.keyCorrect(id, key)) {
				db.remove(id);
				json.put("error", 0);
				json.put("message", "Server "+id+" was removed!");
			} else {
				json.put("error", 1);
				json.put("error_message", "Key or ID doesn't match! Please check them again.");
			}
		} else {
			json.put("error", 1);
			json.put("error_message", "Key or ID doesn't match! Please check them again.");
		}
		return json;
	}

	public String getKey() {
		return this.args[2];
	}

	public int getID() {
		if (isNumber(this.args[1]))
			return Integer.parseInt(this.args[1]);
		return -1;
	}
	
	public boolean isNumber(String str)
	{
	    if (str == null) {
	            return false;
	    }
	    int length = str.length();
	    if (length == 0) {
	            return false;
	    }
	    int i = 0;
	    if (str.charAt(0) == '-') {
	            if (length == 1) {
	                    return false;
	            }
	            i = 1;
	    }
	    for (; i < length; i++) {
	            char c = str.charAt(i);
	            if (c <= '/' || c >= ':') {
	                    return false;
	            }
	    }
	    return true;
	}
	
	public boolean enoughArgs() {
		return this.args.length == 3;
	}
}
