package plast.org.ua.upu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.IRecommendationDao;
import plast.org.ua.upu.table.Recommendation;

public class RecommendationDao extends HibernateDaoSupport implements IRecommendationDao{
	private static final Log log = LogFactory.getLog(RecommendationDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static IRecommendationDao instance;
	
	public static IRecommendationDao getInstance() {
		if(instance == null){
			instance = (IRecommendationDao)context.getBean("recomend");
		}
		return instance;
	}
	@Override
	public List<Recommendation> findAll() {
		try {
			log.debug("find all");
			String query = "from Recommendation";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	@Override
	public List<Recommendation> findAll(Long idevent) {
		try {
			log.debug("find all");
			String query = "from Recommendation where eventsid="+idevent;
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	@Override
	public void saveRecommend(Recommendation recommendation) {
		log.debug("add recommandation");
		getHibernateTemplate().save(recommendation);
	}
}
