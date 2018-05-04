package plast.org.ua.upu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.IStanystyaDao;
import plast.org.ua.upu.idao.IStatusReportDao;
import plast.org.ua.upu.table.Statusreport;

public class StatusReportDao extends HibernateDaoSupport implements IStatusReportDao{
	private static final Log log = LogFactory.getLog(StatusReportDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static IStatusReportDao instance;
	
	public static IStatusReportDao getInstance() {
		if(instance == null){
			instance = (IStatusReportDao)context.getBean("statusrep");
		}
		return instance;
	}
	@Override
	public void addStatusReport(Statusreport statusreport) {
		
		getHibernateTemplate().save(statusreport);
		
	}
	@Override
	public List<Statusreport> findAll() {
		try {
			log.debug("find all");
			String query = "from Statusreport";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug("not find");
			throw e;
		}
	}
	@Override
	public List<Statusreport> findAll(Long id) {
		try {
			log.debug("find all");
			String query = "from Statusreport where id="+id;
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug("not find");
			throw e;
		}
	}
	@Override
	public List<Statusreport> findAll(String statusname) {
		try {
			log.debug("find all");
			String query = "from Statusreport where description='"+statusname+"'";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug("not find");
			throw e;
		}
	}
}
