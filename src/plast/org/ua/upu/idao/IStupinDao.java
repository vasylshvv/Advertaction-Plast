package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.table.Stupin;

public interface IStupinDao {
	public void addStupin(Stupin stupin);
	public List<Stupin> findAll();
	public List<Stupin> findKomendant(Long id);
}
