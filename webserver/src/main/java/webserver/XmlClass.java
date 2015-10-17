package webserver;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * XMLClass serves the purpose of converting TrailerAddicts Trailer response from
 * Xml to Java Object. Uses Trailer. Set/Get Trailer.
 * @author Andreas Andersson & David Isberg -Systemutveckling HT-15
 *
 */

@XmlRootElement(name="trailers")
public class XmlClass {
	
	private Trailer trailer;

	/**
	 * Sets Trailer from parameter.
	 * @param trailer -trailer to be set
	 */
	@XmlElement
	public void setTrailer(Trailer trailer) {
		this.trailer = trailer;
	}
	
	/**
	 * returns Trailer.
	 * @return Trailer
	 */
	public Trailer getTrailer(){
		return this.trailer;
	}

}
