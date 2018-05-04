package plast.org.ua.upu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stanystya")
public class Stanytsya {
	private Long id;
	private String namestan;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "namestan")
	public String getNamestan() {
		return namestan;
	}
	public void setNamestan(String namestan) {
		this.namestan = namestan;
	}
	public Stanytsya(Long id, String namestan) {
		super();
		this.id = id;
		this.namestan = namestan;
	}
	public Stanytsya() {
		super();
		// TODO Auto-generated constructor stub
	}

}
