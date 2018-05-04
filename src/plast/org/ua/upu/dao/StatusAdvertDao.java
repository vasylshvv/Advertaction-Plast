package plast.org.ua.upu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.IStatusAdvertDao;
import plast.org.ua.upu.table.Statusadvert;

public class StatusAdvertDao extends HibernateDaoSupport implements IStatusAdvertDao{
	private static final Log log = LogFactory.getLog(StatusAdvertDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static IStatusAdvertDao instance;
	
	public static IStatusAdvertDao getInstance() {
		if(instance == null){
			instance = (IStatusAdvertDao)context.getBean("statusadv");
		}
		return instance;
	}
	@Override
	public void addStatus(Statusadvert status) {
		log.debug("add new status");
		getHibernateTemplate().save(status);
	}
	@Override
	public List<Statusadvert> findAll() {
		try {
			log.debug("find all");
			String query = "from Statusadvert";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug("not find");
			throw e;
		}
	}
	@Override
	public List<Statusadvert> findAll(Long id) {
		try {
			log.debug("find all");
			String query = "from Statusadvert where id="+id;
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug("not find");
			throw e;
		}
	}
}
