package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.table.Statusadvert;

public interface IStatusAdvertDao {
	public void addStatus(Statusadvert status);
	public List<Statusadvert> findAll();
	public List<Statusadvert> findAll(Long id);
}
