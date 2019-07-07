package com.greydev.courseapi.topic;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.greydev.courseapi.course.Course;

@Entity
public class Topic {

	@Id
	@Column(name = "topic_id")
	private String id;
	@Column(name = "topic_name")
	private String name;
	@Column(name = "topic_description")
	private String description;

	//fetch= FetchType.EAGER -> if this is added, can't DELETE /courses/xxx
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "topic")
	private Set<Course> courses = new HashSet<>();

	public String getId() {
		return id;
	}

	public Topic() {

	}

	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
