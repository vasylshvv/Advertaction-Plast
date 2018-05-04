package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.table.Organizer;

public interface IOrganizerDao {
	public void addOrganizer(Organizer organizer);
	public List<Organizer> findAll();
	public List<Organizer> findAll(long id);
}
