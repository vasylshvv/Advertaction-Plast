package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.pojo.EstimateEditPojo;
import plast.org.ua.upu.pojo.EstimateViewPojo;
import plast.org.ua.upu.table.Estimate;

public interface IEstimateDao {
	public void addEstimate(Estimate estimate);
	public List<Estimate> findAll();
	public List<Estimate> findEstimate(Long id);
	public List<EstimateEditPojo> findAllEstEvent(Long id);
	public List<EstimateViewPojo> findAllEstEventView(Long id);
	public void updateEstimate(Estimate estimate);
}
