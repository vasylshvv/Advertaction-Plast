package plast.org.ua.upu.pojo;

import java.util.Date;

import plast.org.ua.upu.table.KV;
import plast.org.ua.upu.table.Kurin;
import plast.org.ua.upu.table.Stanytsya;
import plast.org.ua.upu.table.Stupin;
import plast.org.ua.upu.table.Vyshkil;

public class InfoKomendantPojo {
	private Long id;
	private String firstname;
	private String lastname;
	private Date birthday;
	private String stupin;
	private String stanytsya;
	private String kurin;
	private String vyshkil;
	private String kv;
	private String cellnumber;
	private String email;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getStupin() {
		return stupin;
	}
	public void setStupin(String stupin) {
		this.stupin = stupin;
	}
	public String getStanytsya() {
		return stanytsya;
	}
	public void setStanytsya(String stanytsya) {
		this.stanytsya = stanytsya;
	}
	public String getKurin() {
		return kurin;
	}
	public void setKurin(String kurin) {
		this.kurin = kurin;
	}
	public String getVyshkil() {
		return vyshkil;
	}
	public void setVyshkil(String vyshkil) {
		this.vyshkil = vyshkil;
	}
	public String getKv() {
		return kv;
	}
	public void setKv(String kv) {
		this.kv = kv;
	}
	public String getCellnumber() {
		return cellnumber;
	}
	public void setCellnumber(String cellnumber) {
		this.cellnumber = cellnumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public InfoKomendantPojo(Long id, String firstname, String lastname,
			Date birthday, String stupin, String stanytsya, String kurin,
			String vyshkil, String kv, String cellnumber, String email) {
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
	public InfoKomendantPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
