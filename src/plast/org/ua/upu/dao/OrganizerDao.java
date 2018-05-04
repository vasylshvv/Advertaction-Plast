package plast.org.ua.upu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.IOrganizerDao;
import plast.org.ua.upu.table.Organizer;


public class OrganizerDao extends HibernateDaoSupport implements IOrganizerDao{
	private static final Log log = LogFactory.getLog(OrganizerDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static IOrganizerDao instance;
	
	public static IOrganizerDao getInstance() {
		if(instance == null){
			instance = (IOrganizerDao)context.getBean("organ");
		}
		return instance;
	}
	@Override
	public void addOrganizer(Organizer organizer) {
		log.debug("add new organizer");
		getHibernateTemplate().save(organizer);
		
	}
	@Override
	public List<Organizer> findAll() {
		try {
			log.debug("find all");
			String query = "from Organizer order by nameorganizer asc";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}
	
	public List<Organizer> findAll(long id) {
		try {
			log.debug("find all");
			String query = "from Organizer where id="+id+" order by nameorganizer asc";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}
}
