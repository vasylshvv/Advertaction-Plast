package plast.org.ua.upu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.ITypeDoctorDao;
import plast.org.ua.upu.table.TypeDoctor;


public class TypeDoctorDao extends HibernateDaoSupport implements ITypeDoctorDao{
	private static final Log log = LogFactory.getLog(TypeDoctorDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static ITypeDoctorDao instance;
	
	public static ITypeDoctorDao getInstance() {
		if(instance == null){
			instance = (ITypeDoctorDao)context.getBean("typedoc");
		}
		return instance;
	}
	@Override
	public void addType(TypeDoctor typedoctor) {
		log.debug("add typedoc");
		getHibernateTemplate().save(typedoctor);
	}
	public List<TypeDoctor> findAll() {
		try {
			log.debug("find all");
			String query = "from TypeDoctor";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}
	@Override
	public List<TypeDoctor> findDoc(Long id) {
		try {
			log.debug("find all");
			String query = "from TypeDoctor where id="+id;
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}
}
