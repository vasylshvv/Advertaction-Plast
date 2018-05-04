package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.table.LevelAction;

public interface ILevelActionDao {
	public void addLevelAction(LevelAction levelAction);
	public List<LevelAction> findAllLevelAction();
	public List<LevelAction> findOneLevelAction(Long id);
}
