package dislinkt.loggingservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dislinkt.loggingservice.model.Event;
import dislinkt.loggingservice.model.EventType;

@Repository
public interface EventRepository extends MongoRepository<Event, Long>  {

	List<Event> findAll();
	
	List<Event> findByType(String type);
}
