package plast.org.ua.upu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typeaction")
public class TypeAction {
	private Long id;
	private String nametypeaction;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "nametypeaction", length = 50)
	public String getNametypeaction() {
		return nametypeaction;
	}
	public void setNametypeaction(String nametypeaction) {
		this.nametypeaction = nametypeaction;
	}
	
	
	public TypeAction(Long id, String nametypeaction) {
		super();
		this.id = id;
		this.nametypeaction = nametypeaction;
	}
	public TypeAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
