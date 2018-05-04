package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.table.TypeAction;

public interface ITypeActionDao {
	public void addTypeAction(TypeAction typeaction);
	public List<TypeAction> findAll();
	public List<TypeAction> findAll(long id);
}
