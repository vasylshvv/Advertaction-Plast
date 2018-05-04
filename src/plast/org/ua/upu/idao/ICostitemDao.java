package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.table.Costitem;

public interface ICostitemDao {
	public void addCostitem(Costitem costitem);
	public List<Costitem> findAll(Long id);
	public List<Costitem> findAll();
}
