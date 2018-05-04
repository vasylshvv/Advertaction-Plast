package plast.org.ua.upu.controller.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.DoctorDao;
import plast.org.ua.upu.idao.IDoctorDao;
import plast.org.ua.upu.table.Doctor;
import plast.org.ua.upu.table.TypeDoctor;

public class DoctorContoller implements Controller{
	private IDoctorDao docdao = DoctorDao.getInstance();
	private List<Doctor> listdoc;
	private Doctor doctor;
	private TypeDoctor typedoc;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = null;
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String lastnamedoc = request.getParameter("lastnamedoc");
        System.out.println("lastnamedoc="+lastnamedoc);
        String firstnamedoc = request.getParameter("firstnamedoc");
		System.out.println("firstnamedoc="+firstnamedoc);
		String idseltypedoc = request.getParameter("idseltypedoc");
		System.out.println("idseltypedoc="+idseltypedoc);
		String nameseltypedoc = request.getParameter("nameseltypedoc");
		System.out.println("nameseltypedoc="+nameseltypedoc);
		String specdoc = request.getParameter("specdoc");
		System.out.println("specdoc="+specdoc);
		String teldoc = request.getParameter("teldoc");
		System.out.println("teldoc="+teldoc);
		String emaildoc = request.getParameter("emaildoc");
		System.out.println("emaildoc="+emaildoc);
		
		typedoc = new TypeDoctor(Long.parseLong(idseltypedoc), nameseltypedoc);
		
		doctor = new Doctor();
		doctor.setLastnamedoc(lastnamedoc);
		doctor.setFirstnamedoc(firstnamedoc);
		doctor.setSpecialtydoc(specdoc);
		doctor.setEmaildoc(emaildoc);
		doctor.setCellnumbdoc(teldoc);
		doctor.setTypedoc(typedoc);
		docdao.addDoctor(doctor);
		
		listdoc = docdao.findAll();
		
		String xml01 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"+
        		"<AllDoctor>\n";
        		String xml02 = "<doctor>\n"+ 
        					   "<id>"+0+"</id>\n"+
        				       "<namedoctor>"+"Виберіть лікаря"+"</namedoctor>\n"+
        				       "</doctor>\n";
        		String xml03 = "";
		for (Doctor doctor : listdoc) {
			xml03 = xml03 + 
					"<doctor>\n"+
					"<id>" + doctor.getId() + "</id>\n"+
					"<namedoctor>" + doctor.getLastnamedoc() + " "+ doctor.getFirstnamedoc() + "</namedoctor>\n"+
					"</doctor>\n";
		}
		
		String xml = xml01 + xml02 + xml03 + "</AllDoctor>";
		response.getWriter().println(xml);
		response.getWriter().close();
		return modelAndView;
	}
}
