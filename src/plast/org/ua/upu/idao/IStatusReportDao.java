package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.table.Statusreport;

public interface IStatusReportDao {
	public void addStatusReport(Statusreport statusreport);
	public List<Statusreport> findAll();
	public List<Statusreport> findAll(Long id);
	public List<Statusreport> findAll(String statusname);
}
