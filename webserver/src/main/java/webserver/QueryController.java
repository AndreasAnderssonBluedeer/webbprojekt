package webserver;
/**
 * Hanterar Querys. Ser till att anropen utför i rätt ordning för att konverteras,hämtas,sorteras och returneras.
 * @author Andreas
 *
 */
public class QueryController {

	private APIConnector apiC=new APIConnector();
	private ResultSorter rs=new ResultSorter(this);
	private QueryConverter qc=new QueryConverter();
	
	
	
	    //Short plot,Poster, Year,Genre,Rating,Title
	public String search(String query){	
		String [] array=qc.search(query);	//Sortera ut query egenskaperna.
		/*array[0]=title;
		array[1]=genre;
		array[2]=year;
		array[3]=rating;
		array[4]=apiSearch (Title&year färdigt för APIConnector.);*/
		
		
		String apiResponse=apiC.getSearch(array[4]);
		
		return rs.filterSearch(apiResponse, array[1], array[3]);	//Sortera efter genre och rating.
	}
	public String sort(String query){
			
			
			return null;
		}
	//Hämta full info för en film när man har full titel. 
	public String info(String query){
		System.out.println(query);
		
		return apiC.getInfo(qc.info(query));
	}
	
	public String trailer(String query){
		apiC.getTrailer(query);
		
		return null;
	}
	    
	public static void main(String [] args){
		QueryController cont=new QueryController();
	//	cont.search("s=Harry+Potter&g=Drama&y=&r=8");
	//	cont.search("s=Harry+Potter&g=Family&y=&r=");
	//	cont.search("s=Harry+Potter&g=&y=&r=8");
		cont.trailer("Hej");	//http://v.traileraddict.com/query (query=trailerID
	}
	    
	    
	    
	
}
