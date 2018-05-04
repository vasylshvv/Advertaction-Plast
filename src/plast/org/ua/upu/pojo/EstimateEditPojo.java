package plast.org.ua.upu.pojo;

public class EstimateEditPojo {
	private Long id;
	private Integer sumbudget;
	private Integer sumother;
	private Integer sumparticipant;
	private Integer sumplast;
	private Integer sumsponsor;
	private Long eventsid;
	private Long costitemid;
	
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

	public Long getCostitemid() {
		return costitemid;
	}

	public void setCostitemid(Long costitemid) {
		this.costitemid = costitemid;
	}

	public EstimateEditPojo(Long id, Integer sumbudget, Integer sumother, Integer sumparticipant, Integer sumplast,
			Integer sumsponsor, Long eventsid, Long costitemid) {
		super();
		this.id = id;
		this.sumbudget = sumbudget;
		this.sumother = sumother;
		this.sumparticipant = sumparticipant;
		this.sumplast = sumplast;
		this.sumsponsor = sumsponsor;
		this.eventsid = eventsid;
		this.costitemid = costitemid;
	}

	
	
}
