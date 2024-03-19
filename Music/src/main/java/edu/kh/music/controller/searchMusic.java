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
		String artist = req.getParameter("artist");

		String message = null;
		try {
			
			MusicService service = new MusicServiceImpl();
			
			
			List<Music> musicList = service.searchArtist(artist);
			
			if(musicList.isEmpty()) {
				message = "조회된 내용이 없습니다";
				req.getSession().setAttribute("message", message);
				resp.sendRedirect("/");
			}else {
				
				String path = "/WEB-INF/views/search.jsp";
				
				req.setAttribute("musicList", musicList);
				req.getRequestDispatcher(path).forward(req, resp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	
	}
	

}
