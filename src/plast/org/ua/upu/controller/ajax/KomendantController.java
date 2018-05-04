package plast.org.ua.upu.controller.ajax;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.KomendantDao;
import plast.org.ua.upu.idao.IKomendantDao;
import plast.org.ua.upu.table.KV;
import plast.org.ua.upu.table.Komendant;
import plast.org.ua.upu.table.Kurin;
import plast.org.ua.upu.table.Stanytsya;
import plast.org.ua.upu.table.Stupin;
import plast.org.ua.upu.table.Vyshkil;

public class KomendantController implements Controller{
	private IKomendantDao komendao = KomendantDao.getInstance();
	private List<Komendant> listkomendant;
	private Komendant komendant;
	private java.util.Date birthdate;
	private Date datebirth;
	private Stupin stupin;
	private Stanytsya stanytsya;
	private Kurin kurin;
	private Vyshkil vyshkil;
	private KV kv;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = null;
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		String firstname = request.getParameter("firstname");
        System.out.println("firstname = "+firstname);
        String lastname = request.getParameter("lastname");
        System.out.println("lastname = "+lastname);
        String birthday = request.getParameter("birthday");
        System.out.println("birthday = "+birthday);
        String idselstup = request.getParameter("idselstup");
        System.out.println("idselstup = "+idselstup);
        String namestup = request.getParameter("namestup");
        System.out.println("namestup = "+namestup);
        String longnamestup = request.getParameter("longnamestup");
        System.out.println("longnamestup = "+longnamestup);
	    String idselstan = request.getParameter("idselstan");
	    System.out.println("idselstan="+idselstan);
	    String nameselstan = request.getParameter("nameselstan");
	    System.out.println("nameselstan="+nameselstan);
	    String idselkurin = request.getParameter("idselkurin");
	    System.out.println("idselkurin="+idselkurin);
	    String namekurin = request.getParameter("namekurin");
	    System.out.println("namekurin="+namekurin);
	    String idselvyshkil = request.getParameter("idselvyshkil");
	    System.out.println("idselvyshkil="+idselvyshkil);
	    String namevyshkil = request.getParameter("namevyshkil");
	    System.out.println("namevyshkil="+namevyshkil);
	    String idstupkv = request.getParameter("idstupkv");
	    System.out.println("idstupkv="+idstupkv);
	    String namekv = request.getParameter("namekv");
	    System.out.println("namekv="+namekv);
	    String telnumb = request.getParameter("telnumb");
	    System.out.println("telnumb="+telnumb);
	    String email = request.getParameter("email");
	    System.out.println("email="+email);
		
	    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	    birthdate = dateFormat.parse(birthday);
	    datebirth = new Date(birthdate.getTime());
	    
	    stupin = new Stupin(Long.parseLong(idselstup), namestup, longnamestup);

	    stanytsya = new Stanytsya(Long.parseLong(idselstan),nameselstan);
	    if(Integer.parseInt(idselkurin) != 0){
	    	kurin = new Kurin(Long.parseLong(idselkurin), namekurin);
	    }
	    
	    if(Integer.parseInt(idselvyshkil)!=0){
	    	vyshkil = new Vyshkil(Long.parseLong(idselvyshkil), namevyshkil);
	    }
	    if(Integer.parseInt(idstupkv)!=0){
	    	kv = new KV(Long.parseLong(idstupkv), namekv, null);
	    }
	    komendant = new Komendant();
	    komendant.setFirstname(firstname);
	    komendant.setLastname(lastname);
	    komendant.setBirthday(datebirth);
	    komendant.setStupin(stupin);
	    komendant.setStanytsya(stanytsya);
    	komendant.setKurin(kurin);
    	komendant.setVyshkil(vyshkil);
    	komendant.setKv(kv);
	    komendant.setCellnumber(telnumb);
	    komendant.setEmail(email);
	    komendao.addKomendant(komendant);
	    
	    listkomendant = komendao.findAll();
	    
	    String xml01 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"+
        		"<AllKomendant>\n";
        		String xml02 = "<komendant>\n"+ 
        					   "<id>"+0+"</id>\n"+
        				       "<namekomendant>"+"Виберіть з списку"+"</namekomendant>\n"+
        				       "</komendant>\n";
        		String xml03 = "";
        		
        	for (Komendant komendant : listkomendant) {
        		xml03 = xml03 + 
						"<komendant>\n"+
						"<id>" + komendant.getId() + "</id>\n"+
						"<namekomendant>" + komendant.getLastname() + " "+ komendant.getFirstname() + "</namekomendant>\n"+
						"</komendant>\n";
			}
        	String xml = xml01 + xml02 + xml03 + "</AllKomendant>";
    		response.getWriter().println(xml);
    		response.getWriter().close();
		return modelAndView;
	}
}
