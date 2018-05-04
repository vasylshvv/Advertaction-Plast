package plast.org.ua.upu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "levelaction")
public class LevelAction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "namelevel")
	private String namelevel;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public String getNamelevel() {
		return namelevel;
	}
	public void setNamelevel(String namelevel) {
		this.namelevel = namelevel;
	}
	public LevelAction(Long id, String namelevel) {
		super();
		this.id = id;
		this.namelevel = namelevel;
	}
	public LevelAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
