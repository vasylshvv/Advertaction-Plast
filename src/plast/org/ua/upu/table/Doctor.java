package plast.org.ua.upu.table;

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
@Table(name = "doctor")
public class Doctor {
	private Long id;
	private String lastnamedoc;
	private String firstnamedoc;
	private String specialtydoc;
	private String cellnumbdoc;
	private String emaildoc;
	private TypeDoctor typedoc;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "lastnamedoc")
	public String getLastnamedoc() {
		return lastnamedoc;
	}
	public void setLastnamedoc(String lastnamedoc) {
		this.lastnamedoc = lastnamedoc;
	}
	@Column(name = "firstnamedoc")
	public String getFirstnamedoc() {
		return firstnamedoc;
	}
	public void setFirstnamedoc(String firstnamedoc) {
		this.firstnamedoc = firstnamedoc;
	}
	@Column(name = "specialtydoc")
	public String getSpecialtydoc() {
		return specialtydoc;
	}
	public void setSpecialtydoc(String specialtydoc) {
		this.specialtydoc = specialtydoc;
	}
	@Column(name = "cellnumbdoc")
	public String getCellnumbdoc() {
		return cellnumbdoc;
	}
	public void setCellnumbdoc(String cellnumbdoc) {
		this.cellnumbdoc = cellnumbdoc;
	}
	@Column(name = "emaildoc")
	public String getEmaildoc() {
		return emaildoc;
	}
	public void setEmaildoc(String emaildoc) {
		this.emaildoc = emaildoc;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "typedocid")
	public TypeDoctor getTypedoc() {
		return typedoc;
	}
	public void setTypedoc(TypeDoctor typedoc) {
		this.typedoc = typedoc;
	}
	public Doctor(Long id, String lastnamedoc, String firstnamedoc,
			String specialtydoc, String cellnumbdoc, String emaildoc,
			TypeDoctor typedoc) {
		super();
		this.id = id;
		this.lastnamedoc = lastnamedoc;
		this.firstnamedoc = firstnamedoc;
		this.specialtydoc = specialtydoc;
		this.cellnumbdoc = cellnumbdoc;
		this.emaildoc = emaildoc;
		this.typedoc = typedoc;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
