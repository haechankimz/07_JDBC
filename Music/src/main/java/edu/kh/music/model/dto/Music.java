package edu.kh.music.model.dto;

public class Music {
	
	private int musicNo;
	private String musicName;
	private String artist;
	private String comDate;
	
	public Music() {	}

	public Music(int musicNo, String musicName, String artist, String comDate) {
		super();
		this.musicNo = musicNo;
		this.musicName = musicName;
		this.artist = artist;
		this.comDate = comDate;
	}

	public int getMusicNo() {
		return musicNo;
	}

	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getComDate() {
		return comDate;
	}

	public void setComDate(String comDate) {
		this.comDate = comDate;
	}

	@Override
	public String toString() {
		return "Music [musicNo=" + musicNo + ", musicName=" + musicName + ", artist=" + artist + ", comDate=" + comDate
				+ "]";
	}
	
	

}
