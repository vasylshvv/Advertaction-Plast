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
		stupin.setShortname("ст.пл.прих.");
		stupin.setLongname("старшопластун прихильник");
		stupindao.addStupin(stupin);
		
		stupin.setShortname("ст.пл.");
		stupin.setLongname("старшо пластун");
		stupindao.addStupin(stupin);
		
		stupin.setShortname("ст.пл.скоб/в≥рл.");
		stupin.setLongname("старшо пластун скоб/в≥рл");
		stupindao.addStupin(stupin);
		
		stupin.setShortname("ст.пл.гетьм.скоб/в≥рл.");
		stupin.setLongname("старшо пластун гетьманський скоб/в≥рлиц€");
		stupindao.addStupin(stupin);
		
		stupin.setShortname("пл.сен.прих.");
		stupin.setLongname("пластун сен≥ор прихильник");
		stupindao.addStupin(stupin);
		
		stupin.setShortname("пл.сен.");
		stupin.setLongname("пластун сен≥ор");
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
