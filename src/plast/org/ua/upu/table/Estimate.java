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
@Table(name = "estimate")
public class Estimate {
	private Long id;
	private Costitem costitem;
	private Integer sumparticipant;
	private Integer sumplast;
	private Integer sumbudget;
	private Integer sumsponsor;
	private Integer sumother;
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
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "costitemid")
	public Costitem getCostitem() {
		return costitem;
	}
	public void setCostitem(Costitem costitem) {
		this.costitem = costitem;
	}
	@Column(name = "sumparticipant")
	public Integer getSumparticipant() {
		return sumparticipant;
	}
	public void setSumparticipant(Integer sumparticipant) {
		this.sumparticipant = sumparticipant;
	}
	@Column(name = "sumplast")
	public Integer getSumplast() {
		return sumplast;
	}
	public void setSumplast(Integer sumplast) {
		this.sumplast = sumplast;
	}
	@Column(name = "sumbudget")
	public Integer getSumbudget() {
		return sumbudget;
	}
	public void setSumbudget(Integer sumbudget) {
		this.sumbudget = sumbudget;
	}
	@Column(name = "sumsponsor")
	public Integer getSumsponsor() {
		return sumsponsor;
	}
	public void setSumsponsor(Integer sumsponsor) {
		this.sumsponsor = sumsponsor;
	}
	@Column(name = "sumother")
	public Integer getSumother() {
		return sumother;
	}
	public void setSumother(Integer sumother) {
		this.sumother = sumother;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "eventsid")
	public Events getEvents() {
		return events;
	}
	public void setEvents(Events events) {
		this.events = events;
	}
	public Estimate(Long id, Costitem costitem, Integer sumparticipant,
			Integer sumplast, Integer sumbudget, Integer sumsponsor,
			Integer sumother, Events events) {
		super();
		this.id = id;
		this.costitem = costitem;
		this.sumparticipant = sumparticipant;
		this.sumplast = sumplast;
		this.sumbudget = sumbudget;
		this.sumsponsor = sumsponsor;
		this.sumother = sumother;
		this.events = events;
	}
	public Estimate() {
		super();
		// TODO Auto-generated constructor stub
	}

}
