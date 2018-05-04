package plast.org.ua.upu.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import plast.org.ua.upu.idao.IPhotosEventReportDao;
import plast.org.ua.upu.idao.IStupinDao;
import plast.org.ua.upu.table.PhotosEventReport;

public class PhotosEventReportDao extends HibernateDaoSupport implements IPhotosEventReportDao{
	private static final Log log = LogFactory.getLog(PhotosEventReportDao.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static IPhotosEventReportDao instance;
	
	public static IPhotosEventReportDao getInstance() {
		if(instance == null){
			instance = (IPhotosEventReportDao)context.getBean("photos");
		}
		return instance;
	}
	@Override
	public void addPhotosEvent(PhotosEventReport photosEventReport) {
		getHibernateTemplate().save(photosEventReport);		
	}
}
