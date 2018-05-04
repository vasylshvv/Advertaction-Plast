package plast.org.ua.upu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.IStupinDao;
import plast.org.ua.upu.table.Stupin;


public class StupinDao extends HibernateDaoSupport implements IStupinDao{
	private static final Log log = LogFactory.getLog(StanytsyaDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static IStupinDao instance;
	
	public static IStupinDao getInstance() {
		if(instance == null){
			instance = (IStupinDao)context.getBean("stupin");
		}
		return instance;
	}
	@Override
	public void addStupin(Stupin stupin) {
		log.debug("add stupin");
		getHibernateTemplate().save(stupin);
	}
	@Override
	public List<Stupin> findAll() {
		try {
			log.debug("find all");
			String query = "from Stupin";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}
	@Override
	public List<Stupin> findKomendant(Long id) {
		try {
			log.debug("find all");
			String query = "from Stupin where id="+id;
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}
}
