package ba.bitcamp.homeworks.homeworkJSON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.codehaus.jackson.map.ObjectMapper;

public class Client {

	public static void main(String[] args) {
		try {
			Socket client = new Socket("localhost", 7777);

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					client.getOutputStream()));
			writer.write("Request");
			writer.flush();
			System.out.println("Request sent");

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			ObjectMapper map = new ObjectMapper();
			BitResponse response = map.readValue(reader.readLine(), BitResponse.class);
			System.out.println(response.getMessage());
			System.out.println(response.getTimestamp());
			writer.close();
			client.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
