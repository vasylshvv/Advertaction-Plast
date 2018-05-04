package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.table.Kurin;

public interface IKurinDao {
	public void addKurin(Kurin kurin);
	public List<Kurin> findAll();
	public List<Kurin> findKurin(Long id);
}
