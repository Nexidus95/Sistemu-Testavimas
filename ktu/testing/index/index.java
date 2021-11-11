package ktu.testing.index;

import ktu.testing.Json;
import ktu.testing.db;

public class index {
	
	private String[] args;
	
	public index() {
		
	}
	public index(String[] args) {
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
		String key = getKey();
		String name = getName();
		
		Json jo = getAnwser(id, key, name);
		System.out.println(jo.toString());
	}
	
	public Json getAnwser(int id, String key, String name) {
		Json json = new Json();
		if (name == null) {
			if (db.serverExist(id)) {
				if (db.keyCorrect(id, key)) {
					int votes = db.getVotes(id, key);
					json.put("error", 0);
					json.put("votes", votes);
				} else {
					json.put("error", 1);
					json.put("error_message", "Key or ID doesn't match! Please check them again.");
				}
			} else {
				json.put("error", 1);
				json.put("error_message", "Key or ID doesn't match! Please check them again.");
			}
		} else {
			if (db.serverExist(id)) {
				if (db.keyCorrect(id, key)) {
					boolean voted = db.didVote(id, key, name);
					json.put("error", 0);
					json.put("voted", voted);
				} else {
					json.put("error", 1);
					json.put("error_message", "Key or ID doesn't match! Please check them again.");
				}
			} else {
				json.put("error", 1);
				json.put("error_message", "Key or ID doesn't match! Please check them again.");
			}
		}
		return json;
	}

	public String getName() {
		if (this.args.length == 4)
			return this.args[3];
		return null;
	}

	public String getKey() {
		return this.args[2];
	}

	public int getID() throws NumberFormatException {
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
		return this.args.length >= 3;
	}

}
