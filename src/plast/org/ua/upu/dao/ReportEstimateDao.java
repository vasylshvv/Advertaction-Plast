package plast.org.ua.upu.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.ILeaderShipDao;
import plast.org.ua.upu.idao.IReportEstimateDao;
import plast.org.ua.upu.table.LeaderShip;
import plast.org.ua.upu.table.ReportEstimate;

public class ReportEstimateDao extends HibernateDaoSupport implements IReportEstimateDao{
	private static final Log log = LogFactory.getLog(ReportEstimateDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static ReportEstimateDao instance;
	
	public static ReportEstimateDao getInstance() {
		if(instance == null){
			instance = (ReportEstimateDao)context.getBean("reportestim");
		}
		return instance;
	}
	@Override
	public void addEstimateReport(ReportEstimate reportEstimate) {
		log.debug("add reportestimate");
		getHibernateTemplate().save(reportEstimate);
	}
}
