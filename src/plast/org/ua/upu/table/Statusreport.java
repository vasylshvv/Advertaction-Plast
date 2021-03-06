package plast.org.ua.upu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statusreport")
public class Statusreport {
	private Long id;
	private String description;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Statusreport(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	public Statusreport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
