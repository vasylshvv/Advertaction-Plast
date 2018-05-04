package plast.org.ua.upu.controller.ajax;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.RecommendationDao;
import plast.org.ua.upu.idao.IRecommendationDao;
import plast.org.ua.upu.table.Recommendation;

public class InfoRecommendatController implements Controller{
	private IRecommendationDao recomendatDao = RecommendationDao.getInstance();
	private List<Recommendation> listRecomendt;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = null;
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        Long idevent = Long.parseLong(request.getParameter("idrec"));
        listRecomendt = recomendatDao.findAll(idevent);
        String xml01 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"+
        		"<AllInfoRecom>\n";
        String xml02="";
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        for (Recommendation recommendation : listRecomendt) {
        	xml02 = xml02 + "<inforecommend>\n"+ 
					"<id>"+recommendation.getId()+"</id>\n"+
					"<dateregs>"+recommendation.getRegistrDate()+"</dateregs>\n"+
					"<descript>"+recommendation.getDescription()+"</descript>\n"+
			"</inforecommend>\n";
		}
        String xml = xml01 + xml02 + "</AllInfoRecom>";
		response.getWriter().println(xml);
		response.getWriter().close();
		return modelAndView;
	}
}
