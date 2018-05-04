package plast.org.ua.upu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typedoctor")
public class TypeDoctor {
	private Long id;
	private String nametypedoctor;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "nametypedoctor")
	public String getNametypedoctor() {
		return nametypedoctor;
	}
	public void setNametypedoctor(String nametypedoctor) {
		this.nametypedoctor = nametypedoctor;
	}
	public TypeDoctor(Long id, String nametypedoctor) {
		super();
		this.id = id;
		this.nametypedoctor = nametypedoctor;
	}
	public TypeDoctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
