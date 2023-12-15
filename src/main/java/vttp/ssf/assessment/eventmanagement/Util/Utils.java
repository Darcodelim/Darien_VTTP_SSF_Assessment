package vttp.ssf.assessment.eventmanagement.Util;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;
@Component
public class Utils {
    @Autowired
    RedisRepository redisRepo;

    public List<Event> getEvents()
    {
        List<Event> events= new LinkedList<>();
        int size =redisRepo.getNumberOfEvents();
		for(int i =1; i<size+1;i++)
		{Event event = redisRepo.getEvent(i);
			events.add(event);
			}
        return events;
    }
    
    public Integer calculateAge(LocalDate inputDob)
    {   
        // LocalDate dob = LocalDate.parse(inputDob); 
        LocalDate curDate = LocalDate.now();
        if((inputDob!= null)&& (curDate!=null))
        {
            Integer years = Period.between(inputDob, curDate).getYears();
            // String yearsStr = years.toString();

            return years;
        }
        else
        {
            return 0;
        }
    }

    
}
