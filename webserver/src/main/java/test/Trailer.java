package test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Handles TrailerAddicts XML response for a specific trailer. Converts to Java Object.
 * Is used to Set Trailer_id and Create a Trailer-Link.
 * @author Andreas Andersson & David Isberg -Systemutveckling HT-15
 *
 */
@XmlRootElement(name="trailer")
public class Trailer {

	private String link;
	private String trailer_id;
	private String trailer_link=null;
	
	

	/**
	 * Sets Trailer_ID from Parameter and Creates Link.
	 * @param trailer_id -The Trailers ID.
	 */
	@XmlElement
	public void setTrailer_id(String trailer_id){
		this.trailer_id=trailer_id;
		this.trailer_link="http://v.traileraddict.com/"+trailer_id;
	}

	
	/**
	 * Returns Trailer ID.
	 * @return String
	 */
	public String getTrailerID(){
		return this.trailer_id;
	}
	
	public void setLink(String link){
		this.link=link;
	}
	
	public String getLink(){
		return link;
	}
	
	/**
	 * String to Print Trailer-ID
	 * @return String
	 */
	public String toString(){

		return " trailer_id:"+trailer_id;
				
	
	} 


}
