package com.pojo;

// Generated 17 Apr, 2019 1:19:42 PM by Hibernate Tools 3.5.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Doctor generated by hbm2java
 */
public class Doctor implements java.io.Serializable {

	private Integer DId;
	private Department department;
	private String duniqid;
	private String dname;
	private Long mobileNumber;
	private String demailid;
	private String address;
	private String qulification;
	private String spcialist;
	private Integer expirence;
	private Date joiningDate;
	private byte[] pic;
	private String day;
	private Date inTime;
	private Date outTime;
	private Set pdiseases = new HashSet(0);
	private Set appos = new HashSet(0);

	public Doctor() {
	}

	public Doctor(Department department, String duniqid, String dname, Long mobileNumber, String demailid,
			String address, String qulification, String spcialist, Integer expirence, Date joiningDate, byte[] pic,
			String day, Date inTime, Date outTime, Set pdiseases, Set appos) {
		this.department = department;
		this.duniqid = duniqid;
		this.dname = dname;
		this.mobileNumber = mobileNumber;
		this.demailid = demailid;
		this.address = address;
		this.qulification = qulification;
		this.spcialist = spcialist;
		this.expirence = expirence;
		this.joiningDate = joiningDate;
		this.pic = pic;
		this.day = day;
		this.inTime = inTime;
		this.outTime = outTime;
		this.pdiseases = pdiseases;
		this.appos = appos;
	}

	public Integer getDId() {
		return this.DId;
	}

	public void setDId(Integer DId) {
		this.DId = DId;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getDuniqid() {
		return this.duniqid;
	}

	public void setDuniqid(String duniqid) {
		this.duniqid = duniqid;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Long getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDemailid() {
		return this.demailid;
	}

	public void setDemailid(String demailid) {
		this.demailid = demailid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQulification() {
		return this.qulification;
	}

	public void setQulification(String qulification) {
		this.qulification = qulification;
	}

	public String getSpcialist() {
		return this.spcialist;
	}

	public void setSpcialist(String spcialist) {
		this.spcialist = spcialist;
	}

	public Integer getExpirence() {
		return this.expirence;
	}

	public void setExpirence(Integer expirence) {
		this.expirence = expirence;
	}

	public Date getJoiningDate() {
		return this.joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public byte[] getPic() {
		return this.pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Date getInTime() {
		return this.inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Date getOutTime() {
		return this.outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public Set getPdiseases() {
		return this.pdiseases;
	}

	public void setPdiseases(Set pdiseases) {
		this.pdiseases = pdiseases;
	}

	public Set getAppos() {
		return this.appos;
	}

	public void setAppos(Set appos) {
		this.appos = appos;
	}

}