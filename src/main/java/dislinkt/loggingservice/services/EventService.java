package dislinkt.loggingservice.services;

import java.util.List;

import dislinkt.loggingservice.model.Event;

public interface EventService {

	Event addEvent(Event event);
	List<Event> getAllEvents();
	List<Event> getByType(String type);
}
