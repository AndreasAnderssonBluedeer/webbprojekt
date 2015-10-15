package webserver;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="trailers")
public class XmlClass {
	
	private Trailer trailer;

	@XmlElement
	public void setTrailer(Trailer trailer) {
		this.trailer = trailer;
	}
	
	public Trailer getTrailer(){
		return this.trailer;
	}

}
