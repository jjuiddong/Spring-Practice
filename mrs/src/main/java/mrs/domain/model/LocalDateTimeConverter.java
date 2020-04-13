package mrs.domain.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.*;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp>{

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime dateTime) {
		return dateTime == null? null : Timestamp.valueOf(dateTime);
	}
	
	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp value) {
		return value == null? null : value.toLocalDateTime();
	}	
}
