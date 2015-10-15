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
	
	private QueryController controller;
	private HttpClient httpclient = null;
	private HttpGet httpGet = null;
	private HttpResponse response = null;
	private StatusLine status = null;
	private HttpEntity entity = null;
	private InputStream data = null;
	private Reader reader = null;
	private Movie movie=null;
	private Gson gson = new Gson();
	
	public APIConnector(QueryController controller){
		this.controller=controller;
	}
	
	//Hämta full info för en film
	public String getInfo(String query){
	
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
					

				} catch (Exception e) {
					// Something didn't went well. No calls for us.
					e.printStackTrace();
					System.out.println("OMDB API didn't respond in a good manner.");
							
				}
			} else {
				// Something didn't went well. No calls for us.
				System.out.println("OMDB API didn't respond in a good manner.");
					
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//måste in i queryController till QueryConverter först.!!
		Movie movieTemp;
		movieTemp = gson.fromJson(controller.trailer(movie.getTitle()), Movie.class);
		
		movie.setTrailer(movieTemp.getTrailer());
		return gson.toJson(movie);		
		
	}
	
	public String getSearch(String query){
				
		MovieArray movie=null;
		
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
				

				} catch (Exception e) {
					// Something didn't went well. No calls for us.
					e.printStackTrace();
					System.out.println("OMDB API didn't respond or couldn't find any result");
									
				}
			} else {
				// Something didn't went well. No calls for us.
				System.out.println("OMDB API didn't respond or couldn't find any result");
					
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(movie.getMovie()==null){
			return null;
		}
		return gson.toJson(movie);	
	}
	
	
	//Hämtar och returnerar Trailern.
	public String getTrailer(String query) {

		Trailer t = new Trailer();
		try {
			// Create the client that will call the API
			httpclient = HttpClients.createDefault();
			httpGet = new HttpGet("http://simpleapi.traileraddict.com/" + query + "/trailer");

			// Call the API and verify that all went well
			response = httpclient.execute(httpGet);
			status = response.getStatusLine();
			if (status.getStatusCode() == 200) {

				// All went well. Let's fetch the data
				entity = response.getEntity();
				data = entity.getContent();

				try {
					// Attempt to parse the data as JSON
					JAXBContext jc = JAXBContext.newInstance(XmlClass.class);
					XmlClass trailers = (XmlClass) jc.createUnmarshaller().unmarshal(data);
					t = trailers.getTrailer();
				} catch (Exception e) {
					// Something didn't went well. No calls for us.
					System.out.println(
							"************TrailerAddict API didn't respond or couldn't find the trailer.************");
				}
			} else {
				// Something didn't went well. No calls for us.
				System.out.println(
						"************TrailerAddict API didn't respond or couldn't find the trailer.************");
			}
		} catch (IOException e) {
			System.out.println("************Something went wrong.************");
			e.printStackTrace();
		}
		return gson.toJson(t);
	}

}
