package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.table.Vyshkil;

public interface IVyshkilDao {
	public void addVyshkil(Vyshkil vyshkil);
	public List<Vyshkil> findAll();
	public List<Vyshkil> findVyshkil(Long id);
}
