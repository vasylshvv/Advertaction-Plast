package plast.org.ua.upu.controller.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import plast.org.ua.upu.dao.ReportDao;
import plast.org.ua.upu.idao.IReportDao;
import plast.org.ua.upu.table.Report;

public class CheckReportController implements Controller{
	private List<Report> listReport;
	private IReportDao reportDao = ReportDao.getInstance();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = null;
			String idevnetStr = request.getParameter("idevent");
			System.out.println("idevnetStr = "+idevnetStr);
			listReport = reportDao.findReport(Long.parseLong(idevnetStr));
			int size = listReport.size();
			response.getWriter().println(size);
			response.getWriter().flush();
			response.getWriter().close();
		return modelAndView;
	}
}
