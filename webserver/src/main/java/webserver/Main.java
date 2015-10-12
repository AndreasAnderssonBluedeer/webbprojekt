package webserver;

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





public class Main {

	  public static void main(String[] args) throws IOException {
		  HttpClient httpclient = null;
			HttpGet httpGet = null;
			HttpResponse response = null;
			StatusLine status = null;
			HttpEntity entity = null;
			InputStream data = null;
			Reader reader = null;
			
		
		  Gson gson = new Gson();  
		  
		  try {
				// Create the client that will call the API
				httpclient = HttpClients.createDefault();
				httpGet = new HttpGet("http://www.omdbapi.com/?t=harry&y=&plot=short&r=json");
				
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
						Movie movie = gson.fromJson(reader, Movie.class); 
		     
		
		     
		   System.out.println("Title: "+movie.getMovie()+", Year: "+movie.getYear());  
		  
		 
		     
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
		    
		  
		 
		  

	
	    
}