package vttp.ssf.assessment.eventmanagement.repositories;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import vttp.ssf.assessment.eventmanagement.models.Event;

@Repository
public class RedisRepository {

	@Autowired@Qualifier("Event")
	private RedisTemplate<String,Event> template;
	// TODO: Task 2
	public void saveRecord(Event event)
	{
		template.opsForValue().set(event.getEventId().toString(),event);
	}


	// TODO: Task 3
	public int getNumberOfEvents()
	{
		Set<String> eventNum= template.keys("*");
		int size = eventNum.size();
		return size;
		
	}

	// TODO: Task 4
	public Event getEvent(Integer index)
	{
		String indexStr = Integer.toString(index);
		Event singleEvent= template.opsForValue().get(indexStr);
		return singleEvent;

	}
	

}
