package plast.org.ua.upu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "kurin")
public class Kurin {
	private Long id;
	private String namekurin;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "namekurin")
	public String getNamekurin() {
		return namekurin;
	}
	public void setNamekurin(String namekurin) {
		this.namekurin = namekurin;
	}
	public Kurin(Long id, String namekurin) {
		super();
		this.id = id;
		this.namekurin = namekurin;
	}
	public Kurin() {
		super();
		// TODO Auto-generated constructor stub
	}

}
