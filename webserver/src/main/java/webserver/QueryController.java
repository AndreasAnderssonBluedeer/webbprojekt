package webserver;
/**
 * QueryController is the logic between the diffrent objects. Its job is to create an structure that is 
 * easy to read and follow. QueryController is the center between all objects communication. 
 * @author Andreas Andersson & David Isberg -Systemutveckling HT-15
 *
 */
public class QueryController {

	private APIConnector apiC=new APIConnector(this);
	private ResultSorter rs=new ResultSorter(this);
	private QueryConverter qc=new QueryConverter();
	
	
	
	    /**
	     * This method recieves a searchquery(String query) for movies from the Server. 
	     * First we need to clean the Query->QueryConverter.
	     * Then get SearchResults-> APIConnector, and at last filter the results if needed.
	     * @param query -the search query.
	     * @return	String
	     */
	public String search(String query){	
		String [] array=qc.search(query);	
		//ARRAY Data positions:
		/*array[0]=title;
		array[1]=genre;
		array[2]=year;
		array[3]=rating;
		array[4]=apiSearch (Title&year ready for APIConnector.);*/
		
		
		String apiResponse=apiC.getSearch(array[4]);
		if(apiResponse==null){
			return rs.filterSearch(apiResponse, array[1], array[3]);
		}else{
		
		return rs.filterSearch(apiResponse, array[1], array[3]);	//Filter by Genre and Rating and return.
	}
	}
	
	/**
	 * Parameter with a search-query for a specific movie, Returns Full information about the Movie+ a Trailer. 
	 * First->Clean the query, and then get the data from 
	 * APIConnector and return it as String (Already converted to JSON. 
	 * @param query -search query
	 * @return String
	 */
	public String info(String query){
		
		return apiC.getInfo(qc.info(query));
	}
	
	/**
	 * The Query parameter is used to find a specific movie trailer. 
	 * Will return a Json doc as String with a Link and Id to the Trailer.
	 * The Search Query will be cleaned and then the APIConnector returns a JSON converted String.
	 * @param query -Search query for specific Trailer
	 * @return String
	 */
	public String trailer(String query){		
		return apiC.getTrailer(qc.cleanTrailerString(query));
	}
	
   
	
}
