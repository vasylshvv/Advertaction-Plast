package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.table.TypeDoctor;

public interface ITypeDoctorDao {
	public void addType(TypeDoctor typedoctor);
	public List<TypeDoctor> findAll(); 
	public List<TypeDoctor> findDoc(Long id);
}
