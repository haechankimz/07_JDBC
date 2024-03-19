package edu.kh.music.controller;

import java.io.IOException;

import edu.kh.music.model.service.MusicService;
import edu.kh.music.model.service.MusicServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/music/add")
public class MusicAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			MusicService service = new MusicServiceImpl();
			
			String musicName = req.getParameter("musicName");
			String artist = req.getParameter("artist");
			
			int result = service.addMusic(musicName, artist);
			
			String message = null;
			
			if(result > 0) message = "음악 추가 성공!";
			else   		   message = "음악 추가 실패";
			
			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			
			resp.sendRedirect("/");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	
}
