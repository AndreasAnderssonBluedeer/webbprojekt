package se.idioti.unirest.java.beans;

public class Song {
	private String title;
	private String description;
	private String artist;
	private String composer;
	private String conductor;
	private String lyricist;
	private String producer;
	private String albumname;
	private String recordlabel;
	private String starttimeutc;
	private String stoptimeutc;
	
	public Song() {
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public String getConductor() {
		return conductor;
	}

	public void setConductor(String conductor) {
		this.conductor = conductor;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getLyricist() {
		return lyricist;
	}

	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}

	public String getAlbumname() {
		return albumname;
	}

	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}

	public String getRecordlabel() {
		return recordlabel;
	}

	public void setRecordlabel(String recordlabel) {
		this.recordlabel = recordlabel;
	}

	public String getStarttimeutc() {
		return starttimeutc;
	}

	public void setStarttimeutc(String starttimeutc) {
		this.starttimeutc = starttimeutc;
	}

	public String getStoptimeutc() {
		return stoptimeutc;
	}

	public void setStoptimeutc(String stoptimeutc) {
		this.stoptimeutc = stoptimeutc;
	}
}
