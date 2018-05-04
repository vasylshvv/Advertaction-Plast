package plast.org.ua.upu.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.ILeaderShipDao;
import plast.org.ua.upu.idao.ILocateParticipantStanDao;
import plast.org.ua.upu.table.LeaderShip;
import plast.org.ua.upu.table.LocateParticipantStan;

public class LocateParticipantStanDao extends HibernateDaoSupport implements ILocateParticipantStanDao{
	private static final Log log = LogFactory.getLog(LocateParticipantStanDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static ILocateParticipantStanDao instance;
	
	public static ILocateParticipantStanDao getInstance() {
		if(instance == null){
			instance = (ILocateParticipantStanDao)context.getBean("locparsta");
		}
		return instance;
	}

	@Override
	public void addLocatPartStan(LocateParticipantStan locateParticipantStan) {
		log.debug("add");
		getHibernateTemplate().save(locateParticipantStan);
		
	}
	
}
