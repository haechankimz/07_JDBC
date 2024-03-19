package edu.kh.music.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.music.model.dto.Music;

public interface MusicDAO {

	int addMusic(Connection conn, String musicName, String artist) throws SQLException;

	List<Music> selectAll(Connection conn) throws SQLException;

	int deleteMusic(Connection conn, int musicNo) throws SQLException;

	List<Music> searchMusic(Connection conn, String artist) throws SQLException;

}
