package webserver;

import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

/**
 * ResultSorter adds the functionality to search for Genre and Rating.
 * Fetches and returns a filtered movie-search.
 * @author Andreas Andersson & David Isberg -Systemutveckling HT-15
 *
 */
public class ResultSorter {
	
	private QueryController qc;
	private InputStreamReader reader;
	private Gson gson = new Gson();
	
	/**
	 * Constructor that sets QueryController.
	 * @param qc - a control class used to get data from.
	 */
	public ResultSorter(QueryController qc){
		this.qc=qc;
	}
	
	/**
	 * This Method recieves an query string for Title and year.
	 * The method fetches the results and then executes a control whether 
	 * the Genre and Rating is true for the movie or not and removes the false
	 * movies from the list and returns it as a String.
	 * 
	 * @param apiRes - Title and Year query- ready for API.
	 * @param genre -The Genre to be Filtered
	 * @param rating -The Rating to be Filtered
	 * @return String
	 */
	public String filterSearch(String apiRes,String genre,String rating){
		Double rate;
		//If Rating doesnt Exist- get rid of nullpointer.
		if(rating.equals("")){
			rate=0.0;
		}
		else{
		rate=Double.parseDouble(rating);
		}
		
		MovieArray movieArray;
		ArrayList<Movie> movieList=new ArrayList<Movie>();
		
		movieArray = gson.fromJson(apiRes, MovieArray.class);
		//Add the movieresults to a dynamic list.
		for(int i=0;i<movieArray.getMovie().length;i++){
			movieList.add(gson.fromJson(qc.info(movieArray.getMovie()[i].getTitle()),Movie.class));
		}
		
		//Filter by Genre and Rating
		for(int i=movieList.size()-1;i>=0;i--){
			if( !movieList.get(i).getGenre().contains(genre) || movieList.get(i).getimdbRating()<rate){
		
				movieList.remove(i);
			}
		}
		//Prepare to return the Movie-Array results as JSON.
		Movie[] newArray= new Movie[movieList.size()];
		MovieArray newMovieArray=new MovieArray();
	
		for(int i=0;i<newArray.length;i++){
			newArray[i]=movieList.get(i);
		}
		newMovieArray.setSearch(newArray);
		
		return gson.toJson(newMovieArray);
	}
}
