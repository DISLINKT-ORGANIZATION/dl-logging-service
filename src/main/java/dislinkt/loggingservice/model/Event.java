package dislinkt.loggingservice.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.annotation.Id;

//import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "events")
public class Event {
	
	@Id
    private BigInteger eventId;
	
	@Indexed
	private Date timestamp;
	
	@Indexed
	private String content;
	
	@Indexed
	private EventType type;

	public Event(Date timestamp, String content, EventType type) {
		super();
		this.timestamp = timestamp;
		this.content = content;
		this.type = type;
	}
	
}
