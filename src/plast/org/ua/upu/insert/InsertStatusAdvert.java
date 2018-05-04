package plast.org.ua.upu.insert;

import java.util.List;

import plast.org.ua.upu.dao.StatusAdvertDao;
import plast.org.ua.upu.idao.IStatusAdvertDao;
import plast.org.ua.upu.table.Statusadvert;

public class InsertStatusAdvert {
	private IStatusAdvertDao advertDao = StatusAdvertDao.getInstance();
	private List<Statusadvert> liststatus;
	private Statusadvert statusadvert;
	public void insert() {
		statusadvert = new Statusadvert();
		
		statusadvert.setDescription("Зголошенно");
		advertDao.addStatus(statusadvert);
		
		statusadvert.setDescription("Розглядається");
		advertDao.addStatus(statusadvert);
		
		statusadvert.setDescription("Дозволено");
		advertDao.addStatus(statusadvert);
		
		statusadvert.setDescription("Відхилено");
		advertDao.addStatus(statusadvert);
	}
	public int count(){
		liststatus = advertDao.findAll();
		int count = 0;
		for (Statusadvert statusadvert : liststatus) {
			count = (int)(long)statusadvert.getId();
		}
		return count;
	}
}
