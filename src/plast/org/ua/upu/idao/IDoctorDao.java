package plast.org.ua.upu.idao;

import java.util.List;

import plast.org.ua.upu.table.Doctor;

public interface IDoctorDao {
	public void addDoctor(Doctor doctor);
	public List<Doctor> findAll();
	public List<Doctor> findAll(long id);
}
