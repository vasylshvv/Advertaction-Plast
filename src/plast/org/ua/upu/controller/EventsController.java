package plast.org.ua.upu.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;




import plast.org.ua.upu.dao.CostitemDao;
import plast.org.ua.upu.dao.DoctorDao;
import plast.org.ua.upu.dao.EstimateDao;
import plast.org.ua.upu.dao.EventsDao;
import plast.org.ua.upu.dao.LevelActionDao;
import plast.org.ua.upu.dao.KomendantDao;
import plast.org.ua.upu.dao.OrganizerDao;
import plast.org.ua.upu.dao.TypeActionDao;
import plast.org.ua.upu.files.CreateFileAdvert;
import plast.org.ua.upu.idao.ICostitemDao;
import plast.org.ua.upu.idao.IDoctorDao;
import plast.org.ua.upu.idao.IEstimateDao;
import plast.org.ua.upu.idao.IEventsDao;
import plast.org.ua.upu.idao.ILevelActionDao;
import plast.org.ua.upu.idao.IKomendantDao;
import plast.org.ua.upu.idao.IOrganizerDao;
import plast.org.ua.upu.idao.ITypeActionDao;
import plast.org.ua.upu.md.MD5;
import plast.org.ua.upu.sendemail.SendEmailAdvert;
import plast.org.ua.upu.table.Costitem;
import plast.org.ua.upu.table.Doctor;
import plast.org.ua.upu.table.Estimate;
import plast.org.ua.upu.table.Events;
import plast.org.ua.upu.table.LevelAction;
import plast.org.ua.upu.table.Komendant;
import plast.org.ua.upu.table.Organizer;
import plast.org.ua.upu.table.Statusadvert;
import plast.org.ua.upu.table.Statusreport;
import plast.org.ua.upu.table.TypeAction;
import plast.org.ua.upu.transliter.Transliterator;


public class EventsController implements Controller {
	private ITypeActionDao typeActionDao = TypeActionDao.getInstance();
	private IKomendantDao komendantDao = KomendantDao.getInstance();
	private IOrganizerDao organizerDao = OrganizerDao.getInstance();
	private IDoctorDao doctorDao = DoctorDao.getInstance();
	private IEventsDao eventsDao = EventsDao.getInstance();
	private IEstimateDao estimateDao = EstimateDao.getInstance();
	private ICostitemDao costitemDao = CostitemDao.getInstance();
	private ILevelActionDao levelActionDao = LevelActionDao.getInstance();
	
	private List<TypeAction> listtypeaction;
	private List<Komendant> listkomendant;
	private List<Organizer> listorganizer;
	private List<Doctor> listdoctor;
	private List<Costitem> listcostitem;
	private List<LevelAction> listLevelAction;

	private TypeAction typeaction;
	private Komendant komendantaction;
	private Organizer organizeraction;
	private Doctor doctoraction;
	private Events events;
	private Estimate estimate;
	private Costitem costitem;
	private Date datefromadvert;
	private Date datetoadvert;
	private LevelAction levelAction;
	

	private CreateFileAdvert createFileAdvert;
	private SendEmailAdvert sendEmailAdvert;
	private Transliterator transliterator;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//ModelAndView  modelAndView = new ModelAndView("/jsp/addevent.jsp");
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		
		String saveevents = request.getParameter("saveevents");
		
	
			String advertname = request.getParameter("advertname");
			System.out.println("advertname = " + advertname);

			String datefromstr = request.getParameter("datefrom");
			System.out.println("datefrom = " + datefromstr);
			datefromadvert = new Date(dateFormat.parse(datefromstr).getTime());

			String datetostr = request.getParameter("dateto");
			System.out.println("dateto = " + datetostr);
			datetoadvert = new Date(dateFormat.parse(datetostr).getTime());

			String typeadvert = request.getParameter("typeadvert");
			System.out.println("typeadvert = " + typeadvert);
			listtypeaction = typeActionDao.findAll(Long.parseLong(typeadvert));
			for (TypeAction typeAction : listtypeaction) {
				typeaction = new TypeAction(typeAction.getId(),
						typeAction.getNametypeaction());
			}

			String venue = request.getParameter("venue");
			System.out.println("venue = " + venue);

			String komendant = request.getParameter("komendant");
			System.out.println("komendant = " + komendant);
			listkomendant = komendantDao.findAll(Long.parseLong(komendant));
			String komendantEmail="";
			for (Komendant komendnt : listkomendant) {
				komendantaction = new Komendant(komendnt.getId(),
						komendnt.getFirstname(), komendnt.getLastname(),
						komendnt.getBirthday(), komendnt.getStupin(),
						komendnt.getStanytsya(), komendnt.getKurin(),
						komendnt.getVyshkil(), komendnt.getKv(),
						komendnt.getCellnumber(), komendnt.getEmail());
				komendantEmail = komendnt.getEmail();
			}

			String organizer = request.getParameter("organizer");
			System.out.println("organizer = " + organizer);
			listorganizer = organizerDao.findAll(Long.parseLong(organizer));
			for (Organizer organizer2 : listorganizer) {
				organizeraction = new Organizer(organizer2.getId(),
						organizer2.getNameorganizer());
			}

			String doctor = request.getParameter("doctor");
			System.out.println("doctor = " + doctor);
			listdoctor = doctorDao.findAll(Long.parseLong(doctor));
			for (Doctor doctor2 : listdoctor) {
				doctoraction = new Doctor(doctor2.getId(),
						doctor2.getLastnamedoc(), doctor2.getFirstnamedoc(),
						doctor2.getSpecialtydoc(), doctor2.getCellnumbdoc(),
						doctor2.getEmaildoc(), doctor2.getTypedoc());
			}
			String program = request.getParameter("program");
			System.out.println("program = " + program);

			String purpose = request.getParameter("purpose");
			System.out.println("purpose = " + purpose);

			String counpaticip = request.getParameter("counpaticip");
			System.out.println("counpaticip = " + counpaticip);
			if(counpaticip == ""){
				counpaticip = "0";
			} else if(counpaticip == null){
				counpaticip = "0";
			} 
			
			String fromoldpat = request.getParameter("fromoldpat");
			System.out.println("fromoldpat = " + fromoldpat);
			if(fromoldpat == ""){
				fromoldpat = "0";
			} else if(fromoldpat == null){
				fromoldpat = "0";
			} 
			
			String tooldpat = request.getParameter("tooldpat");
			System.out.println("tooldpat = " + tooldpat);
			if(tooldpat == ""){
				tooldpat = "0";
			} else if(tooldpat == null){
				tooldpat = "0";
			} 
			
			
			String topicality = request.getParameter("topicality");
			System.out.println("topicality = " + topicality);

			String expectresult = request.getParameter("expectresult");
			System.out.println("expectresult=" + expectresult);

			String mainsumprt = request.getParameter("mainsumprt");
			System.out.println("mainsumprt = " + mainsumprt);

			String otherinfo = request.getParameter("otherinfo");
			System.out.println("otherinfo = " + otherinfo);
			
			String levelaction = request.getParameter("leveladvert");
			System.out.println("levelaction = "+levelaction);
			
			listLevelAction = levelActionDao.findOneLevelAction(Long.parseLong(levelaction));
			for (LevelAction ka : listLevelAction) {
				levelAction = new LevelAction(ka.getId(), ka.getNamelevel());
			}
			
			String govertfin = request.getParameter("goverfin");
			System.out.println("govertfin = "+govertfin);
			Integer govertfinan = 0;
			if(govertfin!=null){
				if(govertfin.equals("on")){
					govertfinan = 1;
				} else {
					govertfinan = 0;
				}
			}
			
			
			
			java.util.Date createDate = new java.util.Date();
			// dateregister = new Date(dateFormat.)
			String hashid = MD5.getHash(createDate + advertname);
			String advertnameEng;
			transliterator = new Transliterator();
			advertnameEng = transliterator.transliterate(advertname);
			events = new Events();
			events.setAdvertname(advertname);
			events.setAdvertnameeng(advertnameEng);
			events.setDatefromadvert(datefromadvert);
			events.setDatetoadvert(datetoadvert);
			events.setTypeaction(typeaction);
			events.setVenue(venue);
			events.setKomendant(komendantaction);
			events.setOrganizer(organizeraction);
			events.setDoctor(doctoraction);
			events.setProgram(program);
			events.setPurpose(purpose);
			events.setNumbparticip(Integer.parseInt(counpaticip));
			events.setAgeparticipfrom(Integer.parseInt(fromoldpat));
			events.setAgeparticipto(Integer.parseInt(tooldpat));
			events.setTopicality(topicality);
			events.setExpectresult(expectresult);
			events.setSumparticip(Integer.parseInt(mainsumprt));
			events.setOtherinfo(otherinfo);
			events.setRegistrdate(createDate);
			events.setStatus(new Statusadvert((long) 1, "Зголошенно"));
			events.setStatusreport(new Statusreport((long)1, "Не прозвітовано"));
			events.setHashid(hashid);
			events.setLevelaction(levelAction);
			events.setGoverfinan(govertfinan);
			eventsDao.addEvents(events);
			estimate = new Estimate();
			int count = 0;

//			String url = request.getQueryString();
//			String[] pairs = url.split("&");			
//			String parameter;
//			for (String pair : pairs) {
//				int idx = pair.indexOf("=");
//				parameter = pair.substring(0, idx);
//				if (parameter.indexOf("sumpart") == 0
//						|| parameter.indexOf("sumplast") == 0
//						|| parameter.indexOf("sumbudget") == 0
//						|| parameter.indexOf("sumsponsor") == 0
//						|| parameter.indexOf("sumother") == 0
//						|| parameter.indexOf("costitem") == 0) {
//					if (parameter.indexOf("sumpart") == 0) {
//						String sumpart = request.getParameter(parameter);
//
//						estimate.setSumparticipant(Integer.parseInt(sumpart));
//						count++;
//					}
//					if (parameter.indexOf("sumplast") == 0) {
//						String sumplast = request.getParameter(parameter);
//						estimate.setSumplast(Integer.parseInt(sumplast));
//						count++;
//					}
//					if (parameter.indexOf("sumbudget") == 0) {
//						String sumbudget = request.getParameter(parameter);
//						estimate.setSumbudget(Integer.parseInt(sumbudget));
//						count++;
//					}
//					if (parameter.indexOf("sumsponsor") == 0) {
//						String sumsponsor = request.getParameter(parameter);
//						estimate.setSumsponsor(Integer.parseInt(sumsponsor));
//						count++;
//					}
//					if (parameter.indexOf("sumother") == 0) {
//						String sumother = request.getParameter(parameter);
//						estimate.setSumother(Integer.parseInt(sumother));
//						count++;
//					}
//					if (parameter.indexOf("costitem") == 0) {
//						String costitemparam = request.getParameter(parameter);
//						System.out.println("costitemparam = " + costitemparam);
//						listcostitem = costitemDao.findAll(Long
//								.parseLong(costitemparam));
//						for (Costitem costItem : listcostitem) {
//							costitem = new Costitem(costItem.getId(),
//									costItem.getNamecostitem());
//						}
//						estimate.setCostitem(costitem);
//						count++;
//					}
//					if (count == 6) {
//						estimate.setEvents(events);
//						estimateDao.addEstimate(estimate);
//						count = 0;
//					}
//				}
//			}
			
			Enumeration<String> a = request.getParameterNames();
			while (a.hasMoreElements()) {
				String parameter = (String) a.nextElement();
				System.out.println("parameters = "+parameter + " = " + request.getParameter(parameter));
				
				if (parameter.indexOf("sumpart") == 0
						|| parameter.indexOf("sumplast") == 0
						|| parameter.indexOf("sumbudget") == 0
						|| parameter.indexOf("sumsponsor") == 0
						|| parameter.indexOf("sumother") == 0
						|| parameter.indexOf("costitem") == 0) {
					if (parameter.indexOf("sumpart") == 0) {
						String sumpart = request.getParameter(parameter);

						estimate.setSumparticipant(Integer.parseInt(sumpart));
						count++;
					}
					if (parameter.indexOf("sumplast") == 0) {
						String sumplast = request.getParameter(parameter);
						estimate.setSumplast(Integer.parseInt(sumplast));
						count++;
					}
					if (parameter.indexOf("sumbudget") == 0) {
						String sumbudget = request.getParameter(parameter);
						estimate.setSumbudget(Integer.parseInt(sumbudget));
						count++;
					}
					if (parameter.indexOf("sumsponsor") == 0) {
						String sumsponsor = request.getParameter(parameter);
						estimate.setSumsponsor(Integer.parseInt(sumsponsor));
						count++;
					}
					if (parameter.indexOf("sumother") == 0) {
						String sumother = request.getParameter(parameter);
						estimate.setSumother(Integer.parseInt(sumother));
						count++;
					}
					if (parameter.indexOf("costitem") == 0) {
						String costitemparam = request.getParameter(parameter);
						System.out.println("costitemparam = " + costitemparam);
						listcostitem = costitemDao.findAll(Long
								.parseLong(costitemparam));
						for (Costitem costItem : listcostitem) {
							costitem = new Costitem(costItem.getId(),
									costItem.getNamecostitem());
						}
						estimate.setCostitem(costitem);
						count++;
					}
					if (count == 6) {
						estimate.setEvents(events);
						estimateDao.addEstimate(estimate);
						count = 0;
					}
				}
				
			}

			System.out.println("___________END__________________");
			createFileAdvert = new CreateFileAdvert();
			createFileAdvert.setHashid(hashid);
			
			
			String info = "<h1>Інформація</h1>";
			String nameapp = "<p>Зголошено акцію: "+"<b><font size='4'>"+advertname+"</font></b>"+"</p>";
			String lote = "<p>Дата проведення: з "+"<b><font size='4'>"+datefromstr+"</font></b>"+" по "+"<b><font size='4'>"+datetostr+"</font></b>"+"</p>";
			String desc = "<p>Для редагування зголошення вам потрібно вносити код: "+"<b><font size='4'>"+hashid+"</font></b>"+"</p>";
			String text = info + nameapp + lote + desc; 
			
			sendEmailAdvert = new SendEmailAdvert("techniclsuport@gmail.com", "@ctiv@tion");
			sendEmailAdvert.send("Зголошення "+advertname, text, "vasylshvv@gmail.com", komendantEmail);
			return new ModelAndView("redirect:listevents.html");
		
	}
}
