package webserver;

import static spark.Spark.*;

/**
 * Webserver that communicates with our Clients and API sources by APIConnector. 
 * Recieves a request and returns a response.
 * Uses Spark's Framework. URL:s :
 * /search/:name	(name= title,genre,year,rating in form: t=title&g=genre&y=year&r=rating
 * /info/:name	(name=movie title)
 * /trailer/:name (name=movie title)
 * @author Andreas Andersson & David Isberg -Systemutveckling HT-15
 *
 */

public class WebServer {
	
	private static QueryController controller=new QueryController();

	public static void main(String[] args){
		
		/**
		 * HTTP-Get request, returns an Array with searchresults for a maximum of 10 movies.Returns as JSON (OMDB API searchlimit)
		 * /search/:name	(name= title,genre,year,rating in form: t=title&g=genre&y=year&r=rating
		 */
		get("/search/:name",(request, res) ->{
			res.type("text/json");	//?
			res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Request-Method", "*");
            res.header("Access-Control-Allow-Headers", "*");
			return controller.search(request.params(":name"));
		});				
		
		/**
		 * HTTP-Get request, returns full information about a movie + a trailer link. Returns as JSON.
		 *  /info/:name	(name=movie title)
		 */
		get("/info/:name",(request, res) ->{
			res.type("text/json");	//?
			res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Request-Method", "*");
            res.header("Access-Control-Allow-Headers", "*");
			return controller.info(request.params(":name"));
		});
		
		
		/**
		 * HTTP-Get request, returns a Trailer link and id as JSON.
		 * /trailer/:name (name=movie title)
		 */
		get("/trailer/:name",(request, res) ->{
			res.type("text/json");	//?
			res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Request-Method", "*");
            res.header("Access-Control-Allow-Headers", "*");
			return controller.trailer(request.params(":name"));
		});
	}
		    
		  
		 
		  

	
	    
}