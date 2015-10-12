package webserver;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
        
        get("/bye", (req, res) -> "Bye World");
        
        get("/hello/:name", (request, response) -> {
        	 response.status(200);
             response.type("application/json");
            return "Hello: " + request.params(":name");
        });
        
    }
}
