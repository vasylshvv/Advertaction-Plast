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
@Table(name ="events")
public class Events {
	private Long id;
	private String advertname;
	private String advertnameeng;
	private Date datefromadvert;
	private Date datetoadvert;
	private TypeAction typeaction;
	private String venue;
	private Komendant komendant;
	private Organizer organizer;
	private Doctor doctor;
	private String program;
	private String purpose;
	private Integer numbparticip;
	private Integer ageparticipfrom;
	private Integer ageparticipto;
	private String topicality;
	private String expectresult;
	private Integer sumparticip;
	private String otherinfo;
	private Date registrdate;
	private Statusadvert status;
	private Statusreport statusreport;
	private String hashid;
	private LevelAction levelaction;
	private Integer goverfinan;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "advertname")
	public String getAdvertname() {
		return advertname;
	}
	public void setAdvertname(String advertname) {
		this.advertname = advertname;
	}
	@Column(name = "datefromadvert")
	public Date getDatefromadvert() {
		return datefromadvert;
	}
	public void setDatefromadvert(Date datefromadvert) {
		this.datefromadvert = datefromadvert;
	}
	@Column(name = "datetoadvert")
	public Date getDatetoadvert() {
		return datetoadvert;
	}
	public void setDatetoadvert(Date datetoadvert) {
		this.datetoadvert = datetoadvert;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="typeactionid")
	public TypeAction getTypeaction() {
		return typeaction;
	}
	public void setTypeaction(TypeAction typeaction) {
		this.typeaction = typeaction;
	}
	@Column(name = "venue")
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "komendantid")
	public Komendant getKomendant() {
		return komendant;
	}
	public void setKomendant(Komendant komendant) {
		this.komendant = komendant;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "organizerid")
	public Organizer getOrganizer() {
		return organizer;
	}
	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "doctorid")
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	@Column(name = "program", length = 17500)
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	@Column(name = "purpose", length = 17500)
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	@Column(name = "numbparticip")
	public Integer getNumbparticip() {
		return numbparticip;
	}
	public void setNumbparticip(Integer numbparticip) {
		this.numbparticip = numbparticip;
	}
	@Column(name = "ageparticipfrom")
	public Integer getAgeparticipfrom() {
		return ageparticipfrom;
	}
	public void setAgeparticipfrom(Integer ageparticipfrom) {
		this.ageparticipfrom = ageparticipfrom;
	}
	@Column(name = "ageparticipto")
	public Integer getAgeparticipto() {
		return ageparticipto;
	}
	public void setAgeparticipto(Integer ageparticipto) {
		this.ageparticipto = ageparticipto;
	}
	@Column(name = "topicality", length = 17500)
	public String getTopicality() {
		return topicality;
	}
	public void setTopicality(String topicality) {
		this.topicality = topicality;
	}
	@Column(name = "expectresult", length = 17500)
	public String getExpectresult() {
		return expectresult;
	}
	public void setExpectresult(String expectresult) {
		this.expectresult = expectresult;
	}
	@Column(name = "sumparticip")
	public Integer getSumparticip() {
		return sumparticip;
	}
	public void setSumparticip(Integer sumparticip) {
		this.sumparticip = sumparticip;
	}
	@Column(name = "otherinfo", length = 17500)
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	@Column(name = "registrdate")
	public Date getRegistrdate() {
		return registrdate;
	}
	public void setRegistrdate(Date registrdate) {
		this.registrdate = registrdate;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "statusid")
	public Statusadvert getStatus() {
		return status;
	}
	public void setStatus(Statusadvert status) {
		this.status = status;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "statusreportid")
	public Statusreport getStatusreport() {
		return statusreport;
	}
	public void setStatusreport(Statusreport statusreport) {
		this.statusreport = statusreport;
	}
	@Column(name = "hashid")
	public String getHashid() {
		return hashid;
	}
	
	public void setHashid(String hashid) {
		this.hashid = hashid;
	}
	@Column(name = "advertnameeng")
	public String getAdvertnameeng() {
		return advertnameeng;
	}
	public void setAdvertnameeng(String advertnameeng) {
		this.advertnameeng = advertnameeng;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "levelactionid")
	public LevelAction getLevelaction() {
		return levelaction;
	}
	public void setLevelaction(LevelAction levelaction) {
		this.levelaction = levelaction;
	}
	
	@Column(name = "goverfinan")
	public Integer getGoverfinan() {
		return goverfinan;
	}	
	public void setGoverfinan(Integer goverfinan) {
		this.goverfinan = goverfinan;
	}
	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Events(Long id, String advertname, String advertnameeng, Date datefromadvert, Date datetoadvert,
			TypeAction typeaction, String venue, Komendant komendant, Organizer organizer, Doctor doctor,
			String program, String purpose, Integer numbparticip, Integer ageparticipfrom, Integer ageparticipto,
			String topicality, String expectresult, Integer sumparticip, String otherinfo, Date registrdate,
			Statusadvert status, Statusreport statusreport, String hashid, LevelAction levelaction, Integer goverfinan) {
		super();
		this.id = id;
		this.advertname = advertname;
		this.advertnameeng = advertnameeng;
		this.datefromadvert = datefromadvert;
		this.datetoadvert = datetoadvert;
		this.typeaction = typeaction;
		this.venue = venue;
		this.komendant = komendant;
		this.organizer = organizer;
		this.doctor = doctor;
		this.program = program;
		this.purpose = purpose;
		this.numbparticip = numbparticip;
		this.ageparticipfrom = ageparticipfrom;
		this.ageparticipto = ageparticipto;
		this.topicality = topicality;
		this.expectresult = expectresult;
		this.sumparticip = sumparticip;
		this.otherinfo = otherinfo;
		this.registrdate = registrdate;
		this.status = status;
		this.statusreport = statusreport;
		this.hashid = hashid;
		this.levelaction = levelaction;
		this.goverfinan = goverfinan;
	}
	public Events(Long id) {
		super();
		this.id = id;
	}
	
}
