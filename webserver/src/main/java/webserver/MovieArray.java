package webserver;

public class MovieArray {
	
	
	private Movie[] Search;
	
	public MovieArray(){
			
		}
	public Movie[] getMovie(){
		return this.Search;
	}
	public void setSearch(Movie[] array){
		this.Search=array;
	}
}
