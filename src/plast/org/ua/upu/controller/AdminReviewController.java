package plast.org.ua.upu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.EventsDao;
import plast.org.ua.upu.dao.KomendantDao;
import plast.org.ua.upu.dao.RecommendationDao;
import plast.org.ua.upu.dao.StatusAdvertDao;
import plast.org.ua.upu.idao.IEventsDao;
import plast.org.ua.upu.idao.IKomendantDao;
import plast.org.ua.upu.idao.IRecommendationDao;
import plast.org.ua.upu.idao.IStatusAdvertDao;
import plast.org.ua.upu.pojo.EventViewPojo;
import plast.org.ua.upu.sendemail.SendEmailAdvert;
import plast.org.ua.upu.table.Events;
import plast.org.ua.upu.table.Komendant;
import plast.org.ua.upu.table.Recommendation;
import plast.org.ua.upu.table.Statusadvert;

public class AdminReviewController implements Controller {
	private IEventsDao eventDao = EventsDao.getInstance();
	private IStatusAdvertDao statusAdvertDao = StatusAdvertDao.getInstance();
	private IRecommendationDao recommendationDao = RecommendationDao.getInstance();
	private IKomendantDao komendantDao = KomendantDao.getInstance();
	private List<EventViewPojo> listEventView;
	private List<Statusadvert> listStatusAdvert;
	private List<Events> listEvents;
	private List<Komendant> listKomendant;
	
	private Events events;
	private Statusadvert statusadv;
	private Recommendation recommendation;
	private SendEmailAdvert sendEmailAdvert;
	private String advertname;
	private Long idkomendant;
	private String emailKomendant;
	private String statusEvent;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String button = request.getParameter("savestatus");
		if (button == null) {
			ModelAndView modelAndView = new ModelAndView("/jsp/review.jsp");

			Long idevent = Long.parseLong(request.getParameter("idreview"));
			listEventView = eventDao.findViewEvent(idevent);
			listStatusAdvert = statusAdvertDao.findAll();
			modelAndView.addObject("listEventView", listEventView);
			modelAndView.addObject("listStatusAdvert", listStatusAdvert);
			return modelAndView;
		} else {

			Long idevent = Long.parseLong(request.getParameter("idevent"));
			Long idstatus = Long.parseLong(request.getParameter("selstatus"));
			String recommend = request.getParameter("recommend");
			
			listStatusAdvert = statusAdvertDao.findAll(idstatus);
			for (Statusadvert status : listStatusAdvert) {
				statusEvent = status.getDescription();
				statusadv = new Statusadvert(status.getId(), status.getDescription());
			}
			
			listEvents = eventDao.findAll(idevent);			
			for (Events event : listEvents) {
				advertname = event.getAdvertname();
				idkomendant = event.getKomendant().getId();
				events = new Events(event.getId(), event.getAdvertname(), event.getAdvertnameeng(), 
						event.getDatefromadvert(), event.getDatetoadvert(), event.getTypeaction(), event.getVenue(), event.getKomendant(), 
						event.getOrganizer(), event.getDoctor(), event.getProgram(), event.getPurpose(), event.getNumbparticip(), 
						event.getAgeparticipfrom(), event.getAgeparticipto(), event.getTopicality(), event.getExpectresult(), 
						event.getSumparticip(), event.getOtherinfo(), event.getRegistrdate(), statusadv, event.getStatusreport(), 
						event.getHashid(), event.getLevelaction(), event.getGoverfinan());
			}
			recommendation = new Recommendation();
			recommendation.setRegistrDate(new Date());
			recommendation.setDescription(recommend);
			recommendation.setEvents(events);
			recommendationDao.saveRecommend(recommendation);
			
			listKomendant = komendantDao.findAll(idkomendant);
			for (Komendant km : listKomendant) {
				emailKomendant = km.getEmail();
			}
			
			String info = "<h1>Інформація</h1>";
			String nameapp = "<p>Зголошену акцію: "+"<b><font size='4'>"+advertname+"</font></b>"+"</p>";
			String lote = "<p>Статус зголошення "+"<b><font size='4'>"+statusEvent+"</font></b>"+"</p>";
			String desc = "<p>Інформація: "+"<b><font size='4'>"+recommend+"</font></b>"+"</p>";
			String text = info + nameapp + lote + desc; 
			
			sendEmailAdvert = new SendEmailAdvert("techniclsuport@gmail.com", "@ctiv@tion");
			sendEmailAdvert.send("Рекомендації "+advertname, text, "vasylshvv@gmail.com", emailKomendant);
			
			return new ModelAndView("redirect:/adminlistevents.html");
		}

	}
}
