package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.table.Recommendation;

public interface IRecommendationDao {
	public void saveRecommend(Recommendation recommendation);
	public List<Recommendation> findAll();
	public List<Recommendation> findAll(Long idevent);
}
