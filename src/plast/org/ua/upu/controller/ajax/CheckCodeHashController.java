package plast.org.ua.upu.controller.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.EventsDao;
import plast.org.ua.upu.idao.IEventsDao;
import plast.org.ua.upu.table.Events;

public class CheckCodeHashController implements Controller{
	private IEventsDao eventDao = EventsDao.getInstance();
	private List<Events> listEvent;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		
		ModelAndView modelAndView = null;
		String idevent = request.getParameter("idevent");
		System.out.println("idevent = "+idevent);
		String hashcode = request.getParameter("hashcode");
		System.out.println("hashcode = "+hashcode);
		
		listEvent = eventDao.findAll(Long.parseLong(idevent));
		String checkcode = "";
		for (Events events : listEvent) {
			checkcode = events.getHashid();
		}
		if(checkcode.equals(hashcode)){
			response.getWriter().println("1");
			response.getWriter().close();
		} else {
			response.getWriter().println("0");
			response.getWriter().close();
		}
		return modelAndView;
	}
}
