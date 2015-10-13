package webserver;

import static spark.Spark.*;

public class TestingTesting {
	
	public static void main(String [] args){
		get("/hello",(req, res) -> "Hello World");
		
		get("/bye",(req, res) -> "Bye World");
		
		get("/hello/:name",(req, res) ->{
			res.status(200);
			res.type("application/json");
			return "Hello: "+req.params(":name");
		});
	}

}
