package webserver;

import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

/**
 * Sortera sökresultat i viss ordning. 
 * @author Andreas
 *
 */
public class ResultSorter {
	
	private QueryController qc;
	private InputStreamReader reader;
	private Gson gson = new Gson();
	
	public ResultSorter(QueryController qc){
		this.qc=qc;
	}
	
	
	public void sortByGenre(){
		
	}
	public void sortByYear(){
			
		}
	public void sortByTitle(){
		
	}
	public void sortByDirector(){
		
	}
	public void sortByRating(){
		
	}
	public void sortByLength(){
		
	}
	public String filterSearch(String apiRes,String genre,String rating){
		Double rate;
		
		if(rating.equals("")){
			rate=0.0;
		}
		else{
		rate=Double.parseDouble(rating);
		}
		
		MovieArray movieArray;
		ArrayList<Movie> movieList=new ArrayList<Movie>();
		System.out.println("Genre:"+genre+" Rating:"+rating);
		movieArray = gson.fromJson(apiRes, MovieArray.class);
		
		for(int i=0;i<movieArray.getMovie().length;i++){
			movieList.add(gson.fromJson(qc.info(movieArray.getMovie()[i].getTitle()),Movie.class));
		}
		
		
		for(int i=movieList.size()-1;i>=0;i--){
			if( !movieList.get(i).getGenre().contains(genre) || movieList.get(i).getimdbRating()<rate){
		
				movieList.remove(i);
			}
		}
		Movie[] newArray= new Movie[movieList.size()];
		MovieArray newMovieArray=new MovieArray();
	
		for(int i=0;i<newArray.length;i++){
			newArray[i]=movieList.get(i);
		}
		newMovieArray.setSearch(newArray);
		
		
		
		return gson.toJson(newMovieArray);
	}
}
