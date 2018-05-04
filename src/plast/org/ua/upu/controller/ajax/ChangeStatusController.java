package plast.org.ua.upu.controller.ajax;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.StatusAdvertDao;
import plast.org.ua.upu.idao.IStatusAdvertDao;
import plast.org.ua.upu.table.Statusadvert;

public class ChangeStatusController implements Controller{
	private IStatusAdvertDao statusAdvertDao = StatusAdvertDao.getInstance();
	private List<Statusadvert> listStatusAdvert;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
ModelAndView modelAndView = null;
		
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        listStatusAdvert = statusAdvertDao.findAll();
        String xml01 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"+
        		"<AllChangeStatus>\n";
        String xml02="";
        for (Statusadvert statusadvert : listStatusAdvert) {
        	xml02 = xml02 + "<liststatus>\n"+ 
					"<id>"+statusadvert.getId()+"</id>\n"+
					"<statusdesc>"+statusadvert.getDescription()+"</statusdesc>\n"+
			"</liststatus>\n";
		}
        String xml = xml01 + xml02 + "</AllChangeStatus>";
		response.getWriter().println(xml);
		response.getWriter().close();
		return modelAndView;
	}
}
