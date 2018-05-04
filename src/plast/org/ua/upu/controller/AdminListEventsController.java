package plast.org.ua.upu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.EventsDao;
import plast.org.ua.upu.dao.StatusAdvertDao;
import plast.org.ua.upu.idao.IEventsDao;
import plast.org.ua.upu.idao.IStatusAdvertDao;
import plast.org.ua.upu.pojo.ListEventPojo;
import plast.org.ua.upu.table.Statusadvert;

public class AdminListEventsController implements Controller{
	private IEventsDao eventsdao = EventsDao.getInstance();
	private IStatusAdvertDao statusAdvertDao = StatusAdvertDao.getInstance();
	private List<ListEventPojo> listEvent;
	private List<Statusadvert> listStatusAdvert;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/jsp/adminlistevents.jsp");
		listEvent = eventsdao.findEvent();
		listStatusAdvert = statusAdvertDao.findAll();
		modelAndView.addObject("listevent",listEvent);
		modelAndView.addObject("liststatusadv",listStatusAdvert);
		return modelAndView;
	}
}