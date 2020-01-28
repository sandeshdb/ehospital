package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.pojo.Appo;
import com.pojo.Bill;
import com.pojo.Department;
import com.pojo.Doctor;
import com.pojo.History;
import com.pojo.Pdisease;
import com.pojo.Pregister;
import com.pojo.Report;

public class BLManager {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void saveDoctorRecord(Doctor d) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.save(d);
		tr.commit();
		ss.close();
	}

	public List<Doctor> ViewDoctorRecord() {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Doctor.class);
		List<Doctor> list = (List<Doctor>)cr.list();
		
		return list;
	}

	public Doctor searchByDoctorId(int id) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Doctor.class);
		cr.add(Restrictions.eq("DId", id));
		Doctor di = (Doctor) cr.uniqueResult();
		ss.close();
		return di;
	}

	public void saveDepartment(Department dept) {

		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.save(dept);
		tr.commit();
		ss.close();
	}

	public Department searchByDepartmentName(String department) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Department.class);
		cr.add(Restrictions.eq("deptname", department));
		Department dp = (Department) cr.uniqueResult();
		ss.close();
		return dp;
	}

	public List<Department> viewDepartmentList() {

		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Department.class);
		@SuppressWarnings("unchecked")
		List<Department> list = cr.list();
		ss.close();
		return list;

	}

	public void DeleteDoctorRecord(Doctor d) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.delete(d);
		tr.commit();
		ss.close();

	}

	public void updateDoctorRecord(Doctor d) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.update(d);
		tr.commit();
		ss.close();

	}

	public int savePatientRecord(Pregister pr) {
		int pid=0;
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.save(pr);
		pid=pr.getPid();
		tr.commit();
		ss.close();
		return pid;

	}

	public List<Pregister> ViewPatientRecord() {

		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Pregister.class);
		@SuppressWarnings("unchecked")
		List<Pregister> list = cr.list();
		ss.close();
		return list;

	}

	public Pregister searchByPatientId(int pid) {

		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Pregister.class);
		cr.add(Restrictions.eq("pid", pid));
		Pregister pr = (Pregister) cr.uniqueResult();
		ss.close();
		return pr;
	}

	public Doctor searchByDrUniqID(String uid) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Doctor.class);
		cr.add(Restrictions.eq("duniqid", uid));
		Doctor dr = (Doctor) cr.uniqueResult();
		ss.close();
		return dr;
	}
public List<Bill> viewPatientBilling(String status){
	
	Session ss = sf.openSession();
	Criteria cr = ss.createCriteria(Bill.class);
	cr.add(Restrictions.eq("status",status));
	List<Bill>b =cr.list();
	ss.close();
	return b;
		
}
	public int savePatienDiseaseInfo(Pdisease pd) {
		int pi = 0;
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.save(pd);
		pi = pd.getPdid();
		tr.commit();
		ss.close();
		return pi;
	}

	public Pdisease searchByPatientDiseaseId(int disease) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Pdisease.class);
		cr.add(Restrictions.eq("pdid", disease));
		Pdisease pdid = (Pdisease) cr.uniqueResult();
		ss.close();
		return pdid;
	}

	public int saveReport(Report r) {
		int rid = 0;
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.save(r);
		rid = r.getRid();
		tr.commit();
		ss.close();
		return rid;
	}

	public Report searchByReportId(int rid) {

		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Report.class);
		cr.add(Restrictions.eq("rid", rid));
		Report r = (Report) cr.uniqueResult();
		ss.close();
		return r;
	}

	public void saveHistory(History h) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.save(h);
		tr.commit();
		ss.close();

	}

	public List<Pdisease> searchByPidInPdisease(int pid) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Pdisease.class);
		cr.add(Restrictions.eq("pregister.pid", pid));
		@SuppressWarnings("unchecked")
		List<Pdisease> r = cr.list();
		return r;
	}

	public List<Report> searchByPdiInReport(int pdid) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Report.class);
		cr.add(Restrictions.eq("pdisease.pdid", pdid));
		@SuppressWarnings("unchecked")
		List<Report> r = cr.list();
		return r;
	}

	public Pregister serachPatientByEmailId(String name) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Pregister.class);
		cr.add(Restrictions.eq("pemailid", name));
		Pregister pr = (Pregister) cr.uniqueResult();
		return pr;
	}

	public void UpdatePatientRecord(Pregister pr) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.update(pr);
		tr.commit();
		ss.close();

	}

	public Pregister searchByEmailId(String emailid) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Pregister.class);
		cr.add(Restrictions.eq("pemailid", emailid));
		Pregister pr = (Pregister) cr.uniqueResult();
		ss.close();
		return pr;
	}

	public void saveBillingDetails(Bill b) {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		ss.save(b);
		tr.commit();
		ss.close();
	}

	public List<Bill> searchByPatientIdInBill(int pid) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Bill.class);
		cr.add(Restrictions.eq("pregister.pid", pid));
		@SuppressWarnings("unchecked")
		List<Bill> b=cr.list();
		return b;
	}
	public Bill searchByPatientidInBill(int pid){
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Bill.class);
		cr.add(Restrictions.eq("pregister.pid", pid));
		Bill b=(Bill) cr.uniqueResult();
		return b;
		
	}

	public Bill searchByPatientDiseaseIdInBill(int pdid) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Bill.class);
		cr.add(Restrictions.eq("pdisease.pdid", pdid));
		Bill b=(Bill) cr.uniqueResult();
		return b;
		
	}

	public int saveAppointment(Appo ap) {
		int apid=0;
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		ss.save(ap);
		tr.commit();
		apid=ap.getAid();
		ss.close();
		return apid;
		
	}
	public Appo searchByApidInAppo(int apid){
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Appo.class);
		cr.add(Restrictions.eq("aid",apid));
		Appo ap=(Appo) cr.uniqueResult();
		return ap;
		
		
	}
	

}
