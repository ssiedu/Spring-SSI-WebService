	package com.ssi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Course {
	
	@Id
	private String ccode;
	private String cname;
	private String subject;
	private int duration;
	private int fees;
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public Course(String ccode, String cname, String subject, int duration,
			int fees) {
		super();
		this.ccode = ccode;
		this.cname = cname;
		this.subject = subject;
		this.duration = duration;
		this.fees = fees;
	}
	public Course() {
		super();
	}
	@Override
	public String toString() {
		return "Course [ccode=" + ccode + ", cname=" + cname + ", subject="
				+ subject + ", duration=" + duration + ", fees=" + fees + "]";
	}
	
	
}
