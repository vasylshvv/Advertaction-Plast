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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "report")
public class Report {
	private Long id;
	private Integer countparticip;
	private String tasks;
	private String informmedia;
	private String recomendation;
	private String other;
	private String conclusion;
	private Events events;
	private Statusreport statusreport;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "countparticip")
	public Integer getCountparticip() {
		return countparticip;
	}

	public void setCountparticip(Integer countparticip) {
		this.countparticip = countparticip;
	}
	@Column(name = "tasks", length = 17500)
	public String getTasks() {
		return tasks;
	}

	public void setTasks(String tasks) {
		this.tasks = tasks;
	}
	@Column(name = "informmedia", length = 17500)
	public String getInformmedia() {
		return informmedia;
	}

	public void setInformmedia(String informmedia) {
		this.informmedia = informmedia;
	}
	@Column(name = "recomendation", length = 17500)
	public String getRecomendation() {
		return recomendation;
	}

	public void setRecomendation(String recomendation) {
		this.recomendation = recomendation;
	}
	@Column(name = "other", length = 17500)
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	@Column(name = "conclusion", length = 17500)
	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "eventsid")
	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "statusreportid")
	public Statusreport getStatusreport() {
		return statusreport;
	}

	public void setStatusreport(Statusreport statusreport) {
		this.statusreport = statusreport;
	}

	public Report(Long id, Integer countparticip, String tasks, String informmedia, String recomendation, String other,
			String conclusion, Events events, Statusreport statusreport) {
		super();
		this.id = id;
		this.countparticip = countparticip;
		this.tasks = tasks;
		this.informmedia = informmedia;
		this.recomendation = recomendation;
		this.other = other;
		this.conclusion = conclusion;
		this.events = events;
		this.statusreport = statusreport;
	}

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
