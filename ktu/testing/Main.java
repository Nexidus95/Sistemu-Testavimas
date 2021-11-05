package ktu.testing;

import ktu.testing.index.index;

public class Main {

	public static void main(String[] args) {
		if (args.length == 0) return;
		if (args[0].equals("index")) {
			new index(args);
		}
	}
}
