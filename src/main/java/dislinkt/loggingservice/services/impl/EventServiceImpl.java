package dislinkt.loggingservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dislinkt.loggingservice.model.Event;
import dislinkt.loggingservice.repositories.EventRepository;
import dislinkt.loggingservice.services.EventService;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	public Event addEvent(Event event) {
		return eventRepository.save(event);
	}
	
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}
	
	public List<Event> getByType(String type) {
		return eventRepository.findByType(type.toUpperCase());
	}

}
