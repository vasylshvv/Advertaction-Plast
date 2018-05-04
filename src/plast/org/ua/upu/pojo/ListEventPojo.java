package plast.org.ua.upu.pojo;

import java.util.Date;

public class ListEventPojo {
	private Long id;
	private String advertname;
	private String advertnameeng;
	private Date datefromadvert;
	private Date datetoadvert;
	private Date registrdate;
	private String venue;
	private String hashid;
	private String nametypeaction;
	private Long idkomendant;
	private String firstnamekomendant;
	private String lastnamekomendant;
	private Long idstatus;
	private String status;
	private Long idstatusreport;
	private String statusreport;
	private Integer goverfinan;
	private Long idtypeaction;
	private Long idlevelaction;
	private String namelevelaction;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdvertname() {
		return advertname;
	}
	public void setAdvertname(String advertname) {
		this.advertname = advertname;
	}
	public Date getDatefromadvert() {
		return datefromadvert;
	}
	public void setDatefromadvert(Date datefromadvert) {
		this.datefromadvert = datefromadvert;
	}
	public Date getDatetoadvert() {
		return datetoadvert;
	}
	public void setDatetoadvert(Date datetoadvert) {
		this.datetoadvert = datetoadvert;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getHashid() {
		return hashid;
	}
	public void setHashid(String hashid) {
		this.hashid = hashid;
	}
	
	public String getNametypeaction() {
		return nametypeaction;
	}
	public void setNametypeaction(String nametypeaction) {
		this.nametypeaction = nametypeaction;
	}
	public Long getIdkomendant() {
		return idkomendant;
	}
	public void setIdkomendant(Long idkomendant) {
		this.idkomendant = idkomendant;
	}
	public String getFirstnamekomendant() {
		return firstnamekomendant;
	}
	public void setFirstnamekomendant(String firstnamekomendant) {
		this.firstnamekomendant = firstnamekomendant;
	}
	public String getLastnamekomendant() {
		return lastnamekomendant;
	}
	public void setLastnamekomendant(String lastnamekomendant) {
		this.lastnamekomendant = lastnamekomendant;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getIdstatus() {
		return idstatus;
	}
	public void setIdstatus(Long idstatus) {
		this.idstatus = idstatus;
	}
	public Date getRegistrdate() {
		return registrdate;
	}
	public void setRegistrdate(Date registrdate) {
		this.registrdate = registrdate;
	}

	
	
	public String getAdvertnameeng() {
		return advertnameeng;
	}
	public void setAdvertnameeng(String advertnameeng) {
		this.advertnameeng = advertnameeng;
	}
	
	
	public Long getIdstatusreport() {
		return idstatusreport;
	}
	public void setIdstatusreport(Long idstatusreport) {
		this.idstatusreport = idstatusreport;
	}
	public String getStatusreport() {
		return statusreport;
	}
	public void setStatusreport(String statusreport) {
		this.statusreport = statusreport;
	}
	
	public Integer getGoverfinan() {
		return goverfinan;
	}
	public void setGoverfinan(Integer goverfinan) {
		this.goverfinan = goverfinan;
	}
	
	public Long getIdtypeaction() {
		return idtypeaction;
	}
	public void setIdtypeaction(Long idtypeaction) {
		this.idtypeaction = idtypeaction;
	}
	public Long getIdlevelaction() {
		return idlevelaction;
	}
	public void setIdlevelaction(Long idlevelaction) {
		this.idlevelaction = idlevelaction;
	}
	public String getNamelevelaction() {
		return namelevelaction;
	}
	public void setNamelevelaction(String namelevelaction) {
		this.namelevelaction = namelevelaction;
	}
	public ListEventPojo(Long id, String advertname, String advertnameeng, Date datefromadvert, Date datetoadvert,
			Date registrdate, String venue, String hashid, String nametypeaction, Long idkomendant,
			String firstnamekomendant, String lastnamekomendant, Long idstatus, String status, Long idstatusreport,
			String statusreport, Integer goverfinan, Long idtypeaction, Long idlevelaction, String namelevelaction) {
		super();
		this.id = id;
		this.advertname = advertname;
		this.advertnameeng = advertnameeng;
		this.datefromadvert = datefromadvert;
		this.datetoadvert = datetoadvert;
		this.registrdate = registrdate;
		this.venue = venue;
		this.hashid = hashid;
		this.nametypeaction = nametypeaction;
		this.idkomendant = idkomendant;
		this.firstnamekomendant = firstnamekomendant;
		this.lastnamekomendant = lastnamekomendant;
		this.idstatus = idstatus;
		this.status = status;
		this.idstatusreport = idstatusreport;
		this.statusreport = statusreport;
		this.goverfinan = goverfinan;
		this.idtypeaction = idtypeaction;
		this.idlevelaction = idlevelaction;
		this.namelevelaction = namelevelaction;
	}
	public ListEventPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
