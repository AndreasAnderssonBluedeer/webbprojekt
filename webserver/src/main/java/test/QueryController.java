package test;

import com.google.gson.Gson;

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
		/*//Fetch Trailer
		Movie movieTemp;
		movieTemp = gson.fromJson(controller.trailer(movie.getimdbID()), Movie.class);
		//Return as JSON
		movie.setTrailer(movieTemp.getTrailer());
		return gson.toJson(movie);		
		 * 
		 */
		Gson gson=new Gson();
		Movie movie=apiC.getInfo(qc.info(query));
		Movie movieTemp;
		movieTemp = gson.fromJson(trailerByImdb(movie.getimdbID()), Movie.class);
		if(movieTemp==null){
			movieTemp = gson.fromJson(trailerByTitle(movie.getTitle()), Movie.class);
		}
		
		if(movieTemp!=null){
			movie.setTrailer(movieTemp.getTrailer());
		}
		
		
		return gson.toJson(movie);		
		 
		//return apiC.getInfo(qc.info(query));
	}
	
	/**
	 * The Query parameter is used to find a specific movie trailer. 
	 * Will return a Json doc as String with a Link and Id to the Trailer.
	 * The Search Query will be cleaned and then the APIConnector returns a JSON converted String.
	 * @param query -Search query for specific Trailer
	 * @return String
	 */
	public String trailerByImdb(String query){	
		Gson gson=new Gson();
		query=apiC.getTrailerTitle(qc.cleanImdbID(query));
		if(query==null){
			
			return null;
		}else{
		return gson.toJson(apiC.getTrailer("http://simpleapi.traileraddict.com/" + qc.cleanTrailerTitle(query)+ "/trailer"));
		}
		
	}
	
	public String trailerByTitle(String query){		
	//	return apiC.getTrailer(qc.cleanTrailerString(query));
		String[] array=qc.cleanTrailerString(query);
		/* array pos:
		 * 0= the entire title to lowchars and "space"="-"
		 * 1= as 0 but without "the"
		 * 2= as 1 but without "and"
		 * 3= as 2 but without "of"
		 */
		Movie movieTemp;
		String str=null;
		Gson gson=new Gson();
		//"http://simpleapi.traileraddict.com/" + query + "/trailer"
		for(int i=0;i<array.length;i++){
			System.out.println("TESTING:"+array[i]);
		//	Trailer trailer=apiC.getTrailer(array[i]);
			Trailer trailer=apiC.getTrailer("http://simpleapi.traileraddict.com/" + array[i]+ "/trailer");
		if(trailer.getTrailerID()!=null){
			str=gson.toJson(trailer);
			System.out.println("RETURN:"+str);
			return str;
		}
		}
		
		for(int i=0;i<array.length;i++){
			System.out.println("TESTING:"+array[i]);
		//	Trailer trailer=apiC.getTrailer(array[i]);
			Trailer trailer=apiC.getTrailer("http://simpleapi.traileraddict.com/" + array[i]+ "/trailer-a");
		if(trailer.getTrailerID()!=null){
			str=gson.toJson(trailer);
			System.out.println("RETURN:"+str);
			return str;
		}
		}
		for(int i=0;i<array.length;i++){
			System.out.println("TESTING:"+array[i]);
		//	Trailer trailer=apiC.getTrailer(array[i]);
			Trailer trailer=apiC.getTrailer("http://simpleapi.traileraddict.com/" + array[i]+ "/trailer-b");
		if(trailer.getTrailerID()!=null){
			str=gson.toJson(trailer);
			System.out.println("RETURN:"+str);
			return str;
		}
		}
		return null;
		
	}
	public String searchInfo(String query){
		
		Gson gson=new Gson();
		Movie movie=apiC.getInfo(qc.info(query));

		return gson.toJson(movie);		
		 
		
	}
   
	
}
