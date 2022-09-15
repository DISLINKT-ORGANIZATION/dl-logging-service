package dislinkt.loggingservice.config;

import org.springframework.stereotype.Component;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import dislinkt.loggingservice.model.Event;
import dislinkt.loggingservice.model.EventKafka;
import dislinkt.loggingservice.services.EventService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class KafkaListeners {

	@Autowired
	private EventService eventService;

	private static final Logger logger = LoggerFactory.getLogger(KafkaListeners.class);

	@KafkaListener(topics = "dislinkt-events", groupId = "groupId")
	void listener(@Payload EventKafka data) throws JsonMappingException, JsonProcessingException {
		logger.info("Listener received " + data);
		eventService.addEvent(new Event(data.getTimestamp(), data.getContent(), data.getType()));
	}
}
