package plast.org.ua.upu.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import plast.org.ua.upu.dao.KVDao;
import plast.org.ua.upu.dao.KomendantDao;
import plast.org.ua.upu.dao.KurinDao;
import plast.org.ua.upu.dao.LevelActionDao;
import plast.org.ua.upu.dao.OrganizerDao;
import plast.org.ua.upu.dao.StanytsyaDao;
import plast.org.ua.upu.dao.StupinDao;
import plast.org.ua.upu.dao.TypeActionDao;
import plast.org.ua.upu.dao.TypeDoctorDao;
import plast.org.ua.upu.dao.VyshkilDao;
import plast.org.ua.upu.files.CreateFileAdvert;
import plast.org.ua.upu.idao.ICostitemDao;
import plast.org.ua.upu.idao.IDoctorDao;
import plast.org.ua.upu.idao.IEstimateDao;
import plast.org.ua.upu.idao.IEventsDao;
import plast.org.ua.upu.idao.IKVDao;
import plast.org.ua.upu.idao.IKomendantDao;
import plast.org.ua.upu.idao.IKurinDao;
import plast.org.ua.upu.idao.ILevelActionDao;
import plast.org.ua.upu.idao.IOrganizerDao;
import plast.org.ua.upu.idao.IStanystyaDao;
import plast.org.ua.upu.idao.IStupinDao;
import plast.org.ua.upu.idao.ITypeActionDao;
import plast.org.ua.upu.idao.ITypeDoctorDao;
import plast.org.ua.upu.idao.IVyshkilDao;
import plast.org.ua.upu.pojo.EstimateEditPojo;
import plast.org.ua.upu.pojo.EventEditPojo;
import plast.org.ua.upu.pojo.EventViewPojo;
import plast.org.ua.upu.sendemail.SendEmailAdvert;
import plast.org.ua.upu.table.Costitem;
import plast.org.ua.upu.table.Doctor;
import plast.org.ua.upu.table.Estimate;
import plast.org.ua.upu.table.Events;
import plast.org.ua.upu.table.KV;
import plast.org.ua.upu.table.Komendant;
import plast.org.ua.upu.table.Kurin;
import plast.org.ua.upu.table.LevelAction;
import plast.org.ua.upu.table.Organizer;
import plast.org.ua.upu.table.Stanytsya;
import plast.org.ua.upu.table.Statusadvert;
import plast.org.ua.upu.table.Statusreport;
import plast.org.ua.upu.table.Stupin;
import plast.org.ua.upu.table.TypeAction;
import plast.org.ua.upu.table.TypeDoctor;
import plast.org.ua.upu.table.Vyshkil;
import plast.org.ua.upu.transliter.Transliterator;

public class EditAdvertController implements Controller {
	private List<EventEditPojo> listEventEdit;
	private List<TypeAction> listTypeAction;
	private List<Komendant> listKomendant;
	private List<Organizer> listOrgan;
	private List<Doctor> listDoctor;
	private List<Stupin> listStupin;
	private List<Stanytsya> listStan;
	private List<Kurin> listKurin;
	private List<Vyshkil> listVyshkil;
	private List<KV> listKV;
	private List<TypeDoctor> listtypeDoc;
	private List<EstimateEditPojo> listEstimPojo;
	private List<Costitem> listCost;
	private List<Costitem> listcostitem;
	private List<LevelAction> listlevelaction;
	private IEventsDao eventDao = EventsDao.getInstance();
	private ITypeActionDao typeActionDao = TypeActionDao.getInstance();
	private IKomendantDao komedantDao = KomendantDao.getInstance();
	private IOrganizerDao organizerDao = OrganizerDao.getInstance();
	private IDoctorDao doctorDao = DoctorDao.getInstance();
	private IStupinDao stupinDao = StupinDao.getInstance();
	private IStanystyaDao stanDao = StanytsyaDao.getInstance();
	private IKurinDao kurinDao = KurinDao.getInstance();
	private IVyshkilDao vyshkilDao = VyshkilDao.getInstance();
	private IKVDao kvDao = KVDao.getInstance();
	private ITypeDoctorDao typeDoctorDao = TypeDoctorDao.getInstance();
	private IEstimateDao estimateDao = EstimateDao.getInstance();
	private ICostitemDao costitemDao = CostitemDao.getInstance();
	private ILevelActionDao levelActionDao = LevelActionDao.getInstance();

	private Events events;
	private Estimate estimate;
	private Costitem costitem;
	private CreateFileAdvert createFileAdvert;
	private SendEmailAdvert sendEmailAdvert;
	private Transliterator transliterator;
	private String komendantEmail;
	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	private List<Events> listEvent;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ModelAndView modelAndView = null;
	String updatevents = request.getParameter("updatevents");
	String hashcode = request.getParameter("hashcode");
	String ideventstr = request.getParameter("idedit");
	String checkcode = "";

	if(ideventstr!=null){
		listEvent = eventDao.findAll(Long.parseLong(ideventstr));
		for (Events events : listEvent) {
			checkcode = events.getHashid();
		}
	}
	
		if (updatevents == null && checkcode.equals(hashcode)) {
			modelAndView = new ModelAndView("/jsp/editadv.jsp");
			Long idevent = Long.parseLong(ideventstr);
			listEventEdit = eventDao.findEditEvent(idevent);
			for (EventEditPojo editPojo : listEventEdit) {
				System.out.println(editPojo.getAdvertname() + "\n"+editPojo.getKomendantid());
			}
			listTypeAction = typeActionDao.findAll();
			listKomendant = komedantDao.findAll();
			listOrgan = organizerDao.findAll();
			listDoctor = doctorDao.findAll();
			listStupin = stupinDao.findAll();
			listStan = stanDao.findAll();
			listKurin = kurinDao.findAll();
			listVyshkil = vyshkilDao.findAll();
			listKV = kvDao.findAll();
			listtypeDoc = typeDoctorDao.findAll();
			listEstimPojo = estimateDao.findAllEstEvent(idevent);
			listCost = costitemDao.findAll();
			listlevelaction = levelActionDao.findAllLevelAction();
			modelAndView.addObject("listeventedit", listEventEdit);
			modelAndView.addObject("listtypeaction", listTypeAction);
			modelAndView.addObject("listkomendant", listKomendant);
			modelAndView.addObject("listorgan", listOrgan);
			modelAndView.addObject("listdoctor", listDoctor);
			modelAndView.addObject("liststupin", listStupin);
			modelAndView.addObject("liststan", listStan);
			modelAndView.addObject("listkurin", listKurin);
			modelAndView.addObject("listvyshkil", listVyshkil);
			modelAndView.addObject("listkv", listKV);
			modelAndView.addObject("listtypedoc", listtypeDoc);
			modelAndView.addObject("listestimpojo", listEstimPojo);
			modelAndView.addObject("listcost", listCost);
			modelAndView.addObject("listlevelaction", listlevelaction);
			return modelAndView;
		} else if (updatevents != null) {

			Long idevent = Long.parseLong(request.getParameter("idadvert"));
			System.out.println("idevent = " + idevent);
			String advertname = request.getParameter("advertname");
			System.out.println("advertname = " + advertname);
			Date datefromadvert = new Date(dateFormat.parse(request.getParameter("datefrom")).getTime());
			System.out.println("datefrom = " + datefromadvert);
			Date datetoadvert = new Date(dateFormat.parse(request.getParameter("dateto")).getTime());
			System.out.println("dateto = " + datetoadvert);

			Long typeadvert = Long.parseLong(request.getParameter("typeadvert"));
			System.out.println("typeadvert = " + typeadvert);
			String venue = request.getParameter("venue");
			System.out.println("venue = " + venue);
			Long komendant = Long.parseLong(request.getParameter("komendant"));
			System.out.println("komendant = " + komendant);
			Long organizer = Long.parseLong(request.getParameter("organizer"));
			System.out.println("organizer = " + organizer);
			Long doctor = Long.parseLong(request.getParameter("doctor"));
			System.out.println("doctor = " + doctor);
			String program = request.getParameter("program");
			System.out.println("program = " + program);
			String purpose = request.getParameter("purpose");
			System.out.println("purpose = " + purpose);
			Integer countpaticip = Integer.parseInt(request.getParameter("countpaticip"));
			System.out.println("countpaticip = " + countpaticip);
			Integer fromoldpat = Integer.parseInt(request.getParameter("fromoldpat"));
			System.out.println("fromoldpat = " + fromoldpat);
			Integer tooldpat = Integer.parseInt(request.getParameter("tooldpat"));
			System.out.println("tooldpat = " + tooldpat);
			String topicality = request.getParameter("topicality");
			System.out.println("topicality = " + topicality);
			String expectresult = request.getParameter("expectresult");
			System.out.println("expectresult = " + expectresult);
			Integer mainsumprt = Integer.parseInt(request.getParameter("mainsumprt"));
			System.out.println("mainsumprt = " + mainsumprt);
			String otherinfo = request.getParameter("otherinfo");
			System.out.println("otherinfo = " + otherinfo);
			
			String leveladvert = request.getParameter("leveladvert");
			System.out.println("leveladvert = "+leveladvert);
			
			String goverfin = request.getParameter("goverfin");
			System.out.println("goverfin = "+goverfin);
			
			Integer goverfinan = 0;
			if(goverfin!= null){
				goverfinan = 1;
			} else {
				goverfinan = 0;
			}
			
			List<Doctor> updlistDoctor = doctorDao.findAll(doctor);
			Doctor updoctor = null;
			for (Doctor doc : updlistDoctor) {
				updoctor = new Doctor(doc.getId(), doc.getLastnamedoc(), doc.getFirstnamedoc(), doc.getSpecialtydoc(),
						doc.getCellnumbdoc(), doc.getEmaildoc(), doc.getTypedoc());
			}

			List<Events> updlistEvents = eventDao.findAll(idevent);
			String hashid = null;
			for (Events events : updlistEvents) {
				hashid = events.getHashid();
			}

			List<Komendant> updlistKomendant = komedantDao.findAll(komendant);
			Komendant updkomend = null;
			
			for (Komendant komendant2 : updlistKomendant) {
				updkomend = new Komendant(komendant2.getId(), komendant2.getFirstname(), komendant2.getLastname(),
						komendant2.getBirthday(), komendant2.getStupin(), komendant2.getStanytsya(),
						komendant2.getKurin(), komendant2.getVyshkil(), komendant2.getKv(), komendant2.getCellnumber(),
						komendant2.getEmail());
				komendantEmail = komendant2.getEmail();
			}

			List<Organizer> updlistOrganizer = organizerDao.findAll(organizer);
			Organizer org = null;
			for (Organizer organizer2 : updlistOrganizer) {
				org = new Organizer(organizer2.getId(), organizer2.getNameorganizer());
			}

			List<TypeAction> updlistTypeAction = typeActionDao.findAll(typeadvert);
			TypeAction ta = null;
			for (TypeAction typeAction2 : updlistTypeAction) {
				ta = new TypeAction(typeAction2.getId(), typeAction2.getNametypeaction());
			}
			
			List<LevelAction> updatelistLevelAction = levelActionDao.findOneLevelAction(Long.parseLong(leveladvert));
			LevelAction la = null;
			for (LevelAction la2 : updatelistLevelAction) {
				la = new LevelAction(la2.getId(), la2.getNamelevel());
			}
			String advertnameEng;
			transliterator = new Transliterator();
			advertnameEng = transliterator.transliterate(advertname);
			
			events = new Events();
			
			events.setAdvertname(advertname);
			events.setAdvertnameeng(advertnameEng);
			events.setAgeparticipfrom(fromoldpat);
			events.setAgeparticipto(tooldpat);
			events.setDatefromadvert(datefromadvert);
			events.setDatetoadvert(datetoadvert);
			events.setDoctor(updoctor);
			events.setExpectresult(expectresult);
			events.setHashid(hashid);
			events.setId(idevent);
			events.setKomendant(updkomend);
			events.setNumbparticip(countpaticip);
			events.setOrganizer(org);
			events.setOtherinfo(otherinfo);
			events.setProgram(program);
			events.setPurpose(purpose);
			events.setRegistrdate(new Date());
			events.setStatus(new Statusadvert((long) 1, "Зголошенно"));
			events.setStatusreport(new Statusreport((long)1, "Не прозвітовано"));
			events.setSumparticip(mainsumprt);
			events.setTopicality(topicality);
			events.setTypeaction(ta);
			events.setVenue(venue);
			events.setGoverfinan(goverfinan);
			events.setLevelaction(la);
			eventDao.updateEvent(events);

			
//			Enumeration<String> allparam = request.getParameterNames();
//			while (allparam.hasMoreElements()) {
//				String string = (String) allparam.nextElement();
//				System.out.println("allparam = "+string);
//			}
			 
			//String paramas = request.getParameterValues(hashid);
			
			// String costitem = request.getParameter("costitem");
			//
			// System.out.println("costitem = " + costitem);
			//
//			 String[] cost = request.getParameterValues("costitem");
//			 for (int i = 0; i < cost.length; i++) {
//			 System.out.println("costik = "+cost[i]);
//			 }
			// String sumpart = request.getParameter("sumpart");
			// System.out.println("sumpart = " + sumpart);
			// String sumplast = request.getParameter("sumplast");
			// System.out.println("sumplast = " + sumplast);
			// String sumbudget = request.getParameter("sumbudget");
			// System.out.println("sumbudget = " + sumbudget);
			// String sumsponsor = request.getParameter("sumsponsor");
			// System.out.println("sumsponsor = " + sumsponsor);
			// String sumother = request.getParameter("sumother");
			// System.out.println("sumother = " + sumother);
			//
			estimate = new Estimate();
			int count = 0;
			int estim = 0;
//			String url = request.getQueryString();
//			System.out.println("URL = "+url);
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
//						|| parameter.indexOf("costitem") == 0
//						|| parameter.indexOf("estimid")==0) {
//					
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
//						
//						count++;
//					}
//					
//					
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
//					String estimid="";
//					if (parameter.indexOf("estimid") == 0) {
//						estimid = request.getParameter(parameter);
//						estimate.setId(Long.parseLong(estimid));
//						count++;
//						estim++;
//					}
//					System.out.println(count + " ==== "+ estim);
//					if (count == 7 && estim!=0) {
//						estimate.setEvents(events);
//						estimateDao.updateEstimate(estimate);
//						count = 0;
//						estim = 0;
//					} else if (count == 6 && estim == 0 ){
//						estimate.setEvents(events);
//						estimateDao.addEstimate(estimate);
//						count = 0;
//						estim = 0;
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
						|| parameter.indexOf("costitem") == 0
						|| parameter.indexOf("estimid")==0) {
					
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
					String estimid="";
					if (parameter.indexOf("estimid") == 0) {
						estimid = request.getParameter(parameter);
						estimate.setId(Long.parseLong(estimid));
						count++;
						estim++;
					}
					System.out.println(count + " ==== "+ estim);
					if (count == 7 && estim!=0) {
						estimate.setEvents(events);
						estimateDao.updateEstimate(estimate);
						count = 0;
						estim = 0;
					} else if (count == 6 && estim == 0 ){
						estimate.setEvents(events);
						estimateDao.addEstimate(estimate);
						count = 0;
						estim = 0;
					}
				}
			}
			System.out.println("___________END__________________");
			createFileAdvert = new CreateFileAdvert();
			createFileAdvert.setHashid(hashid);
			
			
			sendEmailAdvert = new SendEmailAdvert("techniclsuport@gmail.com", "@ctiv@tion");
			sendEmailAdvert.send("Зголошення "+advertname, "Для редагування зголошення вам потрібно вносити код "+hashid, "vasylshvv@gmail.com", komendantEmail);
			return new ModelAndView("redirect:listevents.html");
		}
		return modelAndView;
	}
	
}
