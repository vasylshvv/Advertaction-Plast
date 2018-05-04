package plast.org.ua.upu.controller;

import java.util.List;






import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.CostitemDao;
import plast.org.ua.upu.dao.DoctorDao;
import plast.org.ua.upu.dao.KVDao;
import plast.org.ua.upu.dao.LevelActionDao;
import plast.org.ua.upu.dao.KomendantDao;
import plast.org.ua.upu.dao.KurinDao;
import plast.org.ua.upu.dao.OrganizerDao;
import plast.org.ua.upu.dao.StanytsyaDao;
import plast.org.ua.upu.dao.StupinDao;
import plast.org.ua.upu.dao.TypeActionDao;
import plast.org.ua.upu.dao.TypeDoctorDao;
import plast.org.ua.upu.dao.VyshkilDao;
import plast.org.ua.upu.idao.ICostitemDao;
import plast.org.ua.upu.idao.IDoctorDao;
import plast.org.ua.upu.idao.IKVDao;
import plast.org.ua.upu.idao.ILevelActionDao;
import plast.org.ua.upu.idao.IKomendantDao;
import plast.org.ua.upu.idao.IKurinDao;
import plast.org.ua.upu.idao.IOrganizerDao;
import plast.org.ua.upu.idao.IStanystyaDao;
import plast.org.ua.upu.idao.IStupinDao;
import plast.org.ua.upu.idao.ITypeActionDao;
import plast.org.ua.upu.idao.ITypeDoctorDao;
import plast.org.ua.upu.idao.IVyshkilDao;
import plast.org.ua.upu.insert.InsertKV;
import plast.org.ua.upu.insert.InsertLevelAction;
import plast.org.ua.upu.insert.InsertStatusAdvert;
import plast.org.ua.upu.insert.InsertStupin;
import plast.org.ua.upu.insert.InsertTypeDoctor;
import plast.org.ua.upu.insert.InsertVyshkil;
import plast.org.ua.upu.insert.InsetrStatusReport;
import plast.org.ua.upu.table.Costitem;
import plast.org.ua.upu.table.Doctor;
import plast.org.ua.upu.table.KV;
import plast.org.ua.upu.table.LevelAction;
import plast.org.ua.upu.table.Komendant;
import plast.org.ua.upu.table.Kurin;
import plast.org.ua.upu.table.Organizer;
import plast.org.ua.upu.table.Stanytsya;
import plast.org.ua.upu.table.Stupin;
import plast.org.ua.upu.table.TypeAction;
import plast.org.ua.upu.table.TypeDoctor;
import plast.org.ua.upu.table.Vyshkil;

public class AdvartActionController implements Controller{
	private ITypeActionDao typeaction = TypeActionDao.getInstance();
	private IStanystyaDao standao = StanytsyaDao.getInstance();
	private IKurinDao kurindao = KurinDao.getInstance();
	private IVyshkilDao vyshkildao = VyshkilDao.getInstance();
	private IKVDao kvdao = KVDao.getInstance();
	private IStupinDao stupindao = StupinDao.getInstance();
	private IKomendantDao komendao = KomendantDao.getInstance();
	private IOrganizerDao organdao = OrganizerDao.getInstance();
	private ITypeDoctorDao typedocdao = TypeDoctorDao.getInstance();
	private IDoctorDao doctordao = DoctorDao.getInstance();
	private ICostitemDao costdao = CostitemDao.getInstance();
	private ILevelActionDao levelActionDao = LevelActionDao.getInstance();
	
	private List<TypeAction> listtypeaction;
	private List<Stanytsya> liststan;
	private List<Kurin> listkurin;
	private List<Vyshkil> listvyshkil;
	private List<KV> listkv;
	private List<Stupin> liststupin;
	private List<Komendant> listkomendant;
	private List<Organizer> listorgan;
	private List<TypeDoctor> listtypedoc;
	private List<Doctor> listdoctor;
	private List<Costitem> listcost;
	private List<LevelAction> listlevelaction;
	
	private InsertVyshkil insertvyshkil = new InsertVyshkil();
	private InsertKV insertkv = new InsertKV();
	private InsertStupin insertstupin = new InsertStupin();
	private InsertTypeDoctor inserttypdoc = new InsertTypeDoctor();
	private InsertStatusAdvert insertStatus = new InsertStatusAdvert();
	private InsetrStatusReport insertstatusReport = new InsetrStatusReport();
	private InsertLevelAction insertlevelAction = new InsertLevelAction();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("index.jsp");
		
		if(insertvyshkil.count() == 0){
			insertvyshkil.insert();
		}
			
		if(insertkv.count() == 0){
			insertkv.insert();
		}
		if(insertstupin.count() == 0){
			insertstupin.insert();
		}
		if(inserttypdoc.count() == 0){
			inserttypdoc.insert();
		}
		if(insertStatus.count() == 0){
			insertStatus.insert();
		}
		if(insertstatusReport.count() == 0){
			insertstatusReport.insert();
		}
		
		if(insertlevelAction.count() == 0){
			insertlevelAction.insert();
		}
		
		listkv = kvdao.findAll();
		listvyshkil = vyshkildao.findAll();
		listtypeaction = typeaction.findAll();
		liststan = standao.findAll();
		listkurin = kurindao.findAll();
		liststupin = stupindao.findAll(); 
		listkomendant = komendao.findAll();
		listorgan = organdao.findAll();
		listtypedoc = typedocdao.findAll();
		listdoctor = doctordao.findAll();
		listcost = costdao.findAll();
		listlevelaction = levelActionDao.findAllLevelAction();
		
		modelAndView.addObject("listtypeaction", listtypeaction);
		modelAndView.addObject("liststan", liststan);
		modelAndView.addObject("listkurin",listkurin);
		modelAndView.addObject("listvyshkil",listvyshkil);
		modelAndView.addObject("listkv",listkv);
		modelAndView.addObject("liststupin",liststupin);
		modelAndView.addObject("listkomendant",listkomendant);
		modelAndView.addObject("listorgan",listorgan);
		modelAndView.addObject("listtypedoc",listtypedoc);
		modelAndView.addObject("listdoctor",listdoctor);
		modelAndView.addObject("listcost",listcost);
		modelAndView.addObject("listlevelaction", listlevelaction);
		return modelAndView;
	}
}
