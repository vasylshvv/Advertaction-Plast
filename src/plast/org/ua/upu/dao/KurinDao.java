package plast.org.ua.upu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.IKurinDao;
import plast.org.ua.upu.table.Kurin;

public class KurinDao extends HibernateDaoSupport implements IKurinDao{
	private static final Log log = LogFactory.getLog(KurinDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static IKurinDao instance;
	public static IKurinDao getInstance() {
		if(instance == null){
			instance = (IKurinDao)context.getBean("kurin");
		}
		return instance;
	}
	@Override
	public void addKurin(Kurin kurin) {
		log.debug("add kurin");
		getHibernateTemplate().save(kurin);
	}
	@Override
	public List<Kurin> findAll() {
		try {
			log.debug("find all kurin");
			String qury = "from Kurin order by namekurin asc";
			return getHibernateTemplate().find(qury);
		} catch (RuntimeException e) {
			log.error("not find all", e);
			throw e;
		}
	}
	@Override
	public List<Kurin> findKurin(Long id) {
		try {
			log.debug("find all kurin");
			String qury = "from Kurin where id="+id;
			return getHibernateTemplate().find(qury);
		} catch (RuntimeException e) {
			log.error("not find all", e);
			throw e;
		}
	}
}
