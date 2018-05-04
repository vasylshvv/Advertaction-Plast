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
@Table(name = "recommendation")
public class Recommendation {
	private Long id;
	private Date registrDate;
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
	@Column(name = "registrdate")
	public Date getRegistrDate() {
		return registrDate;
	}
	public void setRegistrDate(Date registrDate) {
		this.registrDate = registrDate;
	}
	@Column(name = "description", length = 500)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "eventsid")
	public Events getEvents() {
		return events;
	}
	public void setEvents(Events events) {
		this.events = events;
	}
	public Recommendation(Long id, Date registrDate, String description,
			Events events) {
		super();
		this.id = id;
		this.registrDate = registrDate;
		this.description = description;
		this.events = events;
	}
	public Recommendation() {
		super();
		// TODO Auto-generated constructor stub
	}

}
