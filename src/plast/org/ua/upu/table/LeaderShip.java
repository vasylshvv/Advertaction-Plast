package plast.org.ua.upu.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leadership")
public class LeaderShip {
	private Long id;
	private String namelider;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "namelider")
	public String getNamelider() {
		return namelider;
	}
	public void setNamelider(String namelider) {
		this.namelider = namelider;
	}
	public LeaderShip(Long id, String namelider) {
		super();
		this.id = id;
		this.namelider = namelider;
	}
	public LeaderShip() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
