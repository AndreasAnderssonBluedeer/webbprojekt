package webserver;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="trailer")
public class Trailer {


	private String trailer_id;
	private String trailer_link=null;
	
	

	@XmlElement
	public void setTrailer_id(String trailer_id){
		this.trailer_id=trailer_id;
		this.trailer_link="http://v.traileraddict.com/"+trailer_id;
	}

	
	
	public String getTrailerID(){
		return this.trailer_id;
	}
	
	public String toString(){

		return " trailer_id:"+trailer_id;
				
	
	} 


}
