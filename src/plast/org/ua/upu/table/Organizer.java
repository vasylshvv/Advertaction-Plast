package plast.org.ua.upu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organizer")
public class Organizer {
	private Long id;
	private String nameorganizer;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "nameorganizer")
	public String getNameorganizer() {
		return nameorganizer;
	}
	public void setNameorganizer(String nameorganizer) {
		this.nameorganizer = nameorganizer;
	}
	public Organizer(Long id, String nameorganizer) {
		super();
		this.id = id;
		this.nameorganizer = nameorganizer;
	}
	public Organizer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
