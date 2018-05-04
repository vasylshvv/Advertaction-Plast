package plast.org.ua.upu.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.IKomendantDao;
import plast.org.ua.upu.pojo.InfoKomendantPojo;
import plast.org.ua.upu.table.Komendant;


public class KomendantDao extends HibernateDaoSupport implements IKomendantDao{
	private static final Log log = LogFactory.getLog(KomendantDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static IKomendantDao instance;
	
	public static IKomendantDao getInstance() {
		if(instance == null){
			instance = (IKomendantDao)context.getBean("komend");
		}
		return instance;
	}
	@Override
	public void addKomendant(Komendant komendant) {
		log.debug("add komendant");
		getHibernateTemplate().save(komendant);
		
	}
	@Override
	public List<Komendant> findAll() {
		try {
			log.debug("find all");
			String query = "from Komendant order by lastname asc";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}
	public List<Komendant> findAll(long id) {
		try {
			log.debug("find all");
			String query = "from Komendant where id ="+id+" order by lastname asc";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}
	@Override
	public List<InfoKomendantPojo> findInfoKomend(long id) {
		try {
			log.debug("find all");
			String query = "SELECT new plast.org.ua.upu.pojo.InfoKomendantPojo( "+
			"k.id, "+
			"k.firstname, "+
			"k.lastname, "+
			"k.birthday, "+
			"s.shortname, "+
			"st.namestan, "+
			"kr.namekurin, "+
			"v.name, "+
			"kv.name, "+
			"k.cellnumber, "+
			"k.email) "+
			"FROM Komendant k "+
			"JOIN k.stupin s "+
			"JOIN k.stanytsya st "+
			"LEFT JOIN k.kurin kr "+
			"LEFT JOIN k.vyshkil v "+
			"LEFT JOIN k.kv kv "+
			"where k.id = "+id;
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}
}
