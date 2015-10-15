package webserver;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="trailer")
public class Trailer {

	private String title;
	private String trailer_id;
	
	@XmlElement
	public void setTitle(String title){
		this.title=title;
	}

	@XmlElement
	public void setTrailer_id(String trailer_id){
		this.trailer_id=trailer_id;
	}

	public String getTitle(){
		return this.title;
	}
	
	public String getTrailerID(){
		return this.trailer_id;
	}
	
	public String toString(){

		return "Title:"+title+" trailer_id:"+trailer_id;
				
	
	} 


}
