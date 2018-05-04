package plast.org.ua.upu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.IVyshkilDao;
import plast.org.ua.upu.table.Vyshkil;


public class VyshkilDao extends HibernateDaoSupport implements IVyshkilDao{
	private static final Log log = LogFactory.getLog(VyshkilDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static IVyshkilDao instance;
	
	public static IVyshkilDao getInstance() {
		if(instance == null){
			instance = (IVyshkilDao)context.getBean("vyshkil");
		}
		return instance;
	}
	@Override
	public void addVyshkil(Vyshkil vyshkil) {
		log.debug("add all");
		getHibernateTemplate().save(vyshkil);
		
	}
	@Override
	public List<Vyshkil> findAll() {
		try {
			log.debug("find all");
			String query = "from Vyshkil";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.error("not find all", e);
			throw e;
		}
	}
	@Override
	public List<Vyshkil> findVyshkil(Long id) {
		try {
			log.debug("find all");
			String query = "from Vyshkil where id="+id;
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.error("not find all", e);
			throw e;
		}
	}
}
