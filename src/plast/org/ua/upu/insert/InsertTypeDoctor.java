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
		typedoc.setNametypedoctor("������� ������� �����");
		typedao.addType(typedoc);
		
		typedoc.setNametypedoctor("���������");
		typedao.addType(typedoc);
		
		typedoc.setNametypedoctor("˳���");
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
