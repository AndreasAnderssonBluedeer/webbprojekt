package test;


/**
 * QueryConverter converters or improves the search-queries. It separates title, genre,year and rating from movie search,
 * replaces " " with "+" to make a search-able link to the OMDB API etc. All information that needs to be handled from the query 
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
	
	
	public String[] cleanTrailerString(String string){
		String[] array= new String[4];
		string=string.toLowerCase();
		
			string=string.replace("'","");	
		
		
		String [] badWords= {"the","and","of"};
		
		//Replace bad Chars
		for(int i=0;i<badChars.length;i++){
			if(string.contains(badChars[i])){
				string=string.replace(badChars[i],"-");	
			}
			}
		array[0]=string;
		
		//Replace bad Words
		for(int i=0;i<badWords.length;i++){
			if(string.contains(badWords[i])){
				string=string.replace(badWords[i],"");	
						//pos: 1- without "the",2- without "and",3- without "of",
			}
			array[i+1]=string;
			}
		
			//Remove "--"
		for(int k=0;k<array.length;k++){
			string=array[k];
			
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
		array[k]=string;	//Give array[k] the cleaned String.
		}
		return array;
	}
	
	
	public String cleanImdbID(String string){
		string=string.replace("t", "");
		
		System.out.println(string);
		return string;
	}
	
	public String cleanTrailerTitle(String string){
		string=string.substring(29);	//removes http//:www.traileraddict.com/
		System.out.println(string);
		for(int i=0;i<string.length();i++){
			if(string.charAt(i)=='/'){
				string=string.substring(0, i);
			}
		}
		System.out.println(string);
		
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
