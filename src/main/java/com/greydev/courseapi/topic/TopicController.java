package com.greydev.courseapi.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping(method = RequestMethod.GET, value = "/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}")
	public Topic getTopic(@PathVariable String topicId) {
		return topicService.getTopic(topicId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public Topic addTopic(@RequestBody Topic topic) {
		System.out.println(" *** addTopic, courses found:");
		topic.getCourses().forEach(c -> System.out.println(c.getId()));
		return topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}")
	public Topic updateTopic(@PathVariable String topicId, @RequestBody Topic topic) {
		return topicService.updateTopic(topicId, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}")
	public void deleteTopic(@PathVariable String topicId) {
		topicService.deleteTopic(topicId);
	}

}
