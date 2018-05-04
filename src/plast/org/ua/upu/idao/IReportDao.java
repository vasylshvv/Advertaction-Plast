package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.table.Report;

public interface IReportDao {
	public void addReport(Report report);
	public List<Report> findReport(Long idEvent);
}
