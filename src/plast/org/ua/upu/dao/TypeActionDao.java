package plast.org.ua.upu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.ITypeActionDao;
import plast.org.ua.upu.table.TypeAction;

public class TypeActionDao extends HibernateDaoSupport implements ITypeActionDao{
	private static final Log log = LogFactory.getLog(TypeActionDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static ITypeActionDao instance;
	
	public static ITypeActionDao getInstance() {
		if(instance == null){
			instance = (ITypeActionDao)context.getBean("typeaction");
		}
		return instance;
	}

	@Override
	public void addTypeAction(TypeAction typeaction) {
		log.debug("add new type action");
		getHibernateTemplate().save(typeaction);
	}
	@Override
	public List<TypeAction> findAll() {
		try {
			log.debug("find all typeaction");
			String query = "from TypeAction order by nametypeaction asc";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.error("not find all", e);
			throw e;
		}
	}
	@Override
	public List<TypeAction> findAll(long id) {
		try {
			log.debug("find all typeaction");
			String query = "from TypeAction where id="+id;
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.error("not find all", e);
			throw e;
		}
	}
}
