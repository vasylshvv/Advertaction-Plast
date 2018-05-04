package plast.org.ua.upu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.ILeaderShipDao;
import plast.org.ua.upu.table.LeaderShip;

public class LeaderShipDao extends HibernateDaoSupport implements ILeaderShipDao{
	private static final Log log = LogFactory.getLog(LeaderShip.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static ILeaderShipDao instance;
	
	public static ILeaderShipDao getInstance() {
		if(instance == null){
			instance = (ILeaderShipDao)context.getBean("leader");
		}
		return instance;
	}
	@Override
	public void addNameLeader(LeaderShip leaderShip) {
		
		log.debug("add nameprovid");
		getHibernateTemplate().save(leaderShip);
	}
	@Override
	public List<LeaderShip> findAllLeader() {
		try {
			log.debug("find all namelider");
			String quary = "from LeaderShip order by namelider asc";
			return getHibernateTemplate().find(quary);
		} catch (RuntimeException e) {
			log.error("not find all", e);
			throw e;
		}
	}
	public List<LeaderShip> findAllLeader(Long id) {
		try {
			log.debug("find all namelider");
			String quary = "from LeaderShip where id = "+id;
			return getHibernateTemplate().find(quary);
		} catch (RuntimeException e) {
			log.error("not find all", e);
			throw e;
		}
	}
}
