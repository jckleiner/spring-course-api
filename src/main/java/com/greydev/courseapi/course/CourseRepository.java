package com.greydev.courseapi.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {
	// custom find methods should start with the word 'find'
	// if you want all the thins 'All'
	// if you want one thing 'By'
	// property to filter 'property' -> findByProperty(...)
	//	public List<Course> findByName(String name); // get all courses with name = name

	//	public List<Course> findByTopic(String topicId); // would work if Topic was a string

	public List<Course> findByTopicId(String topicId); // looks at the id property inside Topic
}
