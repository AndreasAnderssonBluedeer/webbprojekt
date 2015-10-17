package webserver;

/**
 * MovieArray is used to convert Movie-Search response from Json to Java Object. 
 * Gets and Sets a Movie[]
 * @author Andreas Andersson & David Isberg -Systemutveckling HT-15
 *
 */
public class MovieArray {
	
	
	private Movie[] Search;
	
	/**
	 * Return the Movie[]
	 * @return Movie[]
	 */
	public Movie[] getMovie(){
		return this.Search;
	}
	
	/**
	 * Sets the Movie[] with parameter "array"
	 * @param array -the Movie[]
	 */
	public void setSearch(Movie[] array){
		this.Search=array;
	}
}
