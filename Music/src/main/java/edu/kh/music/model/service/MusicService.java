package edu.kh.music.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import edu.kh.music.model.dto.Music;

public interface MusicService {

	int addMusic(String musicName, String artist) throws SQLException;

	Map<String, Object> selectAll() throws SQLException;

	int deleteMusic(int musicNo) throws SQLException;

	List<Music> searchArtist(String artist) throws SQLException;

}
