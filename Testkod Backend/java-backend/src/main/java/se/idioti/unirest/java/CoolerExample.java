package se.idioti.unirest.java;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;

import se.idioti.unirest.java.beans.Channel;
import se.idioti.unirest.java.beans.Envelope;
import se.idioti.unirest.java.beans.Playlist;
import se.idioti.unirest.java.beans.Song;

public class CoolerExample {
	public static void main(String[] args) {
		String url = "http://api.sr.se/api/v2/playlists/rightnow?channelid=2576&format=json";
		
		HttpClient httpclient = null;
		HttpGet httpGet = null;
		HttpResponse response = null;
		StatusLine status = null;
		HttpEntity entity = null;
		InputStream data = null;
		Reader reader = null;
		
		Gson json = new Gson();
		
		Envelope envelope = null;
		Playlist playlist = null;
		
		try {
			// Create the client that will call the API
			httpclient = HttpClients.createDefault();
			httpGet = new HttpGet(url);
			
			// Call the API and verify that all went well
			response = httpclient.execute(httpGet);
			status = response.getStatusLine();
			if (status.getStatusCode() == 200) {
				// All went well. Let's fetch the data
				entity = response.getEntity();
				data = entity.getContent();
				
				try {
					// Attempt to parse the data as JSON
					reader = new InputStreamReader(data);
					envelope = json.fromJson(reader, Envelope.class);
					playlist = envelope.getPlaylist();
					
					// Print the info
					printChannel(playlist.getChannel());
					if (playlist.getSong() != null) {
					printSong(playlist.getSong());
					}
					if (playlist.getNextSong() != null) {
						printSong(playlist.getNextSong());
					}
				} catch (Exception e) {
					// Something didn't went well. No calls for us.
					e.printStackTrace();
					System.out.println("SR didn't respond in a good manner.");
				}
			} else {
				// Something didn't went well. No calls for us.
				System.out.println("SR didn't respond in a good manner.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printChannel(Channel channel) {
		System.out.println("Channel name: " + channel.getName());
		System.out.println("Channel id: " + channel.getId());
	}
	
	public static void printSong(Song song) {
		System.out.println("Artist: " + song.getArtist());
		System.out.println("Title: " + song.getTitle());
		System.out.println("Description: " + song.getDescription());
	}
}
