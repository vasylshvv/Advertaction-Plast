package plast.org.ua.upu.controller;

import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.CostitemDao;
import plast.org.ua.upu.dao.EstimateDao;
import plast.org.ua.upu.dao.EventsDao;
import plast.org.ua.upu.dao.LeaderShipDao;
import plast.org.ua.upu.dao.LeaderShipEventDao;
import plast.org.ua.upu.dao.LocateParticipantStanDao;
import plast.org.ua.upu.dao.PhotosEventReportDao;
import plast.org.ua.upu.dao.ReportDao;
import plast.org.ua.upu.dao.ReportEstimateDao;
import plast.org.ua.upu.dao.StanytsyaDao;
import plast.org.ua.upu.dao.StatusReportDao;
import plast.org.ua.upu.idao.ICostitemDao;
import plast.org.ua.upu.idao.IEstimateDao;
import plast.org.ua.upu.idao.IEventsDao;
import plast.org.ua.upu.idao.ILeaderShipDao;
import plast.org.ua.upu.idao.ILeaderShipEventDao;
import plast.org.ua.upu.idao.ILocateParticipantStanDao;
import plast.org.ua.upu.idao.IPhotosEventReportDao;
import plast.org.ua.upu.idao.IReportDao;
import plast.org.ua.upu.idao.IReportEstimateDao;
import plast.org.ua.upu.idao.IStanystyaDao;
import plast.org.ua.upu.idao.IStatusReportDao;
import plast.org.ua.upu.pojo.EstimateEditPojo;
import plast.org.ua.upu.pojo.EventViewPojo;
import plast.org.ua.upu.table.Costitem;
import plast.org.ua.upu.table.Events;
import plast.org.ua.upu.table.LeaderShip;
import plast.org.ua.upu.table.LeaderShipEvent;
import plast.org.ua.upu.table.LocateParticipantStan;
import plast.org.ua.upu.table.PhotosEventReport;
import plast.org.ua.upu.table.Report;
import plast.org.ua.upu.table.ReportEstimate;
import plast.org.ua.upu.table.Stanytsya;
import plast.org.ua.upu.table.Statusreport;
@MultipartConfig(maxFileSize = 10000000)
public class ReportAdvartController implements Controller {
	private List<EventViewPojo> listEventView;
	private List<Stanytsya> listStanytsya;
	private List<Events> listEvent;
	private List<LeaderShip> listLeaderShip;
	private List<EstimateEditPojo> listEstimPojo;
	private List<Costitem> listCost;
	private List<Statusreport> listStatusReport;
	private IEventsDao eventDao = EventsDao.getInstance();
	private IStanystyaDao stanystyaDao = StanytsyaDao.getInstance();
	private ILeaderShipDao leaderShipDao = LeaderShipDao.getInstance();
	private IEstimateDao estimateDao = EstimateDao.getInstance();
	private ICostitemDao costitemDao = CostitemDao.getInstance();
	private IReportDao reportDao = ReportDao.getInstance();
	private ILocateParticipantStanDao locateParticipantStanDao = LocateParticipantStanDao.getInstance();
	private ILeaderShipEventDao leaderShipEventDao = LeaderShipEventDao.getInstance();
	private IReportEstimateDao reportEstimateDao = ReportEstimateDao.getInstance();
	private IPhotosEventReportDao photosEventReportDao = PhotosEventReportDao.getInstance();
	private IStatusReportDao statusReportDao = StatusReportDao.getInstance();
	private Events events = null;
	private Report report = null;
	private Stanytsya stanytsya = null;
	private LocateParticipantStan locateParticipantStan = null;
	private LeaderShip leaderShip = null;
	private LeaderShipEvent leaderShipEvent = null;
	private Costitem costitem = null;
	private ReportEstimate reportEstimate = null;
	private MultipartHttpServletRequest multi;
	private MultipartFile mfile;
	private InputStream inputStream = null;
	private Blob blob;
	private PhotosEventReport photosEventReport;
	private Statusreport statusreport;
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = null;
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		
		String savereport = request.getParameter("savereport");
		System.out.println("savereport = " + savereport);
	
		
		
		if (savereport != null) {
		
			Set<String> stanSet = new TreeSet<String>();
			Set<String> countpartSet = new TreeSet<String>();		
			List<String> mergeStanCountp = null;
			
			Set<String> providSet = new TreeSet<String>();
			Set<String> firstnametSet = new TreeSet<String>();		
			Set<String> lastnametSet = new TreeSet<String>();
			List<String> mergeProvid = null;
			
			Set<String> costitemSet = new TreeSet<String>();
			Set<String> sumpartSet = new TreeSet<String>();
			Set<String> sumplastSet = new TreeSet<String>();
			Set<String> sumbudgetSet = new TreeSet<String>();
			Set<String> sumsponsorSet = new TreeSet<String>();
			Set<String> sumotherSet = new TreeSet<String>();
			List<String> mergeCost = null;
			
			Enumeration<String> allparam = request.getParameterNames();
			while (allparam.hasMoreElements()) {
				String parameter = (String) allparam.nextElement();
				System.out.println("parameter: " + parameter);
				if(parameter.indexOf("stan")==0){
					stanSet.add(parameter);					
				} else if(parameter.indexOf("countpart")==0){
					countpartSet.add(parameter);
				} else if(parameter.indexOf("selectprovid")==0){
					providSet.add(parameter);
				} else if(parameter.indexOf("firstname")==0){
					firstnametSet.add(parameter);
				} else if(parameter.indexOf("lastname")==0){
					lastnametSet.add(parameter);
				} else if(parameter.indexOf("costitem")==0){
					costitemSet.add(parameter);
				} else if(parameter.indexOf("sumpart")==0){
					sumpartSet.add(parameter);
				} else if(parameter.indexOf("sumplast")==0){
					sumplastSet.add(parameter);
				} else if(parameter.indexOf("sumbudget")==0){
					sumbudgetSet.add(parameter);
				} else if(parameter.indexOf("sumsponsor")==0){
					sumsponsorSet.add(parameter);
				} else if(parameter.indexOf("sumother")==0){
					sumotherSet.add(parameter);
				}
			}
			List<String> stanSort = new ArrayList<String>();
			stanSort.addAll(stanSet);
			List<String> countpartSort = new ArrayList<String>();
			countpartSort.addAll(countpartSet);
			
			mergeStanCountp = new ArrayList<String>(stanSort.size()+countpartSort.size());
			for (int i = 0; i < stanSort.size(); i++) {
				mergeStanCountp.add(stanSort.get(i));
				mergeStanCountp.add(countpartSort.get(i));
			}
			
			
			List<String> providSort = new ArrayList<String>();
			providSort.addAll(providSet);
			List<String> firstnameSort = new ArrayList<String>();
			firstnameSort.addAll(firstnametSet);
			List<String> lastnameSort = new ArrayList<String>();
			lastnameSort.addAll(lastnametSet);
			
			mergeProvid = new ArrayList<String>(providSort.size() + firstnameSort.size() + lastnameSort.size());
			for (int i = 0; i < providSort.size(); i++) {
				mergeProvid.add(providSort.get(i));
				mergeProvid.add(firstnameSort.get(i));
				mergeProvid.add(lastnameSort.get(i));
			}
			
			
			List<String> costitemSort = new ArrayList<String>();
			costitemSort.addAll(costitemSet);
			List<String> sumpartSort = new ArrayList<String>();
			sumpartSort.addAll(sumpartSet);
			List<String> sumplastSort = new ArrayList<String>();
			sumplastSort.addAll(sumplastSet);
			
			List<String> sumbudgetSort = new ArrayList<String>();
			sumbudgetSort.addAll(sumbudgetSet);
			List<String> sumsponsorSort = new ArrayList<String>();
			sumsponsorSort.addAll(sumsponsorSet);
			List<String> sumotherSort = new ArrayList<String>();
			sumotherSort.addAll(sumotherSet);
			
			mergeCost = new ArrayList<String>(costitemSort.size() + sumpartSort.size() + sumplastSort.size() + sumbudgetSort.size() + sumsponsorSort.size() + sumotherSort.size());
			for (int i = 0; i < costitemSort.size(); i++) {
				mergeCost.add(costitemSort.get(i));
				mergeCost.add(sumpartSort.get(i));
				mergeCost.add(sumplastSort.get(i));
				mergeCost.add(sumbudgetSort.get(i));
				mergeCost.add(sumsponsorSort.get(i));
				mergeCost.add(sumotherSort.get(i));
			}
			
			
			
			String ideventStr = request.getParameter("idevent");
			String conclusion = new String(request.getParameter("conclusion").getBytes("iso-8859-1"),"UTF-8");
			String countparticip = request.getParameter("contparticip");
			System.out.println("countparticip = "+countparticip);
			String informmedia = new String(request.getParameter("informmedia").getBytes("iso-8859-1"),"UTF-8");
			System.out.println("informmedia = "+informmedia);
			String other = new String(request.getParameter("other").getBytes("iso-8859-1"),"UTF-8");
			String recomendation = new String(request.getParameter("recomendation").getBytes("iso-8859-1"),"UTF-8");
			String tasks = new String(request.getParameter("tasks").getBytes("iso-8859-1"),"UTF-8");
			
			listStatusReport = statusReportDao.findAll("Прозвітовано");
			
			for (Statusreport statrep : listStatusReport) {			
				statusreport = new Statusreport(statrep.getId(), statrep.getDescription());
			}
			
			
			listEvent = eventDao.findAll(Long.parseLong(ideventStr));
			
			
			
			for (Events event : listEvent) {
				events = new Events(event.getId(), event.getAdvertname(), 
						event.getAdvertnameeng(), event.getDatefromadvert(), event.getDatetoadvert(), 
						event.getTypeaction(), event.getVenue(), event.getKomendant(), event.getOrganizer(), 
						event.getDoctor(), event.getProgram(), event.getPurpose(), event.getNumbparticip(), 
						event.getAgeparticipfrom(), event.getAgeparticipto(), event.getTopicality(), 
						event.getExpectresult(), event.getSumparticip(), event.getOtherinfo(), 
						event.getRegistrdate(), event.getStatus(), statusreport, event.getHashid(), 
						event.getLevelaction(), event.getGoverfinan());
			}
			
			
			
			report = new Report();
			report.setConclusion(conclusion);
			report.setCountparticip(Integer.parseInt(countparticip));
			report.setEvents(events);
			report.setInformmedia(informmedia);
			report.setOther(other);
			report.setRecomendation(recomendation);
			report.setStatusreport(statusreport);
			report.setTasks(tasks);
			reportDao.addReport(report);
			
			locateParticipantStan = new LocateParticipantStan();
			leaderShipEvent = new LeaderShipEvent();
			reportEstimate = new ReportEstimate();
		
			
			
				
			String parameter = null;
			int count = 0;
			int countleader = 0;
			int countrepestim = 0;
			
			for (int i = 0; i < mergeStanCountp.size(); i++) {
				parameter = mergeStanCountp.get(i);
				if(parameter.indexOf("stan")==0){
					String stan = request.getParameter(parameter);
					listStanytsya = stanystyaDao.findStanytsya(Long.parseLong(stan));
					for (Stanytsya stanyts : listStanytsya) {
						stanytsya = new Stanytsya(stanyts.getId(), stanyts.getNamestan());
					}
					locateParticipantStan.setStanytsya(stanytsya);
					count++;
				}
				
				if(parameter.indexOf("countpart")==0){
					String countpart = request.getParameter(parameter);
					locateParticipantStan.setCountparticipant(Integer.parseInt(countpart));
					count++;
				}
				
				if(count == 2){
					locateParticipantStan.setReport(report);
					locateParticipantStanDao.addLocatPartStan(locateParticipantStan);
					count = 0;
				}
				
			}
			
			for (int i = 0; i < mergeProvid.size(); i++) {
				parameter = mergeProvid.get(i);
				if(parameter.indexOf("selectprovid")==0){
					String provid = request.getParameter(parameter);
					listLeaderShip = leaderShipDao.findAllLeader(Long.parseLong(provid));
					for (LeaderShip ledship : listLeaderShip) {
						leaderShip = new LeaderShip(ledship.getId(), ledship.getNamelider());
					}
					leaderShipEvent.setLeaderShip(leaderShip); 
					countleader++;
				}
				if(parameter.indexOf("firstname")==0){
					String firstname = new String(request.getParameter(parameter).getBytes("iso-8859-1"),"UTF-8");
					leaderShipEvent.setFirstname(firstname);
					countleader++;
				}
				if(parameter.indexOf("lastname")==0){
					String lastname = new String(request.getParameter(parameter).getBytes("iso-8859-1"),"UTF-8");
					leaderShipEvent.setLastname(lastname);
					countleader++;
				}
				if(countleader == 3){
					leaderShipEvent.setReport(report);
					leaderShipEvent.setEvents(events);
					leaderShipEventDao.addLeaderShipEvent(leaderShipEvent);
					countleader = 0;
				}
				
			}
			
			for (int i = 0; i < mergeCost.size(); i++) {
				parameter = mergeCost.get(i);
				if(parameter.indexOf("costitem")==0){
					String costitemparam = request.getParameter(parameter);
					listCost = costitemDao.findAll(Long.parseLong(costitemparam));
					for (Costitem costi : listCost) {
						costitem = new Costitem(costi.getId(), costi.getNamecostitem());
					}
					reportEstimate.setCostitem(costitem);
					countrepestim++;
				}
				if(parameter.indexOf("sumpart")==0){
					String sumpart = request.getParameter(parameter);
					reportEstimate.setSumparticipant(Integer.parseInt(sumpart));
					countrepestim++;
				}
				if(parameter.indexOf("sumplast")==0){
					String sumplast = request.getParameter(parameter);
					System.out.println("sumplast = "+sumplast);
					reportEstimate.setSumplast(Integer.parseInt(sumplast));
					countrepestim++;
				}
				if(parameter.indexOf("sumbudget")==0){
					String sumbudget = request.getParameter(parameter);
					reportEstimate.setSumbudget(Integer.parseInt(sumbudget));
					countrepestim++;
				}
				if(parameter.indexOf("sumsponsor")==0){
					String sumsponsor = request.getParameter(parameter);
					reportEstimate.setSumsponsor(Integer.parseInt(sumsponsor));
					countrepestim++;
				}
				if(parameter.indexOf("sumother")==0){
					String sumother = request.getParameter(parameter);
					reportEstimate.setSumother(Integer.parseInt(sumother));
					countrepestim++;
				}
				if(countrepestim == 6){
					reportEstimate.setReport(report);
					reportEstimateDao.addEstimateReport(reportEstimate);
					countrepestim = 0;
				}
			}
			
			
			
			
			int img;
			photosEventReport = new PhotosEventReport();
			multi = (MultipartHttpServletRequest)request;
			List<MultipartFile> images = multi.getFiles("photosadvert");
			for (MultipartFile multipartFile : images) {
				inputStream = multipartFile.getInputStream();
				blob = Hibernate.createBlob(inputStream);
				photosEventReport.setPhoto(blob);
				photosEventReport.setNamefile(multipartFile.getOriginalFilename());
				photosEventReport.setReport(report);
				photosEventReportDao.addPhotosEvent(photosEventReport);
			}
			return new ModelAndView("redirect:listevents.html");
		} else {
			Long idevent = Long.parseLong(request.getParameter("idreport"));
			String hashcode = request.getParameter("hashcode");
			String chekcode = "";
			if (idevent != null) {

				listEvent = eventDao.findAll(idevent);
				for (Events events : listEvent) {
					chekcode = events.getHashid();
				}

				/* Fill in REPORT from DB */
				if (chekcode.equals(hashcode)) {
					modelAndView = new ModelAndView("/jsp/report.jsp");
					listEventView = eventDao.findViewEvent(idevent);
					listStanytsya = stanystyaDao.findAll();
					listLeaderShip = leaderShipDao.findAllLeader();
					listEstimPojo = estimateDao.findAllEstEvent(idevent);
					listCost = costitemDao.findAll();
					modelAndView.addObject("listeventview", listEventView);
					modelAndView.addObject("liststanytsya", listStanytsya);
					modelAndView.addObject("listleadership", listLeaderShip);
					modelAndView.addObject("listestimpojo", listEstimPojo);
					modelAndView.addObject("listcost", listCost);
					return modelAndView;
				}
			}
		}

		return modelAndView;

	}
}
