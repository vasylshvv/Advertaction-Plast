package plast.org.ua.upu.controller.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.CostitemDao;
import plast.org.ua.upu.idao.ICostitemDao;
import plast.org.ua.upu.table.Costitem;

public class CostitemController implements Controller{
	private ICostitemDao costdao = CostitemDao.getInstance();
	private List<Costitem> listcostitem;
	private Costitem costitem;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = null;
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String namecostitem = request.getParameter("namecostitem");
        System.out.println("namecostitem = "+namecostitem);
        
        costitem = new Costitem();
        costitem.setNamecostitem(namecostitem);
        costdao.addCostitem(costitem);
        listcostitem = costdao.findAll();
        String xml01 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"+
        		"<AllCostItem>\n";
        		String xml02 = "<costitem>\n"+ 
        					   "<id>"+0+"</id>\n"+
        				       "<namecostitem>"+"Виберіть статтю витрат"+"</namecostitem>\n"+
        				       "</costitem>\n";
        		String xml03 = "";
        for (Costitem costitem : listcostitem) {
        	xml03 = xml03 + 
					"<costitem>\n"+
					"<id>" + costitem.getId() + "</id>\n"+
					"<namecostitem>" + costitem.getNamecostitem() + "</namecostitem>\n"+
					"</costitem>\n";
		}
        String xml = xml01 + xml02 + xml03 + "</AllCostItem>";
		response.getWriter().println(xml);
		response.getWriter().close();
		return modelAndView;
	}
}
