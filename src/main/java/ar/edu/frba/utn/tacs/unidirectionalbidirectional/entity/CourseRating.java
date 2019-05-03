package ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class CourseRating {
    @EmbeddedId
    CourseRatingKey id;
 
    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    Student student;
 
    @ManyToOne
    @MapsId("course_id")
    @JoinColumn(name = "course_id")
    Course course;
 
    int rating;

	public CourseRating() {

	}

	public CourseRatingKey getId() {
		return id;
	}

	public void setId(CourseRatingKey id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
    
    
}
