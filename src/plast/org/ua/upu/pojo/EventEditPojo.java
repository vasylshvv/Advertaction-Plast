package plast.org.ua.upu.pojo;

import java.util.Date;

public class EventEditPojo {
	private Long id; 
    private String advertname; 
    private Date datefromadvert; 
    private Date datetoadvert; 
    private Long typeactionid;
    private String venue;
    private Long komendantid;
    private Long organizerid;
    private Long doctorid;
    private String program;
    private String purpose;
    private Integer numbparticip;
    private Integer ageparticipfrom; 
    private Integer ageparticipto;
    private String topicality;
    private String expectresult;
    private Integer sumparticip;
    private String otherinfo;
    private Integer goverfinan;
    private Long levelactionid;
	
    
	public Long getLevelactionid() {
		return levelactionid;
	}
	public void setLevelactionid(Long levelactionid) {
		this.levelactionid = levelactionid;
	}
	public Integer getGoverfinan() {
		return goverfinan;
	}
	public void setGoverfinan(Integer goverfinan) {
		this.goverfinan = goverfinan;
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
	
	public Long getTypeactionid() {
		return typeactionid;
	}
	public void setTypeactionid(Long typeactionid) {
		this.typeactionid = typeactionid;
	}
	
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	public Long getKomendantid() {
		return komendantid;
	}
	public void setKomendantid(Long komendantid) {
		this.komendantid = komendantid;
	}
	
	public Long getOrganizerid() {
		return organizerid;
	}
	public void setOrganizerid(Long organizerid) {
		this.organizerid = organizerid;
	}
	
	public Long getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(Long doctorid) {
		this.doctorid = doctorid;
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
	public EventEditPojo(Long id, String advertname, Date datefromadvert, Date datetoadvert, Long typeactionid,
			String venue, Long komendantid, Long organizerid, Long doctorid, String program, String purpose,
			Integer numbparticip, Integer ageparticipfrom, Integer ageparticipto, String topicality,
			String expectresult, Integer sumparticip, String otherinfo, Integer goverfinan, Long levelactionid) {
		super();
		this.id = id;
		this.advertname = advertname;
		this.datefromadvert = datefromadvert;
		this.datetoadvert = datetoadvert;
		this.typeactionid = typeactionid;
		this.venue = venue;
		this.komendantid = komendantid;
		this.organizerid = organizerid;
		this.doctorid = doctorid;
		this.program = program;
		this.purpose = purpose;
		this.numbparticip = numbparticip;
		this.ageparticipfrom = ageparticipfrom;
		this.ageparticipto = ageparticipto;
		this.topicality = topicality;
		this.expectresult = expectresult;
		this.sumparticip = sumparticip;
		this.otherinfo = otherinfo;
		this.goverfinan = goverfinan;
		this.levelactionid = levelactionid;
	}
	
	
    
}
