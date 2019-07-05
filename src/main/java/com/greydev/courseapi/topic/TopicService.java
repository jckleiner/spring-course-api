package com.greydev.courseapi.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	List<Topic> topics = Arrays.asList(new Topic("streams", "Java streams", "Java info about streams"),
			new Topic("final", "Java final keyword", "Java info about final keyword"),
			new Topic("spring", "Java spring framework", "Java info about spring framework"),
			new Topic("oobasics", "Java OO basics", "Java info about OO basics"));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream()
				.filter(t -> t.getId().equalsIgnoreCase(id))
				.findFirst()
				.get();
	}

}
