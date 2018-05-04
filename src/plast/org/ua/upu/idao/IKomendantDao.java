package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.pojo.InfoKomendantPojo;
import plast.org.ua.upu.table.Komendant;

public interface IKomendantDao {
	public void addKomendant(Komendant komendant);
	public List<Komendant> findAll();
	public List<Komendant> findAll(long id);
	public List<InfoKomendantPojo> findInfoKomend(long id);
}
