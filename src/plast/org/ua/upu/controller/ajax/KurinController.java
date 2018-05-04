package plast.org.ua.upu.controller.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.KurinDao;
import plast.org.ua.upu.idao.IKurinDao;
import plast.org.ua.upu.table.Kurin;

public class KurinController implements Controller{
	private Kurin kurin;
	private IKurinDao kurindao = KurinDao.getInstance();
	private List<Kurin> listkurin;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = null;
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String namekurin = request.getParameter("namekurin");
        System.out.println("namekurin = "+namekurin);
        kurin = new Kurin();
        kurin.setNamekurin(namekurin);
        kurindao.addKurin(kurin);
        listkurin = kurindao.findAll();
        String xml01 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"+
        		"<AllKurin>\n";
        		String xml02 = "<kurin>\n"+ 
        					   "<id>"+0+"</id>\n"+
        				       "<namekurin>"+"¬ибер≥ть кур≥нь"+"</namekurin>\n"+
        				       "</kurin>\n";
        		String xml03 = "";
        for (Kurin kurin : listkurin) {
        	xml03 = xml03 + 
					"<kurin>\n"+
					"<id>" + kurin.getId() + "</id>\n"+
					"<namekurin>" + kurin.getNamekurin() + "</namekurin>\n"+
					"</kurin>\n";
		}
        String xml = xml01 + xml02 + xml03 + "</AllKurin>";
		response.getWriter().println(xml);
		response.getWriter().close();
		return modelAndView;
	}
}
