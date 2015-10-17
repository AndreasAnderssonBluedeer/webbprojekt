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
 * Connector, XML/JSON Converter for OMDB API and TRAILERADDICT API, Returns finished results as
 * JSON. Handles all API communication.
 * @author Andreas Andersson & David Isberg -Systemutveckling HT-15
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
	
	/**
	 * Fetches and Returns full information + trailer for a specific movie as JSON.
	 * Uses OMDB API.
	 * @param query -Movie title to Return
	 * @return String
	 */
	public String getInfo(String query){
	
		try {
			
			httpclient = HttpClients.createDefault();
			httpGet = new HttpGet("http://www.omdbapi.com/?t="+query+"&y=&plot=full&r=json");

		
			response = httpclient.execute(httpGet);
			status = response.getStatusLine();
			if (status.getStatusCode() == 200) {
				
				entity = response.getEntity();
				data = entity.getContent();

				try {
					//Convert to Java Object.
					reader = new InputStreamReader(data);
					movie = gson.fromJson(reader, Movie.class);					
					

				} catch (Exception e) {
					// Something didn't went well.
					e.printStackTrace();
					System.out.println("OMDB API didn't respond in a good manner.");
							
				}
			} else {
				// Something didn't went well.
				System.out.println("OMDB API didn't respond in a good manner.");
					
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Fetch Trailer
		Movie movieTemp;
		movieTemp = gson.fromJson(controller.trailer(movie.getTitle()), Movie.class);
		//Return as JSON
		movie.setTrailer(movieTemp.getTrailer());
		return gson.toJson(movie);		
		
	}
	
	/**
	 * Fetches MovieResults and Returns them as JSON.
	 * Uses OMDB API.
	 * @param query -Search parameters.
	 * @return String
	 */
	public String getSearch(String query){
				
		MovieArray movie=null;
		
		try {
	
			httpclient = HttpClients.createDefault();
			httpGet = new HttpGet("http://www.omdbapi.com/?"+query+"&plot=full&r=json");

			
			response = httpclient.execute(httpGet);
			status = response.getStatusLine();
			if (status.getStatusCode() == 200) {
			
				entity = response.getEntity();
				data = entity.getContent();

				try {
					//Convert to Java Object.
					reader = new InputStreamReader(data);
					movie = gson.fromJson(reader, MovieArray.class);					
				

				} catch (Exception e) {
					// Something didn't went well.
					e.printStackTrace();
					System.out.println("OMDB API didn't respond or couldn't find any result");
									
				}
			} else {
				// Something didn't went well. 
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
	
	
	/**
	 * Fetches and returns a specific Trailer as a JSON String.
	 * Uses TRAILERADDICT API. Converts from XML to JSON.
	 * @param query -TrailerTitle
	 * @return String
	 */
	public String getTrailer(String query) {

		Trailer t = new Trailer();
		try {
		
			httpclient = HttpClients.createDefault();
			httpGet = new HttpGet("http://simpleapi.traileraddict.com/" + query + "/trailer");

			
			response = httpclient.execute(httpGet);
			status = response.getStatusLine();
			if (status.getStatusCode() == 200) {

			
				entity = response.getEntity();
				data = entity.getContent();

				try {
					//Convert from XML to JAVA
					JAXBContext jc = JAXBContext.newInstance(XmlClass.class);
					XmlClass trailers = (XmlClass) jc.createUnmarshaller().unmarshal(data);
					t = trailers.getTrailer();
				} catch (Exception e) {
					// Something didn't went well.
					System.out.println(
							"************TrailerAddict API didn't respond or couldn't find the trailer.************");
				}
			} else {
				// Something didn't went well.
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
