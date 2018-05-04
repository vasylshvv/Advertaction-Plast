package plast.org.ua.upu.controller.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.OrganizerDao;
import plast.org.ua.upu.idao.IOrganizerDao;
import plast.org.ua.upu.table.Organizer;

public class OrganizerController implements Controller{
	private IOrganizerDao organdao = OrganizerDao.getInstance();
	private List<Organizer> listorgan;
	private Organizer organizer;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = null;
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		String nameorganizer = request.getParameter("nameorganizer");
		System.out.println("nameorganizer = "+nameorganizer);
		
		organizer = new Organizer();
		organizer.setNameorganizer(nameorganizer);
		organdao.addOrganizer(organizer);
		
		listorgan = organdao.findAll();
		  String xml01 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"+
	        		"<AllOrganizer>\n";
	        		String xml02 = "<organizer>\n"+ 
	        					   "<id>"+0+"</id>\n"+
	        				       "<nameorgan>"+"Виберіть з списку"+"</nameorgan>\n"+
	        				       "</organizer>\n";
	        		String xml03 = "";
	      for (Organizer organizer : listorgan) {
	    	  xml03 = xml03 + 
						"<organizer>\n"+
						"<id>" + organizer.getId() + "</id>\n"+
						"<nameorgan>" + organizer.getNameorganizer() + "</nameorgan>\n"+
						"</organizer>\n";
		}
	      String xml = xml01 + xml02 + xml03 + "</AllOrganizer>";
  		response.getWriter().println(xml);
  		response.getWriter().close();
		return modelAndView;
	}
}
