package ktu.testing.sitemaps;

import java.util.ArrayList;
import java.util.List;

import ktu.testing.Json;
import ktu.testing.db;

public class sitemaps {

	public sitemaps() {
		List<Json> allServers = getAllServers();
		
		String header = getHeader();
		String generateMiddle = generateMiddle(allServers);
		String footer = getFooter();
		
		String fullSitemap = combineAll(header, generateMiddle, footer);
		System.out.println(fullSitemap);
	}

	private String combineAll(String header, String generateMiddle, String footer) {
		return header+"\n"+generateMiddle+"\n"+footer;
	}

	private String generateMiddle(List<Json> allServers) {
		String toReturn = "";
		for (Json json : allServers) {
			toReturn += "<url><loc>https://minecraftsurvivalservers.com/server/"+json.get("ip")+"/"+json.get("id")+"</loc></url>";
		}
		return toReturn;
	}

	private String getHeader() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\" xmlns:news=\"http://www.google.com/schemas/sitemap-news/0.9\" xmlns:xhtml=\"http://www.w3.org/1999/xhtml\" xmlns:mobile=\"http://www.google.com/schemas/sitemap-mobile/1.0\" xmlns:image=\"http://www.google.com/schemas/sitemap-image/1.1\" xmlns:video=\"http://www.google.com/schemas/sitemap-video/1.1\">";
	}

	private List<Json> getAllServers() {
		List<Json> temp = new ArrayList<>();
		for (List<String> line : db.getServers()) {
			Json json = new Json();
			json.put("id", line.get(0));
			json.put("key", line.get(1));
			json.put("votes", line.get(2));
			json.put("ip", line.get(3));
			json.put("port", line.get(4));
			temp.add(json);
		}
		return temp;
	}
	
	private String getFooter() {
		return "</urlset>";
	}
}
