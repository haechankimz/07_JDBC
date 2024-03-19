package edu.kh.music.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.music.model.dto.Music;
import edu.kh.music.model.service.MusicService;
import edu.kh.music.model.service.MusicServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/music/search")
public class searchMusic extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			MusicService service = new MusicServiceImpl();
			
			String artist = req.getParameter("artist");
			
			List<Music> musicList = service.searchArtist(artist);
			
			req.setAttribute("musicList", musicList);
			
			String path = "/WEB-INF/views/search.jsp";
			
			
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	
	}
	

}
