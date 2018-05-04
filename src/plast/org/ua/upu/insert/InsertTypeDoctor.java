package plast.org.ua.upu.insert;

import java.util.List;

import plast.org.ua.upu.dao.TypeDoctorDao;
import plast.org.ua.upu.idao.ITypeDoctorDao;
import plast.org.ua.upu.table.TypeDoctor;

public class InsertTypeDoctor {
	private ITypeDoctorDao typedao = TypeDoctorDao.getInstance();
	private TypeDoctor typedoc;
	private List<TypeDoctor> listtypedoc;
	public void insert() {
		typedoc = new TypeDoctor();
		typedoc.setNametypedoctor("Студент старших курсів");
		typedao.addType(typedoc);
		
		typedoc.setNametypedoctor("Медсестра");
		typedao.addType(typedoc);
		
		typedoc.setNametypedoctor("Лікар");
		typedao.addType(typedoc);
	}
	public int count() {
		listtypedoc = typedao.findAll();
		int count = 0;
		for (TypeDoctor typeDoctor : listtypedoc) {
			count = (int)(long)typeDoctor.getId();
		}
		return count;
	}
}
