package plast.org.ua.upu.insert;

import java.util.List;

import plast.org.ua.upu.dao.StatusReportDao;
import plast.org.ua.upu.idao.IStatusReportDao;
import plast.org.ua.upu.table.Statusreport;

public class InsetrStatusReport {
	private IStatusReportDao statusReportDao = StatusReportDao.getInstance();
	private List<Statusreport> listStatusReport;
	private Statusreport statusreport;

	public void insert() {
		statusreport = new Statusreport();
		
		statusreport.setDescription("Не прозвітовано");
		statusReportDao.addStatusReport(statusreport);
		
		statusreport.setDescription("Прозвітовано");
		statusReportDao.addStatusReport(statusreport);
		
		statusreport.setDescription("Поправити звітування");
		statusReportDao.addStatusReport(statusreport);
	}
	
	public int count() {
		listStatusReport = statusReportDao.findAll();
		int count = 0;
		for (Statusreport statusreport : listStatusReport) {
			count = (int)(long)statusreport.getId();
		}
		return count;
	}
}
