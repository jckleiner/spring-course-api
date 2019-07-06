package com.greydev.courseapi.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		List<Topic> resultList = new ArrayList<>();
		Iterable<Topic> iterable = topicRepository.findAll();
		iterable.forEach(resultList::add);
		return resultList;
	}

	public Topic getTopic(String id) {
		// .findById(id) came with spring-boot-parent 2.0+
		Optional<Topic> optional = topicRepository.findById(id);

		try {
			return optional.get(); // can throw NoSuchElementEx
		}
		catch (NoSuchElementException e) {
			System.out.println("No such element with id: " + id);
			return null;
		}
	}

	public Topic addTopic(Topic topic) {
		if (topicRepository.existsById(topic.getId())) {
			throw new RuntimeException("topic id already exists");
		}
		Topic savedTopic = topicRepository.save(topic);
		if (savedTopic == null) {
			throw new RuntimeException("topic couln't be saved");
		}
		return savedTopic;
	}

	public Topic updateTopic(String id, Topic newTopic) {
		newTopic.setId(id);

		Topic savedTopic = topicRepository.save(newTopic);
		if (savedTopic == null) {
			throw new RuntimeException("topic couln't be saved");
		}
		return savedTopic;
	}

	public void deleteTopic(String id) {
		Objects.requireNonNull(id, "id can't be null");

		try {
			// .deleteById(id) came with spring-boot-parent 2.0+
			topicRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			System.out.println("failed delete by id: " + id);
		}
	}

}
