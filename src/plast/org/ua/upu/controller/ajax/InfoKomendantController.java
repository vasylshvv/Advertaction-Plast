package plast.org.ua.upu.controller.ajax;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.KomendantDao;
import plast.org.ua.upu.idao.IKomendantDao;
import plast.org.ua.upu.pojo.InfoKomendantPojo;
import plast.org.ua.upu.table.Komendant;

public class InfoKomendantController implements Controller{
	private IKomendantDao komendantdao = KomendantDao.getInstance();
	private List<InfoKomendantPojo> listkomendant;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = null;
		
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String idkomendant = request.getParameter("idkomendant");
        listkomendant = komendantdao.findInfoKomend(Long.parseLong(idkomendant));
        String xml01 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"+
        		"<AllInfoKomend>\n";
        String xml02="";
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        for (InfoKomendantPojo infoKomendantPojo : listkomendant) {
			xml02 = xml02 + "<infokomend>\n"+ 
							"<id>"+infoKomendantPojo.getId()+"</id>\n"+
							"<firstname>"+infoKomendantPojo.getFirstname()+"</firstname>\n"+
							"<lastname>"+infoKomendantPojo.getLastname()+"</lastname>\n"+
							"<birthday>"+df.format(infoKomendantPojo.getBirthday())+", ("+countyear(new Date(),infoKomendantPojo.getBirthday())+"ð)"+"</birthday>\n"+
							"<stupin>"+infoKomendantPojo.getStupin()+"</stupin>\n"+
							"<stanytsya>"+infoKomendantPojo.getStanytsya()+"</stanytsya>\n"+
							"<kurin>"+infoKomendantPojo.getKurin()+"</kurin>\n"+
							"<vyshkil>"+infoKomendantPojo.getVyshkil()+"</vyshkil>\n"+
							"<kv>"+infoKomendantPojo.getKv()+"</kv>\n"+
							"<cellnumber>"+infoKomendantPojo.getCellnumber()+"</cellnumber>\n"+
							"<email>"+infoKomendantPojo.getEmail()+"</email>\n"+
					"</infokomend>\n";
		}
        String xml = xml01 + xml02 + "</AllInfoKomend>";
		response.getWriter().println(xml);
		response.getWriter().close();
		return modelAndView;
		
	}
	@SuppressWarnings("deprecation")
	public int countyear(Date today, Date birthday){
		int years = today.getYear() - birthday.getYear();
		int monthtoday = today.getMonth();
		int monthbirth = birthday.getMonth();
		if(monthtoday < monthbirth){
			years--;
		} else if(monthtoday == monthbirth && (today.getDate() < birthday.getDate())){
			years--;
		}
		return years;
	}
}
