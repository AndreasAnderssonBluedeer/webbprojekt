package test;

/**
 * This class is mainly used for JSON to Java converting of a movie-search response. 
 * a Bunch of variables for Title,Genre,Rating ETC.  OBS:DO NOT CHANGE VARIABLE NAMES!!! JSON CONVERTION WON'T WORK!
 * 
 *  **Every InstanceVariable has 2 methods, 1 set() & 1 get(). Methodstructure: set+variableName(String x), get+variableName()
 *  EX: setTitle(String title), getTitle()
 *@author Andreas Andersson & David Isberg -Systemutveckling HT-15
 *
 */


public class Movie {
	
	private String trailer_link;
	private String Title;
	private String Year;
	private String Rated;
	private String Released;
	private String Runtime;
	private String Genre;
	private String Director;
	private String Writer;
	private String Actors;
	private String Plot;
	private String Language;
	private String Country;
	private String Awards;
	private String Poster;
	private String Metascore;
	private String imdbRating;
	private String imdbVotes;
	private String imdbID;
	private String Type;
	private String Response;
	
	
	
	//Trailer
	public void setTrailer(String trailer){
		this.trailer_link=trailer;
	}
	public String getTrailer(){
		return this.trailer_link;
	}
	//Movie
	public void setTitle(String Title){
		this.Title=Title;
	}
	public String getTitle(){
		return this.Title;
	}
	//Year
	public void setYear(String Year){
		this.Year=Year;
	}
	public String getYear(){
		return this.Year;
	}
	//Rated
	public void setRated(String Rated){
		this.Rated=Rated;
	}
	public String getRated(){
		return this.Rated;
	}
	//Released
	public void setReleased(String Released){
		this.Released=Released;
	}
	public String getReleased(){
		return this.Released;
	}
	//Runtime
	public void setRuntime(String Runtime){
		this.Runtime=Runtime;
	}
	
	public String getRuntime(){
		return this.Runtime;
	}
	//Genre
	public void setGenre(String Genre){
		this.Genre=Genre;
	}
	
	public String getGenre(){
		return this.Genre;
	}
	//Director
	public void setDirector(String Director){
		this.Director=Director;
	}
	
	public String getDirector(){
		return this.Director;
	}
	//Writer
	public void setWriter(String Writer){
		this.Writer=Writer;
	}
	
	public String getWriter(){
		return this.Writer;
	}

	// Plot
	public void setPlot(String Plot) {
		this.Plot = Plot;
	}

	public String getPlot() {
		return this.Plot;
	}
	
	//Actors
	public void setActors(String Actors){
		this.Actors=Actors;
	}
	
	public String getActors(){
		return this.Actors;
	}

	// Language
	public void setLanguage(String Language) {
		this.Language = Language;
	}

	public String getLanguage() {
		return this.Language;
	}

	// Country
	public void setCountry(String Country) {
		this.Country = Country;
	}

	public String getCountry() {
		return this.Country;
	}

	// Awards
	public void setAwards(String Awards) {
		this.Awards = Awards;
	}

	public String getAwards() {
		return this.Awards;
	}

	// Poster
	public void setPoster(String Poster) {
		this.Poster = Poster;
	}

	public String getPoster() {
		return this.Poster;
	}

	// Metascore
	public void setMetascore(String  Metascore) {
		this. Metascore =  Metascore;
	}

	public String getMetascore() {
		return this. Metascore;
	}

	// imdbRating
	public void setimdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public Double getimdbRating() {
		if(imdbRating.equals("N/A")){
			return 0.0;
		}else{
		return Double.parseDouble(this.imdbRating);
		}
	}

	// imdbVotes
	public void setimdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getimdbVotes() {
		return this.imdbVotes;
	}

	// imdbID
	public void setimdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getimdbID() {
		return this.imdbID;
	}

	// Type
	public void setType(String Type) {
		this.Type = Type;
	}

	public String getType() {
		return this.Type;
	}

	// Response
	public void setResponse(String Response) {
		this.Response = Response;
	}

	public String getResponse() {
		return this.Response;
	}
}

