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
@Table(name = "reportestimate")
public class ReportEstimate {
	private Long id;
	private Integer sumbudget;
	private Integer sumother;
	private Integer sumparticipant;
	private Integer sumplast;
	private Integer sumsponsor;
	private Costitem costitem;
	private Report report;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "sumbudget")
	public Integer getSumbudget() {
		return sumbudget;
	}
	public void setSumbudget(Integer sumbudget) {
		this.sumbudget = sumbudget;
	}
	@Column(name = "sumother")
	public Integer getSumother() {
		return sumother;
	}
	public void setSumother(Integer sumother) {
		this.sumother = sumother;
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
	@Column(name = "sumsponsor")
	public Integer getSumsponsor() {
		return sumsponsor;
	}
	public void setSumsponsor(Integer sumsponsor) {
		this.sumsponsor = sumsponsor;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "costitemid")
	public Costitem getCostitem() {
		return costitem;
	}
	public void setCostitem(Costitem costitem) {
		this.costitem = costitem;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "reportid")
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	public ReportEstimate(Long id, Integer sumbudget, Integer sumother, Integer sumparticipant, Integer sumplast,
			Integer sumsponsor, Costitem costitem, Report report) {
		super();
		this.id = id;
		this.sumbudget = sumbudget;
		this.sumother = sumother;
		this.sumparticipant = sumparticipant;
		this.sumplast = sumplast;
		this.sumsponsor = sumsponsor;
		this.costitem = costitem;
		this.report = report;
	}
	public ReportEstimate() {
		super();
		// TODO Auto-generated constructor stub
	}

}
