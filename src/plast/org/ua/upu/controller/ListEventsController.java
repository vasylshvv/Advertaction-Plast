package plast.org.ua.upu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.EventsDao;
import plast.org.ua.upu.dao.LevelActionDao;
import plast.org.ua.upu.dao.TypeActionDao;
import plast.org.ua.upu.idao.IEventsDao;
import plast.org.ua.upu.idao.ILevelActionDao;
import plast.org.ua.upu.idao.ITypeActionDao;
import plast.org.ua.upu.pojo.ListEventPojo;
import plast.org.ua.upu.table.Events;
import plast.org.ua.upu.table.LevelAction;
import plast.org.ua.upu.table.TypeAction;

public class ListEventsController implements Controller{
	private IEventsDao eventsdao = EventsDao.getInstance();
	private ITypeActionDao actionDao = TypeActionDao.getInstance();
	private ILevelActionDao levelActionDao = LevelActionDao.getInstance();
	private List<ListEventPojo> listEvent;
	private List<TypeAction> listTypeAction;
	private List<LevelAction> listLevelAction;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/jsp/listevents.jsp");
		listEvent = eventsdao.findEvent();
//		for (ListEventPojo l : listEvent) {
//			System.out.println(l.getAdvertname()+" \t"+l.getNamelevelaction()+"\t"+l.getNametypeaction());
//		}
		listTypeAction = actionDao.findAll();
		listLevelAction = levelActionDao.findAllLevelAction();
		modelAndView.addObject("listevent",listEvent);
		modelAndView.addObject("listtype", listTypeAction);
		modelAndView.addObject("listlevel", listLevelAction);
		return modelAndView;
	}
}
