package plast.org.ua.upu.table;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name ="komendant")
public class Komendant {
	private Long id;
	private String firstname;
	private String lastname;
	private Date birthday;
	private Stupin stupin;
	private Stanytsya stanytsya;
	private Kurin kurin;
	private Vyshkil vyshkil;
	private KV kv;
	private String cellnumber;
	private String email;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Column(name = "birthday")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "stupinid")
	public Stupin getStupin() {
		return stupin;
	}
	public void setStupin(Stupin stupin) {
		this.stupin = stupin;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "stanytsyaid")
	public Stanytsya getStanytsya() {
		return stanytsya;
	}
	public void setStanytsya(Stanytsya stanytsya) {
		this.stanytsya = stanytsya;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "kurinid")
	public Kurin getKurin() {
		return kurin;
	}
	public void setKurin(Kurin kurin) {
		this.kurin = kurin;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "vyshkilid")
	public Vyshkil getVyshkil() {
		return vyshkil;
	}
	public void setVyshkil(Vyshkil vyshkil) {
		this.vyshkil = vyshkil;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "kvid")
	public KV getKv() {
		return kv;
	}
	public void setKv(KV kv) {
		this.kv = kv;
	}
	@Column(name = "cellnumber")
	public String getCellnumber() {
		return cellnumber;
	}
	public void setCellnumber(String cellnumber) {
		this.cellnumber = cellnumber;
	}
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Komendant(Long id, String firstname, String lastname, Date birthday,
			Stupin stupin, Stanytsya stanytsya, Kurin kurin, Vyshkil vyshkil,
			KV kv, String cellnumber, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.stupin = stupin;
		this.stanytsya = stanytsya;
		this.kurin = kurin;
		this.vyshkil = vyshkil;
		this.kv = kv;
		this.cellnumber = cellnumber;
		this.email = email;
	}
	public Komendant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
