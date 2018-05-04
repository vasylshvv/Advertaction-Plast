package plast.org.ua.upu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.IDoctorDao;
import plast.org.ua.upu.table.Doctor;

public class DoctorDao extends HibernateDaoSupport implements IDoctorDao {
	private static final Log log = LogFactory.getLog(DoctorDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static IDoctorDao instance;

	public static IDoctorDao getInstance() {
		instance = (IDoctorDao) context.getBean("doctor");
		return instance;
	}

	@Override
	public void addDoctor(Doctor doctor) {
		log.debug("add doctro");
		getHibernateTemplate().save(doctor);
	}

	@Override
	public List<Doctor> findAll() {
		try {
			log.debug("find all");
			String query = "from Doctor order by lastnamedoc asc";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}
	@Override
	public List<Doctor> findAll(long id) {
		try {
			log.debug("find all");
			String query = "from Doctor where id="+id+" order by lastnamedoc asc";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			log.debug(e);
			throw e;
		}
	}
}
