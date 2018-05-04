package plast.org.ua.upu.pojo;

import java.util.Date;

public class EventViewPojo {
	private Long id; 
    private String advertname; 
    private Date datefromadvert; 
    private Date datetoadvert; 
    private String nametypeaction;
    private String venue;
    private String lastnamekom;
    private String firstnamekom;
    private String nameorganizer;
    private String lastnamedoc; 
    private String firstnamedoc;
    private String program;
    private String purpose;
    private Integer numbparticip;
    private Integer ageparticipfrom; 
    private Integer ageparticipto;
    private String topicality;
    private String expectresult;
    private Integer sumparticip;
    private String otherinfo;
    private Long idstatus;
    private Integer goverfinan;
    private String levelname;
    
	public Integer getGoverfinan() {
		return goverfinan;
	}
	public void setGoverfinan(Integer goverfinan) {
		this.goverfinan = goverfinan;
	}
	
	public String getLevelname() {
		return levelname;
	}
	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}
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
	
	public String getNametypeaction() {
		return nametypeaction;
	}
	public void setNametypeaction(String nametypeaction) {
		this.nametypeaction = nametypeaction;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getLastnamekom() {
		return lastnamekom;
	}
	public void setLastnamekom(String lastnamekom) {
		this.lastnamekom = lastnamekom;
	}
	public String getFirstnamekom() {
		return firstnamekom;
	}
	public void setFirstnamekom(String firstnamekom) {
		this.firstnamekom = firstnamekom;
	}
	public String getNameorganizer() {
		return nameorganizer;
	}
	public void setNameorganizer(String nameorganizer) {
		this.nameorganizer = nameorganizer;
	}
	public String getLastnamedoc() {
		return lastnamedoc;
	}
	public void setLastnamedoc(String lastnamedoc) {
		this.lastnamedoc = lastnamedoc;
	}
	public String getFirstnamedoc() {
		return firstnamedoc;
	}
	public void setFirstnamedoc(String firstnamedoc) {
		this.firstnamedoc = firstnamedoc;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public Integer getNumbparticip() {
		return numbparticip;
	}
	public void setNumbparticip(Integer numbparticip) {
		this.numbparticip = numbparticip;
	}
	public Integer getAgeparticipfrom() {
		return ageparticipfrom;
	}
	public void setAgeparticipfrom(Integer ageparticipfrom) {
		this.ageparticipfrom = ageparticipfrom;
	}
	public Integer getAgeparticipto() {
		return ageparticipto;
	}
	public void setAgeparticipto(Integer ageparticipto) {
		this.ageparticipto = ageparticipto;
	}
	public String getTopicality() {
		return topicality;
	}
	public void setTopicality(String topicality) {
		this.topicality = topicality;
	}
	public String getExpectresult() {
		return expectresult;
	}
	public void setExpectresult(String expectresult) {
		this.expectresult = expectresult;
	}
	public Integer getSumparticip() {
		return sumparticip;
	}
	public void setSumparticip(Integer sumparticip) {
		this.sumparticip = sumparticip;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	
	
	
	public Long getIdstatus() {
		return idstatus;
	}
	public void setIdstatus(Long idstatus) {
		this.idstatus = idstatus;
	}
	
	
	public EventViewPojo(Long id, String advertname, Date datefromadvert, Date datetoadvert, String nametypeaction,
			String venue, String lastnamekom, String firstnamekom, String nameorganizer, String lastnamedoc,
			String firstnamedoc, String program, String purpose, Integer numbparticip, Integer ageparticipfrom,
			Integer ageparticipto, String topicality, String expectresult, Integer sumparticip, String otherinfo,
			Long idstatus, Integer goverfinan, String levelname) {
		super();
		this.id = id;
		this.advertname = advertname;
		this.datefromadvert = datefromadvert;
		this.datetoadvert = datetoadvert;
		this.nametypeaction = nametypeaction;
		this.venue = venue;
		this.lastnamekom = lastnamekom;
		this.firstnamekom = firstnamekom;
		this.nameorganizer = nameorganizer;
		this.lastnamedoc = lastnamedoc;
		this.firstnamedoc = firstnamedoc;
		this.program = program;
		this.purpose = purpose;
		this.numbparticip = numbparticip;
		this.ageparticipfrom = ageparticipfrom;
		this.ageparticipto = ageparticipto;
		this.topicality = topicality;
		this.expectresult = expectresult;
		this.sumparticip = sumparticip;
		this.otherinfo = otherinfo;
		this.idstatus = idstatus;
		this.goverfinan = goverfinan; 
		this.levelname = levelname;
	}
	public EventViewPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
  
}
