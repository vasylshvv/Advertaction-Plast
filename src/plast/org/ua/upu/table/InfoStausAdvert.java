package plast.org.ua.upu.table;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "infostatusadvert")
public class InfoStausAdvert {
	private Long id;
	private Date dateinfo;
	private String description;
	private Events events;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "dateinfo")
	public Date getDateinfo() {
		return dateinfo;
	}
	public void setDateinfo(Date dateinfo) {
		this.dateinfo = dateinfo;
	}
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idevents")
	public Events getEvents() {
		return events;
	}
	public void setEvents(Events events) {
		this.events = events;
	}
	public InfoStausAdvert(Long id, Date dateinfo, String description,
			Events events) {
		super();
		this.id = id;
		this.dateinfo = dateinfo;
		this.description = description;
		this.events = events;
	}
	public InfoStausAdvert() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
