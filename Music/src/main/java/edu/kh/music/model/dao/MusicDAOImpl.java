package edu.kh.music.model.dao;

import static edu.kh.music.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.music.model.dto.Music;

public class MusicDAOImpl implements MusicDAO{

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public MusicDAOImpl() {

		try {
			
			prop = new Properties();
			String path = 
				MusicDAOImpl.class.getResource("/edu/kh/music/sql/sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(path));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addMusic(Connection conn, String musicName, String artist) throws SQLException {
	
		int result = 0;
		
		try {
			String sql = prop.getProperty("addMusic");
		
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, musicName);
			pstmt.setString(2, artist);
		
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	
	@Override
	public List<Music> selectAll(Connection conn) throws SQLException {

		List<Music> musicList = new ArrayList<Music>();
		
		try {
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int musicNo = rs.getInt("MUSIC_NO");
				String musicName = rs.getString("MUSIC_NAME");
				String artist = rs.getString("ARTIST");
				String comDate = rs.getString("COM_DATE");
				
				Music music = new Music(musicNo, musicName, artist, comDate);
				
				musicList.add(music);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		return musicList;
	}
	
	
	
	
	@Override
	public int deleteMusic(Connection conn, int musicNo) throws SQLException {
	
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteMusic");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, musicNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	@Override
	public List<Music> searchMusic(Connection conn, String artist) throws SQLException {

		List<Music> musicList = new ArrayList<Music>();
		
		
		
		
		
		
		return null;
	}
	
	
	
	
	
	
	
	
}


