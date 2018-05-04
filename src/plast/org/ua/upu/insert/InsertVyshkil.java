package plast.org.ua.upu.insert;

import java.util.List;

import plast.org.ua.upu.dao.VyshkilDao;
import plast.org.ua.upu.idao.IVyshkilDao;
import plast.org.ua.upu.table.Vyshkil;

public class InsertVyshkil {
	private IVyshkilDao vyshkildao = VyshkilDao.getInstance();
	private Vyshkil vyshkil;
	private List<Vyshkil> listvyshkil;
	public void insert() {
		vyshkil = new Vyshkil();
		vyshkil.setName("������� ����� �������� ��");
		vyshkildao.addVyshkil(vyshkil);
		
		vyshkil.setName("������� ����� �������� ��");
		vyshkildao.addVyshkil(vyshkil);
		
		vyshkil.setName("������� ����� ��������� ��");
		vyshkildao.addVyshkil(vyshkil);
		
		vyshkil.setName("������� ����� ��������� ��");
		vyshkildao.addVyshkil(vyshkil);
		
		vyshkil.setName("���������� ��");
		vyshkildao.addVyshkil(vyshkil);
		
		vyshkil.setName("���������� ��");
		vyshkildao.addVyshkil(vyshkil);
		
		vyshkil.setName("����� ��");
		vyshkildao.addVyshkil(vyshkil);
		
		vyshkil.setName("����� ��");
		vyshkildao.addVyshkil(vyshkil);
		
	}
	public int count(){
		listvyshkil = vyshkildao.findAll();
		int count = 0;
		for (Vyshkil vyshkil : listvyshkil) {
			count = (int)(long)vyshkil.getId();
		}
		return count;
	}
}
