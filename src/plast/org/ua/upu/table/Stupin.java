package plast.org.ua.upu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stupin")
public class Stupin {
	private Long id;
	private String shortname;
	private String longname;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "shortname")
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	@Column(name = "longname")
	public String getLongname() {
		return longname;
	}
	public void setLongname(String longname) {
		this.longname = longname;
	}
	public Stupin(Long id, String shortname, String longname) {
		super();
		this.id = id;
		this.shortname = shortname;
		this.longname = longname;
	}
	public Stupin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
