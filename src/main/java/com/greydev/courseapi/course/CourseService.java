package com.greydev.courseapi.course;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.greydev.courseapi.topic.Topic;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCoursesUnderTopic(String topicId) {
		List<Course> resultList = new ArrayList<>();
		Iterable<Course> iterable = courseRepository.findByTopicId(topicId);
		iterable.forEach(resultList::add);
		return resultList;
	}

	public Course getCourse(String courseId) {
		// .findById(id) came with spring-boot-parent 2.0+
		Optional<Course> optional = courseRepository.findById(courseId);

		try {
			return optional.get(); // can throw NoSuchElementEx
		}
		catch (NoSuchElementException e) {
			System.out.println("No such element with id: " + courseId);
			return null;
		}
	}

	public Course addCourse(String topicId, Course course) {
		course.setTopic(new Topic(topicId, "", "")); // TODO Find a better solution

		if (courseRepository.existsById(course.getId())) {
			throw new RuntimeException("course id already exists");
		}
		Course savedCourse = courseRepository.save(course);
		if (savedCourse == null) {
			throw new RuntimeException("course couln't be saved");
		}
		return savedCourse;
	}

	public Course updateCourse(String topicId, String courseId, Course newCourse) {
		newCourse.setTopic(new Topic(topicId, "", "")); // TODO Find a better solution
		newCourse.setId(courseId);

		Course savedCourse = courseRepository.save(newCourse);
		if (savedCourse == null) {
			throw new RuntimeException("course couln't be saved");
		}
		return savedCourse;
	}

	public void deleteCourse(String courseId) {
		Objects.requireNonNull(courseId, "id can't be null");

		try {
			// .deleteById(id) came with spring-boot-parent 2.0+
			//			courseRepository.deleteById(courseId);
			System.out.println("deleting course... " + courseId);
			courseRepository.deleteById(courseId);
		}
		catch (EmptyResultDataAccessException e) {
			System.out.println("failed delete by id: " + courseId);
		}
	}

}
