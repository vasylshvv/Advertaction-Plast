package plast.org.ua.upu.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.CostitemDao;
import plast.org.ua.upu.dao.DoctorDao;
import plast.org.ua.upu.dao.EstimateDao;
import plast.org.ua.upu.dao.EventsDao;
import plast.org.ua.upu.dao.KVDao;
import plast.org.ua.upu.dao.KomendantDao;
import plast.org.ua.upu.dao.KurinDao;
import plast.org.ua.upu.dao.OrganizerDao;
import plast.org.ua.upu.dao.StanytsyaDao;
import plast.org.ua.upu.dao.StupinDao;
import plast.org.ua.upu.dao.TypeActionDao;
import plast.org.ua.upu.dao.TypeDoctorDao;
import plast.org.ua.upu.dao.VyshkilDao;
import plast.org.ua.upu.idao.ICostitemDao;
import plast.org.ua.upu.idao.IDoctorDao;
import plast.org.ua.upu.idao.IEstimateDao;
import plast.org.ua.upu.idao.IEventsDao;
import plast.org.ua.upu.idao.IKVDao;
import plast.org.ua.upu.idao.IKomendantDao;
import plast.org.ua.upu.idao.IKurinDao;
import plast.org.ua.upu.idao.IOrganizerDao;
import plast.org.ua.upu.idao.IStanystyaDao;
import plast.org.ua.upu.idao.IStupinDao;
import plast.org.ua.upu.idao.ITypeActionDao;
import plast.org.ua.upu.idao.ITypeDoctorDao;
import plast.org.ua.upu.idao.IVyshkilDao;
import plast.org.ua.upu.pojo.EstimateEditPojo;
import plast.org.ua.upu.pojo.EstimateViewPojo;
import plast.org.ua.upu.pojo.EventEditPojo;
import plast.org.ua.upu.pojo.EventViewPojo;
import plast.org.ua.upu.table.Costitem;
import plast.org.ua.upu.table.Doctor;
import plast.org.ua.upu.table.KV;
import plast.org.ua.upu.table.Komendant;
import plast.org.ua.upu.table.Kurin;
import plast.org.ua.upu.table.Organizer;
import plast.org.ua.upu.table.Stanytsya;
import plast.org.ua.upu.table.Stupin;
import plast.org.ua.upu.table.TypeAction;
import plast.org.ua.upu.table.TypeDoctor;
import plast.org.ua.upu.table.Vyshkil;


public class ViewAdventController implements Controller {
	private List<EventViewPojo> listEventView;
	private List<EstimateViewPojo> listEstimPojo;
	private IEventsDao eventDao = EventsDao.getInstance();
	private IEstimateDao estimateDao = EstimateDao.getInstance();



@Override
public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	ModelAndView modelAndView = new ModelAndView("/jsp/viewadv.jsp");
	Long idevent = Long.parseLong(request.getParameter("idview"));
	listEventView = eventDao.findViewEvent(idevent);
	listEstimPojo = estimateDao.findAllEstEventView(idevent);
	
	modelAndView.addObject("listeventview", listEventView);
	modelAndView.addObject("listestimpojo", listEstimPojo);
	return modelAndView;
	}	
}
