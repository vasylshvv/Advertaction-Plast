package plast.org.ua.upu.controller.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.LeaderShipDao;
import plast.org.ua.upu.idao.ILeaderShipDao;
import plast.org.ua.upu.table.LeaderShip;

public class LeaderShipController implements Controller{
	private LeaderShip leaderShip;
	private ILeaderShipDao leaderShipDao = LeaderShipDao.getInstance();
	private List<LeaderShip> listLeaderShip;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = null;
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String nameprovid = request.getParameter("nameprovid");
        System.out.println("nameprovid = "+nameprovid);
        leaderShip = new LeaderShip();
        leaderShip.setNamelider(nameprovid);
        leaderShipDao.addNameLeader(leaderShip);
        listLeaderShip = leaderShipDao.findAllLeader();
        String xml01 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"+
        		"<AllLeaderName>\n";
        		String xml02 = "<leadername>\n"+ 
        					   "<id>"+0+"</id>\n"+
        				       "<namelider>"+"¬ибер≥ть пров≥д"+"</namelider>\n"+
        				       "</leadername>\n";
        		String xml03 = "";
        		for (LeaderShip leaderShip : listLeaderShip) {
        			xml03 = xml03 + 
        					"<leadername>\n"+
        					"<id>" + leaderShip.getId() + "</id>\n"+
        					"<namelider>" + leaderShip.getNamelider() + "</namelider>\n"+
        					"</leadername>\n";
				}
        		String xml = xml01 + xml02 + xml03 + "</AllLeaderName>";
        		response.getWriter().println(xml);
        		response.getWriter().close();
		return modelAndView;
	}
}
