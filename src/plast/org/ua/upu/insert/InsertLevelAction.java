package plast.org.ua.upu.insert;

import java.util.List;

import plast.org.ua.upu.dao.LevelActionDao;
import plast.org.ua.upu.idao.ILevelActionDao;
import plast.org.ua.upu.table.LevelAction;

public class InsertLevelAction {
	private ILevelActionDao levelActionDao = LevelActionDao.getInstance();
	
	private LevelAction levelAction;
	private List<LevelAction> listLevelAction;
	public void insert(){
		levelAction = new LevelAction();
		levelAction.setNamelevel("��������");
		levelActionDao.addLevelAction(levelAction);
		
		levelAction.setNamelevel("��������");
		levelActionDao.addLevelAction(levelAction);
		
		levelAction.setNamelevel("̳���������");
		levelActionDao.addLevelAction(levelAction);
		
		levelAction.setNamelevel("���������");
		levelActionDao.addLevelAction(levelAction);
		
		levelAction.setNamelevel("̳����������");
		levelActionDao.addLevelAction(levelAction);
	}
	public int count(){
		listLevelAction = levelActionDao.findAllLevelAction();
		int count = 0;
		for (LevelAction la : listLevelAction) {
			count = (int)(long)la.getId();
		}
		return count;
	}
}
