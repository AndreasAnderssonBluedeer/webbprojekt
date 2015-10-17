package webserver;


/**
 * QueryConverter converters or improves the search-queries. It separates title, genre,year and rating from movie search,
 * replaces " " with "+" to make a searchable link to the OMDB API etc. All information that needs to be handled from the query 
 * will be done in this class.
 * @author Andreas Andersson & David Isberg -Systemutveckling HT-15
 *
 */
public class QueryConverter {
	
	
	private String badChars[]= {" ","_","^","<",">","{","}","[","]","~"};		//Array with bad Characters
	
	

	/**
	 * Creates and returns a String[] from a Movie-Search query to make it possible to filter and search with
	 * title,Genre,Year and Rating. Splits the Query, and then exchange/removes bad chars.  
	 * QUERY STRUCTURE: search/s=title&g=genre&y=year&r=rating
	 * @param query -search query
	 * @return String[]
	 */
	public String[] search(String query){
		
		String [] array= new String[5];
		String title = null,genre=null,year=null,rating=null,apiSearch=null;
		
		title=getField(query,'g');
		query=query.substring(title.length()+1);		
		genre=getField(query,'y');
		query=query.substring(genre.length()+1);		
		year=getField(query,'r');		
		rating=query.substring(year.length()+1);
		
		//Clean Strings
		title=cleanMovieString(title);
		year=cleanMovieString(year);
				
		apiSearch=title+"&"+year;
		
		array[0]=title;
		array[1]=cleanField(genre);
		array[2]=year;
		array[3]=cleanField(rating);
		array[4]=apiSearch;
		
		
		
		return array;
	}
	
	/**
	 * Separates Field from Value in Query parameters. Example: t=title -return title.
	 * @param field -string to be separated
	 * @return String
	 */
	public String cleanField(String field){

		return field=field.substring(2, field.length());
	}
	
	/**
	 * Cleans the Movie-Search Query String from Bad chars.
	 * Returns the cleans String.
	 * @param string - search query to clean
	 * @return String
	 */
	public String cleanMovieString(String string){
		
		for(int i=0;i<badChars.length;i++){
			if(string.contains(badChars[i])){
				string=string.replace(badChars[i],"+");	
			}
			}

		return string;
	}
	
	/**
	 * Cleans Trailer query String. More complex than MovieSearch since
	 * it doesnt use "The,And,Of" etc in API search for specific Trailer. 
	 * Returns the Cleaned String
	 * @param string -Trailer query String to be Cleaned
	 * @return String 
	 */
	public String cleanTrailerString(String string){
		
		string=string.toLowerCase();
		String [] badWords= {"the","and","of"};
		
		//Replace bad Chars
		for(int i=0;i<badChars.length;i++){
			if(string.contains(badChars[i])){
				string=string.replace(badChars[i],"-");	
			}
			}
		//Replace bad Words
		for(int i=0;i<badWords.length;i++){
			if(string.contains(badWords[i])){
				string=string.replace(badWords[i],"");	
			}
			}
			//Remove "--"
		for(int i=0;i<string.length();i++){
			if( string.charAt(i)=='-' && string.charAt(i+1)=='-'){
				StringBuilder fixedString = new StringBuilder(string);
				fixedString.deleteCharAt(i);
				string=fixedString.toString();
				i--;
			}
			}
		//If first char is "-" , Remove it.
		StringBuilder fixedString = new StringBuilder(string);
		if(fixedString.charAt(0)=='-'){
			fixedString.deleteCharAt(0);
			string=fixedString.toString();
		}
		
		return string;
	}
	
	/**
	 * Separates the diffrent MovieSearch parameters. Example:From: t=title&y=year To:t=title 
	 * Returns the Separate Parameter.
	 * @param query - Movie Search Query to Separate
	 * @param field -Field identifier, EX:'t' (t=title)
	 * @return String
	 */
	public String getField(String query,char field){
		String answer=null;
		
		for(int i=0;i<query.length();i++){
			if(query.charAt(i)=='&' && query.charAt(i+1)==field && query.charAt(i+2)=='='){
				answer=query.substring(0, i);	
				i=query.length();	//Break the Loop.
			}
		}		
		return answer;
	}
	
	/**
	 * Returns the Value of a Field. EX t=title , return "title"
	 * @param field -String field to get value from.
	 * @return String
	 */
	public String getValue(String field){		
		field=field.substring(2,field.length());		
		return field;
	}
	
	/**
	 * Calls for cleaning of MovieString Query and returns it. 
	 * @param query -movie search
	 * @return String 
	 */
	public String info(String query){		
		query=cleanMovieString(query);
		return query;	
	}
	
}
