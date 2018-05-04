package plast.org.ua.upu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.ILevelActionDao;
import plast.org.ua.upu.table.LevelAction;

public class LevelActionDao extends HibernateDaoSupport implements ILevelActionDao{
	private static final Log log = LogFactory.getLog(LevelActionDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static ILevelActionDao instance;
	
	public static ILevelActionDao getInstance() {
		if(instance == null){
			instance = (ILevelActionDao)context.getBean("lavelaction");
		}
		return instance;
	}

	@Override
	public void addLevelAction(LevelAction levelAction) {
		log.debug("add level action");
		getHibernateTemplate().save(levelAction);
	}
	@Override
	public List<LevelAction> findAllLevelAction() {
		try {
			log.debug("finad all LevelAction");
			String query = "from LevelAction";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}
	@Override
	public List<LevelAction> findOneLevelAction(Long id) {
		try {
			log.debug("finad all LevelAction");
			String query = "from LevelAction where id="+id;
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}

	
}
