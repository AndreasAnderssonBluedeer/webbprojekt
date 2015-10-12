package webserver;

public class Movie {
	
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
	
	
	public Movie(){
		
	}
	//Movie
	public void setMovie(String Title){
		this.Title=Title;
	}
	public String getMovie(){
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

	public String getimdbRating() {
		return this.imdbRating;
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

/*{"Title":"Harry Potter and the Deathly Hallows: Part 2","Year":"2011","Rated":"PG-13",
 * "Released":"15 Jul 2011","Runtime":"130 min","Genre":"Adventure, Drama, Fantasy","Director":"David Yates",
 * "Writer":"Steve Kloves (screenplay), J.K. Rowling (novel)","Actors":"Ralph Fiennes, Michael Gambon, Alan Rickman, Daniel Radcliffe",
 * "Plot":"Harry, Ron and Hermione search for Voldemort's remaining Horcruxes in their effort to destroy the Dark Lord as the final battle rages on at Hogwarts.",
 * "Language":"English","Country":"USA, UK","Awards":"Nominated for 3 Oscars. Another 48 wins & 77 nominations.",
 * "Poster":"http://ia.media-imdb.com/images/M/MV5BMTY2MTk3MDQ1N15BMl5BanBnXkFtZTcwMzI4NzA2NQ@@._V1_SX300.jpg",
 * "Metascore":"87","imdbRating":"8.1","imdbVotes":"477,389","imdbID":"tt1201607","Type":"movie","Response":"True"}*/
 