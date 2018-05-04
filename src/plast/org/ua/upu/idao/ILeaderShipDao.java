package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.table.LeaderShip;

public interface ILeaderShipDao {
	public void addNameLeader(LeaderShip leaderShip);
	public List<LeaderShip> findAllLeader();
	public List<LeaderShip> findAllLeader(Long id);
}
