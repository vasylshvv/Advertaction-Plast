package plast.org.ua.upu.insert;

import java.util.List;

import plast.org.ua.upu.dao.StupinDao;
import plast.org.ua.upu.idao.IStupinDao;
import plast.org.ua.upu.table.Stupin;

public class InsertStupin {
	private IStupinDao stupindao = StupinDao.getInstance();
	private Stupin stupin;
	private List<Stupin> liststupin;
	public void insert(){
		stupin = new Stupin();
		stupin.setShortname("��.��.����.");
		stupin.setLongname("������������� ����������");
		stupindao.addStupin(stupin);
		
		stupin.setShortname("��.��.");
		stupin.setLongname("������ �������");
		stupindao.addStupin(stupin);
		
		stupin.setShortname("��.��.����/���.");
		stupin.setLongname("������ ������� ����/���");
		stupindao.addStupin(stupin);
		
		stupin.setShortname("��.��.�����.����/���.");
		stupin.setLongname("������ ������� ������������ ����/������");
		stupindao.addStupin(stupin);
		
		stupin.setShortname("��.���.����.");
		stupin.setLongname("������� ����� ����������");
		stupindao.addStupin(stupin);
		
		stupin.setShortname("��.���.");
		stupin.setLongname("������� �����");
		stupindao.addStupin(stupin);
	}
	public int count() {
		liststupin = stupindao.findAll();
		int count = 0;
		for (Stupin stupin : liststupin) {
			count = (int)(long)stupin.getId();
		}
		return count;
	}
}
