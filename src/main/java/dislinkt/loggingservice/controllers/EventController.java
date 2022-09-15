package dislinkt.loggingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dislinkt.loggingservice.model.Event;
import dislinkt.loggingservice.services.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
	@GetMapping("")
	public ResponseEntity<?> getAllEvents() {
		List<Event> events = eventService.getAllEvents();
		return ResponseEntity.ok(events);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
	@GetMapping("/{type}")
	public ResponseEntity<?> getByType(@PathVariable String type) {
		List<Event> events = eventService.getByType(type);
		return ResponseEntity.ok(events);
	}
}
