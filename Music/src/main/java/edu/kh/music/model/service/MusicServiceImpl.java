package edu.kh.music.model.service;

import static edu.kh.music.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.music.model.dao.MusicDAO;
import edu.kh.music.model.dao.MusicDAOImpl;
import edu.kh.music.model.dto.Music;

public class MusicServiceImpl implements MusicService{
	
	private MusicDAO dao = null;
	
	public MusicServiceImpl() {
		dao = new MusicDAOImpl();
	}

	@Override
	public int addMusic(String musicName, String artist) throws SQLException {
		
		Connection conn = getConnection();
		
		int result = dao.addMusic(conn, musicName, artist);
		
		if (result > 0) commit(conn);
		else		    rollback(conn);
		
		close(conn);
		
		
		return result;
	}
	
	
	
	@Override
	public Map<String, Object> selectAll() throws SQLException {
		
		Connection conn = getConnection();
		
		List<Music> musicList = dao.selectAll(conn);
		
		close(conn);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("musicList", musicList);
		
		
		return map;
	}
	
	@Override
	public int deleteMusic(int musicNo) throws SQLException {

		Connection conn = getConnection();
		
		int result = dao.deleteMusic(conn, musicNo);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		close(conn);
		
		
		
		return 0;
	}
	
	
	@Override
	public List<Music> searchArtist(String artist) throws SQLException {
	
		Connection conn = getConnection();
		
		List<Music> musicList = dao.searchMusic(conn, artist);
		
		close(conn);
		
		return musicList;
	}

	
	
}
