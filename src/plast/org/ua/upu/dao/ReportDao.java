package plast.org.ua.upu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.IEventsDao;
import plast.org.ua.upu.idao.IReportDao;
import plast.org.ua.upu.table.Report;

public class ReportDao extends HibernateDaoSupport implements IReportDao{
	private static final Log log = LogFactory.getLog(ReportDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static IReportDao instance;
	
	public static IReportDao getInstance() {
		if(instance == null){
			instance = (IReportDao)context.getBean("report");
		}
		return instance;
	}

	@Override
	public void addReport(Report report) {
		log.debug("add new report");
		getHibernateTemplate().save(report);
		
	}
	@Override
	public List<Report> findReport(Long idEvent) {
		try {
			log.debug("find report for  id event");
			String query = "from Report r where r.events.id="+idEvent;
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
