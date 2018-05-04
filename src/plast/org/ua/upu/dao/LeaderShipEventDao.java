package plast.org.ua.upu.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.ILeaderShipDao;
import plast.org.ua.upu.idao.ILeaderShipEventDao;
import plast.org.ua.upu.table.LeaderShip;
import plast.org.ua.upu.table.LeaderShipEvent;

public class LeaderShipEventDao extends HibernateDaoSupport implements ILeaderShipEventDao{
	private static final Log log = LogFactory.getLog(LeaderShipEventDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static ILeaderShipEventDao instance;
	
	public static ILeaderShipEventDao getInstance() {
		if(instance == null){
			instance = (ILeaderShipEventDao)context.getBean("leadshipevent");
		}
		return instance;
	}
	@Override
	public void addLeaderShipEvent(LeaderShipEvent leaderShipEvent) {
		log.debug("add leadershipevent");
		getHibernateTemplate().save(leaderShipEvent);
		
	}
}
