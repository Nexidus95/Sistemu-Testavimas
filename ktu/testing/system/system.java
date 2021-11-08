package ktu.testing.system;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.List;

import ktu.testing.Json;
import ktu.testing.db;

public class system {
	
	public system(String[] args) {
		for (List<String> line : db.getServers()) {
			getPlayers(line.get(0), line.get(3), Integer.valueOf(line.get(4)));
		}
	}
	
	private void getPlayers(String ID, String IP, int port) {
		Json json = new Json();
		String[] info = connect(IP, port);
		json.put("ID", ID);
		json.put("Current players", info[0]);
		json.put("Max players", info[1]);
		json.put("MOTD", info[2]);
		System.out.println(json);
	}
	
   @SuppressWarnings("resource")
   public String[] connect(String IP, int port) {
        try {
        	Socket sock = new Socket(IP, port);
        	 
        	DataOutputStream out = new DataOutputStream(sock.getOutputStream());
        	DataInputStream in = new DataInputStream(sock.getInputStream());
        	 
        	out.write(0xFE);
        	 
        	int b;
        	StringBuffer str = new StringBuffer();
        	while ((b = in.read()) != -1) {
        	if (b != 0 && b > 16 && b != 255 && b != 23 && b != 24) {
        	// Not sure what use the two characters are so I omit them
        	str.append((char) b);
        	}
        	}
        	 
        	String[] data = str.toString().split("§");
        	String serverMotd = data[0];
        	int onlinePlayers = Integer.parseInt(data[1]);
        	int maxPlayers = Integer.parseInt(data[2]);
            return new String[] {onlinePlayers+"", maxPlayers+"", serverMotd};
        } catch (SocketTimeoutException e) {
        } catch (IOException e) {
        } catch (Exception e) {
        }
        return new String[] {"0", "0", "Offline"};
    }
	

}
