package com.hcp.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hcp.dao.PatientDAO;
import com.hcp.domain.Doctor;
import com.hcp.domain.Emr;
import com.hcp.domain.Family;
import com.hcp.domain.GluPatientMedicineRecord;
import com.hcp.domain.GluPatientRecord;
import com.hcp.domain.HdPatientMedicineRecord;
import com.hcp.domain.HdPatientRecord;
import com.hcp.domain.Hospital;
import com.hcp.domain.HplPatientMedicineRecord;
import com.hcp.domain.HplPatientRecord;
import com.hcp.domain.HtnPatientMedicineRecord;
import com.hcp.domain.HtnPatientRecord;
import com.hcp.domain.Medicine;
import com.hcp.domain.Patient;
import com.hcp.domain.PatientGroup;
import com.hcp.domain.PatientHasDoctor;
import com.hcp.domain.Prescription;
import com.hcp.util.MyHibernateCallback;

@Repository
public class PatientDAOImp extends HibernateDaoSupport implements PatientDAO {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public Patient getPatientById(Integer patient_id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().load(Patient.class, patient_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Patient getPatientByName(String patient_username) {
		// TODO Auto-generated method stub
		List<Patient> list = this.getHibernateTemplate().find("from Patient as p where p.username = ?", new Object[] { patient_username });
		return list.isEmpty() ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isNameExist(String username) {
		// TODO Auto-generated method stub
		List<Patient> list = this.getHibernateTemplate().find("from Patient as p where p.username = ?", new Object[] { username });
		return list.isEmpty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Patient login(String username, String password) {
		// TODO Auto-generated method stub
		List<Patient> list = this.getHibernateTemplate().find("from Patient as p where p.username = ? and p.password=?",
				new Object[] { username, password });
		return list.isEmpty() ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getDoctors(Integer hospital_id) {
		// TODO Auto-generated method stub
		List<Doctor> list = this.getHibernateTemplate().find("from Doctor as d where d.hospital.id = ?",
				new Object[] { hospital_id });
		return list.isEmpty() ? null : list;
	}

	public boolean register(Patient patients, PatientHasDoctor patientHasDoctor) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(patients);
			this.getHibernateTemplate().save(patientHasDoctor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public boolean register(Patient patients){
		try {
			this.getHibernateTemplate().save(patients);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	@Override
	public boolean updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(patient);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GluPatientMedicineRecord> getGluPatientMedicineRecord(Integer patient_id) {
		// TODO Auto-generated method stub
		List<GluPatientMedicineRecord> list = this.getHibernateTemplate().find(
				"from GluPatientMedicineRecord as glu where glu.patient.id=?", new Object[] { patient_id });
		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HtnPatientMedicineRecord> getHtnPatientMedicineRecord(Integer patient_id) {
		// TODO Auto-generated method stub
		List<HtnPatientMedicineRecord> list = this.getHibernateTemplate().find(
				"from HtnPatientMedicineRecord as htn where htn.patient.id=?", new Object[] { patient_id });
		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HplPatientMedicineRecord> getHplPatientMedicineRecord(Integer patient_id) {
		// TODO Auto-generated method stub
		List<HplPatientMedicineRecord> list = this.getHibernateTemplate().find(
				"from HplPatientMedicineRecord as hpl where hpl.patient.id=?", new Object[] { patient_id });
		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HdPatientMedicineRecord> getHdPatientMedicineRecord(Integer patient_id) {
		// TODO Auto-generated method stub
		List<HdPatientMedicineRecord> list = this.getHibernateTemplate().find(
				"from HdPatientMedicineRecord as hd where hd.patient.id=?", new Object[] { patient_id });
		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GluPatientRecord> getGluPatientRecords(Integer patient_id, Integer count) {
		// TODO Auto-generated method stub
		String hql = "from GluPatientRecord as glu where glu.patient.id=? order by id desc ";
		List<GluPatientRecord> list = this.getHibernateTemplate().executeFind(new MyHibernateCallback(hql, 0, count, patient_id));
		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HtnPatientRecord> getHtnPatientRecords(Integer patient_id, Integer count) {
		// TODO Auto-generated method stub
		String hql = "from HtnPatientRecord as htn where htn.patient.id=? order by id desc ";
		List<HtnPatientRecord> list = this.getHibernateTemplate().executeFind(new MyHibernateCallback(hql, 0, count, patient_id));
		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HplPatientRecord> getHplPatientRecords(Integer patient_id, Integer count) {
		// TODO Auto-generated method stub
		String hql = "from HplPatientRecord as hpl where hpl.patient.id=? order by id desc ";
		List<HplPatientRecord> list = this.getHibernateTemplate().executeFind(new MyHibernateCallback(hql, 0, count, patient_id));
		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HdPatientRecord> getHdPatientRecords(Integer patient_id, Integer count) {
		// TODO Auto-generated method stub
		String hql = "from HdPatientRecord as hd where hd.patient.id=? order by id desc ";
		List<HdPatientRecord> list = this.getHibernateTemplate().executeFind(new MyHibernateCallback(hql, 0, count, patient_id));
		return list.isEmpty() ? null : list;
	}

	@Override
	public boolean saveGluPatientRecords(GluPatientRecord gluPatientRecord) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(gluPatientRecord);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveHtnPatientRecord(HtnPatientRecord htnPatientRecord) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(htnPatientRecord);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveHplPatientRecord(HplPatientRecord hplPatientRecord) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(hplPatientRecord);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveHdPatientRecord(HdPatientRecord hdPatientRecord) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(hdPatientRecord);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emr> getPatientEmrsList(Integer patient_id, String startTime, String endTime) {
		// TODO Auto-generated method stub
		List<Emr> list = this.getHibernateTemplate().find("from Emr as e where e.patient.id = ?", new Object[] { patient_id });
		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Emr getLastEmr(Integer patient_id) {
		// TODO Auto-generated method stub
		List<Emr> list = this.getHibernateTemplate().find("from Emr as e where e.patient.id = ?", new Object[] { patient_id });
		return list.get(list.size() - 1);
	}

	@Override
	public List<Hospital> getHospitals() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hospital getHospitalByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientGroup getDefaultGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor getDoctorById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> getDoctorsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medicine getMedicineById(Integer medicine_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prescription> getPrescriptionByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
