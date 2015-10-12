package webserver;

public class Movie {
	
	private String Title;
	private String Year;
	public Movie(){
		
	}
	public void setMovie(String Title){
		this.Title=Title;
	}
	public void setString(String Year){
		this.Year=Year;
	}
	public String getMovie(){
		return this.Title;
	}
	public String getYear(){
		return this.Year;
	}
}
