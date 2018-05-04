package plast.org.ua.upu.table;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "photosevent")
public class PhotosEventReport {
	private Long id;
	private String namefile;
	private Blob photo;
	private Report report;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "namefile")
	public String getNamefile() {
		return namefile;
	}
	public void setNamefile(String namefile) {
		this.namefile = namefile;
	}
	@Lob
	@Column(name = "photo", columnDefinition = "mediumblob")
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "reportid")
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	public PhotosEventReport(Long id, String namefile, Blob photo, Report report) {
		super();
		this.id = id;
		this.namefile = namefile;
		this.photo = photo;
		this.report = report;
	}
	public PhotosEventReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
