package webserver;

import static spark.Spark.*;



public class WebServer {
	
	private static QueryController controller=new QueryController();

	public static void main(String[] args){
		
		get("/search/:name",(request, res) ->{
			res.type("text/json");	//?
			res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Request-Method", "*");
            res.header("Access-Control-Allow-Headers", "*");
			return controller.search(request.params(":name"));
		});				
		
		//Hämta full info för film med 100% titel från sökresultat.
		get("/info/:name",(request, res) ->{
			res.type("text/json");	//?
			res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Request-Method", "*");
            res.header("Access-Control-Allow-Headers", "*");
			return controller.info(request.params(":name"));
		});
		
		//Hämta en trailer.
		get("/trailer/:name",(request, res) ->{
			res.type("text/json");	//?
			res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Request-Method", "*");
            res.header("Access-Control-Allow-Headers", "*");
			return controller.trailer(request.params(":name"));
		});
	}
		    
		  
		 
		  

	
	    
}