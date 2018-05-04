package plast.org.ua.upu.controller.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.TypeActionDao;
import plast.org.ua.upu.idao.ITypeActionDao;
import plast.org.ua.upu.table.TypeAction;

public class TypeActionController implements Controller{
	private TypeAction typeaction;
	private ITypeActionDao typeactionDao = TypeActionDao.getInstance();
	private List<TypeAction> listtypeaction;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = null;
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		String nametypeact = request.getParameter("nametype");
		System.out.println("nametypeact = "+nametypeact);
		
		typeaction = new TypeAction();
		typeaction.setNametypeaction(nametypeact);
		typeactionDao.addTypeAction(typeaction);
		listtypeaction = typeactionDao.findAll();
		
		String xml01 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"+
        		"<AllTypeAction>\n";
        		String xml02 = "<typeaction>\n"+ 
        					   "<id>"+0+"</id>\n"+
        				       "<nametype>"+"Вибрати вид заходу"+"</nametype>\n"+
        				       "</typeaction>\n";
        		String xml03 = "";
		for (TypeAction typeAction : listtypeaction) {
			xml03 = xml03 + 
					"<typeaction>\n"+
					"<id>" + typeAction.getId() + "</id>\n"+
					"<nametype>" + typeAction.getNametypeaction() + "</nametype>\n"+
					"</typeaction>\n";
		}
		String xml = xml01 + xml02 + xml03 + "</AllTypeAction>";
		response.getWriter().println(xml);
		response.getWriter().close();
		return modelAndView;
	}
}
