package webserver;


/**
 * Convertera Query till sina sökfält.
 * @author Andreas
 *
 */
public class QueryConverter {
	
	private APIConnector apiC=new APIConnector();
	private String badChars[]= {" ","_","^","<",">","{","}","[","]","~"};		//Array med dåliga tecken som ska sorteras bort.

	//Sökning för Titel,Genre,År,Rating ex:Drama, 80-90, 10, Title - välj field namn.search/s=title&g=genre&y=year&r=rating
	//ApiConnector tar endast emot Title och Year.
	//returnera String med Json-formatering.
	public String[] search(String query){
		// search/s=title&g=genre&y=year&r=rating query: s=title&g=genre&y=year&r=rating
		
		String [] array= new String[5];
		String title = null,genre=null,year=null,rating=null,apiSearch=null;
		
		title=getField(query,'g');
		query=query.substring(title.length()+1);		
		genre=getField(query,'y');
		query=query.substring(genre.length()+1);		
		year=getField(query,'r');		
		rating=query.substring(year.length()+1);
		
		//Rensa upp input.
		title=cleanString(title);
		year=cleanString(year);
				
		apiSearch=title+"&"+year;
		
		array[0]=title;
		array[1]=cleanField(genre);
		array[2]=year;
		array[3]=cleanField(rating);
		array[4]=apiSearch;
		
		
		
		return array;	//Senare svar från JSON metod.
	}
	
	//Rensa ut  t.ex "r=" från r=rating.
	public String cleanField(String field){

		return field=field.substring(2, field.length());
	}
	
	public String cleanString(String string){
		for(int i=0;i<badChars.length;i++){
			if(string.contains(badChars[i])){
				string=string.replace(badChars[i],"+");	
			}
			}
		return string;
	}
	public String getField(String query,char field){
		String answer=null;
		
		for(int i=0;i<query.length();i++){
			if(query.charAt(i)=='&' && query.charAt(i+1)==field && query.charAt(i+2)=='='){
				answer=query.substring(0, i);	//Vi har hittat vårt title Field&Value.
				i=query.length();	//Bryt loopen.
			}
		}		
		return answer;
	}
	
	public String getValue(String field){		
		field=field.substring(2,field.length());		
		return field;
	}
	
	//Hämta all info för specifik film/titel (+trailer?!)
	//returnera String med Json-formatering.
	public String info(String query){		
		query=cleanString(query);
		System.out.println(query);
		return query;	//Senare svar från JSON metod.
	}
	//Sortera efter Genre,År,Titel osv.
	//returnera String med Json-formatering.
	public String sortBy(String query){
		
		
		return null;	//Senare svar från JSON metod.
	}
	//Returnera Trailern efter titel
	//returnera String med Json-formatering.
	public String trailer(String query){
		
		
		return null;	//Senare svar från JSON metod.
	}
	public static void main(String[] args){
		QueryConverter qc=new QueryConverter();
//		qc.info("harry");
//		qc.info("harry p");
//		qc.info("harry^p");
	//	qc.search("s=Harry Potter and~the+Order+of+the+Phoenix&g=Drama&y=2007~~&r=8");
		qc.search("s=Harry+Potter&g=Drama&y=&r=8");	//Om användaren utelämnat alternativ.
		System.out.println("GETFIELD: "+qc.getValue("g=Drama"));
	}
}
