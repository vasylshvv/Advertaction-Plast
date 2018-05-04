package plast.org.ua.upu.pojo;

public class EstimateViewPojo {
	private Long id;
	private Integer sumbudget;
	private Integer sumother;
	private Integer sumparticipant;
	private Integer sumplast;
	private Integer sumsponsor;
	private Long eventsid;
	private String namecostitem;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getSumbudget() {
		return sumbudget;
	}
	public void setSumbudget(Integer sumbudget) {
		this.sumbudget = sumbudget;
	}
	public Integer getSumother() {
		return sumother;
	}
	public void setSumother(Integer sumother) {
		this.sumother = sumother;
	}
	public Integer getSumparticipant() {
		return sumparticipant;
	}
	public void setSumparticipant(Integer sumparticipant) {
		this.sumparticipant = sumparticipant;
	}
	public Integer getSumplast() {
		return sumplast;
	}
	public void setSumplast(Integer sumplast) {
		this.sumplast = sumplast;
	}
	public Integer getSumsponsor() {
		return sumsponsor;
	}
	public void setSumsponsor(Integer sumsponsor) {
		this.sumsponsor = sumsponsor;
	}
	public Long getEventsid() {
		return eventsid;
	}
	public void setEventsid(Long eventsid) {
		this.eventsid = eventsid;
	}
	public String getNamecostitem() {
		return namecostitem;
	}
	public void setNamecostitem(String namecostitem) {
		this.namecostitem = namecostitem;
	}
	public EstimateViewPojo(Long id, Integer sumbudget, Integer sumother, Integer sumparticipant, Integer sumplast,
			Integer sumsponsor, Long eventsid, String namecostitem) {
		super();
		this.id = id;
		this.sumbudget = sumbudget;
		this.sumother = sumother;
		this.sumparticipant = sumparticipant;
		this.sumplast = sumplast;
		this.sumsponsor = sumsponsor;
		this.eventsid = eventsid;
		this.namecostitem = namecostitem;
	}
	public EstimateViewPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
