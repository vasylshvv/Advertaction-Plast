package plast.org.ua.upu.table;

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
@Table(name = "leadershipevent")
public class LeaderShipEvent {
	private Long id;
	private String firstname;
	private String lastname;
	private LeaderShip leadership;
	private Report report;
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
	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "leadershipid")
	public LeaderShip getLeaderShip() {
		return leadership;
	}
	public void setLeaderShip(LeaderShip leadership) {
		this.leadership = leadership;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "reportid")
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "eventsid")
	public Events getEvents() {
		return events;
	}
	public void setEvents(Events events) {
		this.events = events;
	}
	public LeaderShipEvent(Long id, String firstname, String lastname, LeaderShip leadership, Report report,
			Events events) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.leadership = leadership;
		this.report = report;
		this.events = events;
	}
	public LeaderShipEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}
