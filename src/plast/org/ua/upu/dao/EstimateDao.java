package plast.org.ua.upu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.IEstimateDao;
import plast.org.ua.upu.pojo.EstimateEditPojo;
import plast.org.ua.upu.pojo.EstimateViewPojo;
import plast.org.ua.upu.table.Estimate;



public class EstimateDao extends HibernateDaoSupport implements IEstimateDao{
	private static final Log log = LogFactory.getLog(EstimateDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static IEstimateDao instance;
	
	public static IEstimateDao getInstance() {
		if(instance == null){
			instance = (IEstimateDao)context.getBean("estimate");
		}
		return instance;
	}

	@Override
	public void addEstimate(Estimate estimate) {
		log.debug("add estimate");
		getHibernateTemplate().save(estimate);
	}
	@Override
	public void updateEstimate(Estimate estimate) {
		log.debug("update estimate");
		try {
			getHibernateTemplate().update(estimate);
		} catch(Exception e) {
			System.out.println("EXCEPTION UPDATE");
			e.printStackTrace();
		}
	}
	@Override
	public List<Estimate> findAll() {
		try {
			log.debug("find all");
			String query = "from Estimate";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}
	@Override
	public List<Estimate> findEstimate(Long id) {
		try {
			log.debug("find all");
			String query = "from Estimate where eventsid="+id;
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}
	public List<EstimateEditPojo> findAllEstEvent(Long id){
		log.debug("find all");
		 try {
			 String query="SELECT new plast.org.ua.upu.pojo.EstimateEditPojo( "
			 		+ "es.id, "
			 		+ "es.sumbudget, "
			 		+ "es.sumother, "
			 		+ "es.sumparticipant, "
			 		+ "es.sumplast, "
			 		+ "es.sumsponsor, "
			 		+ "e.id, "
			 		+ "c.id "			 		
			 		+ ")"
			 		+ "FROM Estimate es "
			 		+ "JOIN es.events e "
			 		+ "JOIN es.costitem c "
			 		+ "where e.id = "+id;
			 return getHibernateTemplate().find(query);
		}  catch (RuntimeException e) {
			log.debug("not find");
			throw e;
		}
	}
	public List<EstimateViewPojo> findAllEstEventView(Long id){
		log.debug("find all");
		 try {
			 String query="SELECT new plast.org.ua.upu.pojo.EstimateViewPojo( "
			 		+ "es.id, "
			 		+ "es.sumbudget, "
			 		+ "es.sumother, "
			 		+ "es.sumparticipant, "
			 		+ "es.sumplast, "
			 		+ "es.sumsponsor, "
			 		+ "e.id, "
			 		+ "c.namecostitem "			 		
			 		+ ")"
			 		+ "FROM Estimate es "
			 		+ "JOIN es.events e "
			 		+ "JOIN es.costitem c "
			 		+ "where e.id = "+id;
			 return getHibernateTemplate().find(query);
		}  catch (RuntimeException e) {
			log.debug("not find");
			throw e;
		}
	}
}
