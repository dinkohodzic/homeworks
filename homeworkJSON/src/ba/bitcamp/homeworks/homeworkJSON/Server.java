package ba.bitcamp.homeworks.homeworkJSON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(7777);
			Socket client = server.accept();
			System.out.println("Client connected");
			
			File textFile = new File("text.txt");
			File jsonFile = new File("objects.json");
			
			

			BufferedReader reader1 = new BufferedReader(
					new FileReader(textFile));

			ArrayList<String> list = new ArrayList<>();
			String line = "" ;
			while ((line = reader1.readLine()) != null) {
				list.add(line);
			}

			String randomLine = list
					.get((int) (Math.random() * list.size()));

			ObjectMapper map = new ObjectMapper();
			BitResponse response = new BitResponse(randomLine,Date.from(Instant.now()));
			map.writeValue(jsonFile, response);

			BufferedReader reader2 = new BufferedReader(
					new FileReader(jsonFile));
			String jsonString = reader2.readLine();
			System.out.println(jsonString);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					client.getOutputStream()));
			writer.write(jsonString);
			writer.flush();
			reader1.close();
			reader2.close();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
