package plast.org.ua.upu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "costitem")
public class Costitem {
	private Long id;
	private String namecostitem;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "namecostitem")
	public String getNamecostitem() {
		return namecostitem;
	}

	public void setNamecostitem(String namecostitem) {
		this.namecostitem = namecostitem;
	}

	public Costitem(Long id, String namecostitem) {
		super();
		this.id = id;
		this.namecostitem = namecostitem;
	}

	public Costitem() {
		super();
		// TODO Auto-generated constructor stub
	}

}
