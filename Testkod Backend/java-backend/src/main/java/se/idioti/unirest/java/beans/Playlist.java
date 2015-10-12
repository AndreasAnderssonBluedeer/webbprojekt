package se.idioti.unirest.java.beans;

import java.util.Map;
import java.util.TreeMap;

import com.google.gson.annotations.SerializedName;

public class Playlist {
	private Channel channel;
	private Song song;
	@SerializedName("previoussong")
	private Song previousSong;
	private Song nextsong;
	
	public Playlist() {
	}
	
	public Channel getChannel() {
		return channel;
	}
	
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	public Song getSong() {
		return song;
	}
	
	public void setSong(Song song) {
		this.song = song;
	}
	
	public Song getNextSong() {
		return nextsong;
	}
	
	public void setNextSong(Song song) {
		nextsong = song;
	}
	
	public Song getPreviousSong() {
		return previousSong;
	}
	
	public void setPreviousSong(Song song) {
		previousSong = song;
	}
}
