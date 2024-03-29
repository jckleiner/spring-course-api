package com.greydev.courseapi.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.greydev.courseapi.course.CourseRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	@Autowired
	private CourseRepository courseRepository;

	public List<Topic> getAllTopics() {
		List<Topic> resultList = new ArrayList<>();
		Iterable<Topic> iterable = topicRepository.findAll();
		iterable.forEach(resultList::add);
		return resultList;
	}

	public Topic getTopic(String topicId) {
		// .findById(topicId) came with spring-boot-parent 2.0+
		Optional<Topic> optional = topicRepository.findById(topicId);

		try {
			return optional.get(); // can throw NoSuchElementEx
		}
		catch (NoSuchElementException e) {
			System.out.println("No such element with topicId: " + topicId);
			return null;
		}
	}

	public Topic addTopic(Topic topic) {

		if (topicRepository.existsById(topic.getId())) {
			throw new RuntimeException("topic topicId already exists: " + topic.getId());
		}
		// TODO check if child id's already exist -> throw exception
		topic.getCourses().forEach(course -> {
			if (courseRepository.existsById(course.getId())) {
				throw new RuntimeException("courseId already exists: " + course.getId());
			}
		});

		// remember to set bi-directional relationship
		// courses have 'Topic topic' : null
		topic.getCourses().forEach(c -> c.setTopic(topic));

		Topic savedTopic = topicRepository.save(topic);
		if (savedTopic == null) {
			throw new RuntimeException("topic couln't be saved");
		}
		return savedTopic;
	}

	public Topic updateTopic(String topicId, Topic topic) {
		topic.setId(topicId);

		Topic savedTopic = topicRepository.save(topic);
		if (savedTopic == null) {
			throw new RuntimeException("topic couln't be saved");
		}
		return savedTopic;
	}

	public void deleteTopic(String topicId) {
		Objects.requireNonNull(topicId, "topicId can't be null");

		try {
			// .deleteById(topicId) came with spring-boot-parent 2.0+
			topicRepository.deleteById(topicId);
		}
		catch (EmptyResultDataAccessException e) {
			System.out.println("failed delete by topicId: " + topicId);
		}
	}

}
