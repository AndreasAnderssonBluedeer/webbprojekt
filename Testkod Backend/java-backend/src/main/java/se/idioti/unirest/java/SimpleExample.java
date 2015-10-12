package se.idioti.unirest.java;

import java.io.IOException;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * This is a very simple example of how to use Unirest in conjunction with the
 * Sveriges Radio web API.
 * 
 * @author "Johan Holmberg, Malmö university"
 * @since 1.0
 */
public class SimpleExample {
	public static void main(String[] args) {
		HttpResponse<JsonNode> response;
		
		try {
			response = Unirest.get("http://api.sr.se/api/v2/channels/132")
					.queryString("format", "json")
					.asJson();
			
			System.out.println("Response from SR:");
			System.out.println(response.getBody());
			System.out.println();
			
			JsonNode json = response.getBody();
			JSONObject envelope = json.getObject();
			JSONObject channel = envelope.getJSONObject("channel");
			
			System.out.println("Channel name: " + channel.getString("name"));
			System.out.println("Channel id: " + channel.getInt("id"));
			
			JSONObject stream = channel.getJSONObject("liveaudio");
			System.out.println("Strean URL: " + stream.getString("url"));
			
			Unirest.shutdown();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
