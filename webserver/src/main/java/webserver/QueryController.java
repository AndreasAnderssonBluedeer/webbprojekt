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
import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;
/**
 * Hanterar Querys. Ser till att anropen utför i rätt ordning för att konverteras,hämtas,sorteras och returneras.
 * @author Andreas
 *
 */
public class QueryController {

	private APIConnector apiC=new APIConnector();
	private ResultSorter rs=new ResultSorter(this);
	private QueryConverter qc=new QueryConverter();
	
	//Temporärt
	 public static int PRETTY_PRINT_INDENT_FACTOR = 4;
	    public static String TEST_XML_STRING =
	        "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";
	
	    //Short plot,Poster, Year,Genre,Rating,Title
	public String search(String query){	
		/*array[0]=title;
		array[1]=genre;
		array[2]=year;
		array[3]=rating;
		array[4]=apiSearch (Title&year färdigt för APIConnector.);*/
		
		String [] array=qc.search(query);	//Sortera ut query egenskaperna.
		String apiResponse=apiC.getSearch(array[4]);
		
		return rs.filterSearch(apiResponse, array[1], array[3]);	//Sortera efter genre och rating.
	}
	public String sort(String query){
			
			
			return null;
		}
	//Hämta full info för en film när man har full titel. 
	public String info(String query){
		System.out.println(query);
		
		return apiC.getInfo(qc.info(query));
	}
	
	public String trailer(String query){
		
		
		return null;
	}
	    
	public static void main(String [] args){
		QueryController cont=new QueryController();
	//	cont.search("s=Harry+Potter&g=Drama&y=&r=8");
		cont.search("s=Harry+Potter&g=Family&y=&r=");
	//	cont.search("s=Harry+Potter&g=&y=&r=8");
	}
	    
	    
	    
	
}
