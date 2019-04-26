package com.ssi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssi.entity.Course;

@Component
public class CourseDAO {
	
	@Autowired
	private SessionFactory sf;
	
	
	public Course removeCourse(String code){
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Course course=session.get(Course.class, code);
		session.delete(course);
		tr.commit();
		session.close();
		return course;
	}
	public Course addOrModifyCourse(Course course){
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(course);
		tr.commit();
		session.close();
		return course;
	}
	
	public List<Course> getAllCoursesForPriceRange(int min, int max){
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Course.class);
		Criterion crt=Restrictions.between("fees", min, max);
		cr.add(crt);
		List<Course> courses=cr.list();
		session.close();
		return courses;
	}
	
	public List<Course> getAllCoursesForSubject(String subject){
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Course.class);
		Criterion crt=Restrictions.eq("subject", subject);
		cr.add(crt);
		List<Course> courses=cr.list();
		session.close();
		return courses;
	}
	
	
	public List<Course> getAllCourses(){
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Course.class);
		List<Course> courses=cr.list();
		System.out.println("Courses : "+courses.size());
		session.close();
		return courses;
	}
	public Course getCourseById(String id){
		Session session=sf.openSession();
		Course course=session.get(Course.class, id);
		session.close();
		return course;
	}
	
}
