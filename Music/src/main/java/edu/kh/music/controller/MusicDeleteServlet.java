package edu.kh.music.controller;

import java.io.IOException;

import edu.kh.music.model.service.MusicService;
import edu.kh.music.model.service.MusicServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/music/delete")
public class MusicDeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			MusicService service = new MusicServiceImpl();
			
			int musicNo = Integer.parseInt(req.getParameter("musicNo"));
			
			int result = service.deleteMusic(musicNo);
			
			String path = null;
			String message = null;
			
			if(result > 0 ) {
				message = "삭제되었습니다.";
				path = "/";
			}else {
				message = "삭제 되었습니다.";
				path = "/";
			}
			
			req.getSession().setAttribute("message", message);
			
			resp.sendRedirect(path);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	
	
	
	}

}
