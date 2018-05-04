package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.pojo.EventEditPojo;
import plast.org.ua.upu.pojo.EventViewPojo;
import plast.org.ua.upu.pojo.ListEventPojo;
import plast.org.ua.upu.table.Events;

public interface IEventsDao {
	public void addEvents(Events events);
	public List<Events> findAll();
	public List<Events> findAll(String hash);
	public List<ListEventPojo> findEvent();
	public List<EventViewPojo> findViewEvent(Long id);
	public List<EventEditPojo> findEditEvent(Long id);
	public List<Events> findAll(Long id);
	public void updateEvent(Events events);
}
