package webserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.bind.JAXBContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;

/**
 * kopplar upp sig mot OMDB och TrailerAddict APIerna och returnerar resultaten.
 * @author Andreas
 *
 */
public class APIConnector {

	
	//Hämta full info för en film
	public String getInfo(String query){
		
		HttpClient httpclient = null;
		HttpGet httpGet = null;
		HttpResponse response = null;
		StatusLine status = null;
		HttpEntity entity = null;
		InputStream data = null;
		Reader reader = null;
		Movie movie=null;
		Gson gson = new Gson();
		
		try {
			// Create the client that will call the API
			httpclient = HttpClients.createDefault();
			httpGet = new HttpGet("http://www.omdbapi.com/?t="+query+"&y=&plot=full&r=json");

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
					movie = gson.fromJson(reader, Movie.class);
					
					System.out.println("********* HTTP-GET /info/"+query+" **********");
					System.out.println("Title: " + movie.getTitle());

				} catch (Exception e) {
					// Something didn't went well. No calls for us.
					e.printStackTrace();
					System.out.println("OMDB API didn't respond in a good manner.");
					return gson.toJson("OMDB API didn't respond in a good manner.");
					
				}
			} else {
				// Something didn't went well. No calls for us.
				System.out.println("OMDB API didn't respond in a good manner.");
				return gson.toJson("OMDB API didn't respond in a good manner.");
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return gson.toJson(movie);
        
		
		
	}
	
	public String getSearch(String query){
		
		HttpClient httpclient = null;
		HttpGet httpGet = null;
		HttpResponse response = null;
		StatusLine status = null;
		HttpEntity entity = null;
		InputStream data = null;
		Reader reader = null;
		MovieArray movie=null;
		Gson gson = new Gson();
		
		try {
			// Create the client that will call the API
			httpclient = HttpClients.createDefault();
			httpGet = new HttpGet("http://www.omdbapi.com/?"+query+"&plot=full&r=json");

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
					movie = gson.fromJson(reader, MovieArray.class);
					
					System.out.println("********* HTTP-GET /Search/"+query+" **********");
					for(int i=0;i<movie.getMovie().length;i++){
						System.out.println(
								
								"Title: " + movie.getMovie()[i].getTitle() + ", Year: " + movie.getMovie()[i].getYear() + ", Actors: " + movie.getMovie()[i].getActors());
						}

				} catch (Exception e) {
					// Something didn't went well. No calls for us.
					e.printStackTrace();
					System.out.println("OMDB API didn't respond in a good manner.");
					return gson.toJson("OMDB API didn't respond in a good manner.");
					
				}
			} else {
				// Something didn't went well. No calls for us.
				System.out.println("OMDB API didn't respond in a good manner.");
				return gson.toJson("OMDB API didn't respond in a good manner.");
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return gson.toJson(movie);
        
		
		
	}
	
	
	//Hämtar och returnerar Trailern.
	public void getTrailer(String query){
		
		HttpClient httpclient = null;
		HttpGet httpGet = null;
		HttpResponse response = null;
		StatusLine status = null;
		HttpEntity entity = null;
		InputStream data = null;
		try {
			// Create the client that will call the API
			httpclient = HttpClients.createDefault();
			httpGet = new HttpGet("http://simpleapi.traileraddict.com/The-Avengers/trailer");

			// Call the API and verify that all went well
			response = httpclient.execute(httpGet);
			status = response.getStatusLine();
			if (status.getStatusCode() == 200) {

				System.out.println("********* OK"+" **********");
				// All went well. Let's fetch the data
				entity = response.getEntity();
				data = entity.getContent();
			
				try {
					// Attempt to parse the data as JSON
					
					JAXBContext jc = JAXBContext.newInstance(XmlClass.class);
					
					XmlClass trailers = (XmlClass) jc.createUnmarshaller().unmarshal(data);
					
				
					Trailer t=trailers.getTrailer();
					System.out.println(t.toString());

				} catch (Exception e) {
					// Something didn't went well. No calls for us.
					e.printStackTrace();
					System.out.println("TrailerAddict API didn't respond in a good manner.");			
					
				}
			} else {
				// Something didn't went well. No calls for us.
				System.out.println("TrailerAddict API didn't respond in a good manner.");
				
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	   	
	
        
	}	
	
	
	
	
	
	
}
