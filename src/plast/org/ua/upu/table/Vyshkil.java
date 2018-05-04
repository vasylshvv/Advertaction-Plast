package plast.org.ua.upu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vyshkil")
public class Vyshkil {
	private Long id;
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vyshkil(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Vyshkil() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
