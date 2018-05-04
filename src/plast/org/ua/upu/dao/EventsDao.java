package plast.org.ua.upu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.IEventsDao;
import plast.org.ua.upu.pojo.EventEditPojo;
import plast.org.ua.upu.pojo.EventViewPojo;
import plast.org.ua.upu.pojo.ListEventPojo;
import plast.org.ua.upu.table.Events;


public class EventsDao extends HibernateDaoSupport implements IEventsDao{
	private static final Log log = LogFactory.getLog(EventsDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static IEventsDao instance;
	
	public static IEventsDao getInstance() {
		if(instance == null){
			instance = (IEventsDao)context.getBean("events");
		}
		return instance;
	}

	@Override
	public void addEvents(Events events) {
		log.debug("add Events");
		getHibernateTemplate().save(events);
	}
	@Override
	public List<Events> findAll() {
		try {
			log.debug("find all");
			String query = "from Events order by id desc";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug("not find");
			throw e;
		}
	}
	@Override
	public List<Events> findAll(Long id) {
		try {
			log.debug("find all");
			String query = "from Events where id="+id;
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug("not find");
			throw e;
		}
	}
	@Override
	public List<ListEventPojo> findEvent() {
		try {
			log.debug("find all");
			String query = "SELECT new plast.org.ua.upu.pojo.ListEventPojo( "+
			"e.id, "+
			"e.advertname, "+
			"e.advertnameeng, "+
			"e.datefromadvert, "+
			"e.datetoadvert, "+
			"e.registrdate, "+
			"e.venue, " +
			"e.hashid, " +
			"t.nametypeaction, "+
			"k.id, " +
			"k.firstname, "+
			"k.lastname, "+
			"s.id, "+
			"s.description, "+
			"r.id, "+ 
			"r.description, "+
			"e.goverfinan, "+ 
			"t.id, "+
			"l.id, "+
			"l.namelevel) "+
			"FROM Events e "+
			"LEFT JOIN e.typeaction t "+
			"LEFT JOIN e.komendant k "+
			"LEFT JOIN e.status s "+ 
			"LEFT JOIN e.statusreport r "+
			"LEFT JOIN e.levelaction l "+
			"order by e.datefromadvert desc";
			System.out.println("query = "+query);
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug("not find");
			throw e;
		}
	}
	@Override
	public List<Events> findAll(String hash) {
		try {
			log.debug("find all");
			String query = "from Events where hashid='"+hash+"'";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug("not find");
			throw e;
		}
	}
 public List<EventViewPojo> findViewEvent(Long id){
	 log.debug("find all");
	 try {
		 String query="SELECT new plast.org.ua.upu.pojo.EventViewPojo( "
		 		+ "e.id, "
		 		+ "e.advertname, "
		 		+ "e.datefromadvert, "
		 		+ "e.datetoadvert, "
		 		+ "t.nametypeaction, "
		 		+ "e.venue, "
		 		+ "k.lastname, "
		 		+ "k.firstname, "
		 		+ "o.nameorganizer, "
		 		+ "d.lastnamedoc, "
		 		+ "d.firstnamedoc, "
		 		+ "e.program, "
		 		+ "e.purpose, "
		 		+ "e.numbparticip, "
		 		+ "e.ageparticipfrom, "
		 		+ "e.ageparticipto, "
		 		+ "e.topicality, "
		 		+ "e.expectresult, "
		 		+ "e.sumparticip,"
		 		+ "e.otherinfo, "
		 		+ "s.id, "
		 		+ "e.goverfinan, "
		 		+ "l.namelevel "
		 		+ ") "
		 		+ "FROM Events e "
		 		+ "JOIN e.typeaction t "
		 		+ "JOIN e.komendant k "
		 		+ "JOIN e.organizer o "
		 		+ "LEFT JOIN e.levelaction l "
		 		+ "LEFT JOIN e.doctor d "
		 		+ "JOIN e.status s "
		 		+ "where e.id = "+id;
		 return getHibernateTemplate().find(query);
	}  catch (RuntimeException e) {
		log.debug("not find");
		throw e;
	}
 }
 public List<EventEditPojo> findEditEvent(Long id){
	 log.debug("find all");
	 try {
		 String query="SELECT new plast.org.ua.upu.pojo.EventEditPojo( "
		 		+ "e.id, "
		 		+ "e.advertname, "
		 		+ "e.datefromadvert, "
		 		+ "e.datetoadvert, "
		 		+ "t.id, "
		 		+ "e.venue, "
		 		+ "k.id, "
		 		+ "o.id, "
		 		+ "d.id, "
		 		+ "e.program, "
		 		+ "e.purpose, "
		 		+ "e.numbparticip, "
		 		+ "e.ageparticipfrom, "
		 		+ "e.ageparticipto, "
		 		+ "e.topicality, "
		 		+ "e.expectresult, "
		 		+ "e.sumparticip, "
		 		+ "e.otherinfo, "
		 		+ "e.goverfinan, "
		 		+ "l.id "
		 		+ ") "
		 		+ "FROM Events e "
		 		+ "JOIN e.typeaction t "
		 		+ "JOIN e.komendant k "
		 		+ "JOIN e.organizer o "
		 		+ "LEFT JOIN e.levelaction l "
		 		+ "LEFT JOIN e.doctor d "
		 		+ "where e.id = "+id;
		 System.out.println("editSql = "+query);
		 return getHibernateTemplate().find(query);
	}  catch (RuntimeException e) {
		log.debug("not find");
		throw e;
	}
 }
 public void updateEvent(Events events){
	 getHibernateTemplate().update(events);
 }
}
