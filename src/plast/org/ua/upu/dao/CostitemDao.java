package plast.org.ua.upu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.ICostitemDao;
import plast.org.ua.upu.table.Costitem;


public class CostitemDao extends HibernateDaoSupport implements ICostitemDao{
	private static final Log log = LogFactory.getLog(CostitemDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static ICostitemDao instance;
	
	public static ICostitemDao getInstance() {
		instance = (ICostitemDao)context.getBean("costitem");
		return instance;
	}
	@Override
	public void addCostitem(Costitem costitem) {
		log.debug("add cost item");
		getHibernateTemplate().save(costitem);
	}
	@Override
	public List<Costitem> findAll() {
		try {
			log.debug("find all");
			String query = "from Costitem order by namecostitem asc";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}
	@Override
	public List<Costitem> findAll(Long id) {
		try {
			log.debug("find all");
			String query = "from Costitem where id="+id;
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}
}
