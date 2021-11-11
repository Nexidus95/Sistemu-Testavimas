package ktu.testing;

import ktu.testing.delete.delete;
import ktu.testing.index.index;
import ktu.testing.sitemaps.sitemaps;
import ktu.testing.system.system;

public class Main {

	public static void main(String[] args) {
		if (args.length == 0) return;
		if (args[0].equals("index")) {
			new index(args).run();
		}
		if (args[0].equals("delete")) {
			new delete(args).run();
		}
		if (args[0].equals("system")) {
			new system();
		}
		if (args[0].equals("sitemap")) {
			new sitemaps();
		}
	}
}
