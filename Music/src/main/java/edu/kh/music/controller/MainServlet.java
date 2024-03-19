package edu.kh.music.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.kh.music.model.dto.Music;
import edu.kh.music.model.service.MusicService;
import edu.kh.music.model.service.MusicServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("")
public class MainServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			MusicService service = new MusicServiceImpl();
			
			Map<String, Object> map = service.selectAll();
			
			List<Music> musicList = (List<Music>)map.get("musicList");
			
			req.setAttribute("musicList", musicList);
			
			String path = "/WEB-INF/views/main.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}

}
