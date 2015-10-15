package extraFilerVidBehov;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="trailer")
public class Trailer {

	private String title;
	private String pubDate;	
	private String link;
	private String video_title;
	private String trailer_id;
	private String film;
	private String studio;
	private String director;
	private String writer;
	private String cast;
	private String release_date;
	
	@XmlElement
	public void setTitle(String title){
		this.title=title;
	}
	
	@XmlElement
	public void setPubDate(String pubDate){
		this.pubDate=pubDate;
	}
	
	@XmlElement
	public void setLink(String link){
		this.link=link;
	}
	@XmlElement
	public void setVideo_title(String video_title){
		this.video_title=video_title;
	}
	@XmlElement
	public void setTrailer_id(String trailer_id){

		this.trailer_id=trailer_id;
	}

	@XmlElement
	public void setFilm(String film){
		this.film=film;
	}
	@XmlElement
	public void setStudio(String studio){
		this.studio=studio;
	}
	@XmlElement
	public void setDirector(String director){
		this.director=director;
	}
	@XmlElement
	public void setWriter(String writer){
		this.writer=writer;
	}
	@XmlElement
	public void setCast(String cast){
		this.cast=cast;
	}
	@XmlElement
	public void setRelease_date(String release_date){
		this.release_date=release_date;
	}
	
	public String getTitle(){
		return this.title;
	}
	public String getPubDate(){
		return this.pubDate;
	}
	public String getLink(){
		return this.link;
	}
	public String getVideoTitle(){
		return this.video_title;
	}
	public String getTrailerID(){
		return this.trailer_id;
	}
	public String getFilm(){
		return this.film;
	}
	public String getStudio(){
		return this.studio;
	}
	public String getDirector(){
		return this.director;
	}
	public String getWriter(){
		return this.writer;
	}
	public String getCast(){
		return this.cast;
	}
	public String getReleaseDate(){
		return this.release_date;
	}
	public String toString(){

		return "Title:"+title+" PubDate:"+pubDate+" Link:"+link+" video_title:"+video_title+" trailer_id:"+trailer_id+"\n"+
				"film:"+film+" studio:"+studio+" director:"+director+" writer:"+writer+" cast:"+cast+" release_date:"+release_date;
	
	} 


}
