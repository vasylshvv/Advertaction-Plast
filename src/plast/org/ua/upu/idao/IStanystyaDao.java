package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.table.Stanytsya;

public interface IStanystyaDao {
	public void addStan(Stanytsya stanytsya);
	public List<Stanytsya> findAll();
	public List<Stanytsya> findStanytsya(Long id);
}
