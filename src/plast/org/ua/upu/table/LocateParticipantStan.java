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
@Table(name = "locateparticipantstan")
public class LocateParticipantStan {
	private Long id;
	private Integer countparticipant;
	private Stanytsya stanytsya;
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
	@Column(name = "countparticipant")
	public Integer getCountparticipant() {
		return countparticipant;
	}
	public void setCountparticipant(Integer countparticipant) {
		this.countparticipant = countparticipant;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "stanytsyaid")
	public Stanytsya getStanytsya() {
		return stanytsya;
	}
	public void setStanytsya(Stanytsya stanytsya) {
		this.stanytsya = stanytsya;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "reportid")
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	public LocateParticipantStan(Long id, Integer countparticipant, Stanytsya stanytsya, Report report) {
		super();
		this.id = id;
		this.countparticipant = countparticipant;
		this.stanytsya = stanytsya;
		this.report = report;
	}
	public LocateParticipantStan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
