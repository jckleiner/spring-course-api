package com.greydev.courseapi.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greydev.courseapi.topic.Topic;

@Entity
public class Course {

	@Id
	@Column(name = "course_id")
	private String id;
	@Column(name = "course_name")
	private String name;
	@Column(name = "course_description")
	private String description;

	@JsonIgnore
	@ManyToOne
	private Topic topic;
	@Transient
	private String parentTopicId;

	public String getId() {
		return id;
	}

	public Course() {

	}

	public Course(String id, String name, String description, Topic topic) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = topic;
		this.parentTopicId = topic.getId();
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
		this.parentTopicId = topic.getId();
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

	public String getParentTopicId() {
		return topic.getId(); // TODO Can this be ever null?
	}

	public void setParentTopicId(String topicId) {
		this.parentTopicId = topicId;
	}

}
