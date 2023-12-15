package vttp.ssf.assessment.eventmanagement;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.models.Participants;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@SpringBootApplication
public class EventmanagementApplication implements CommandLineRunner{
	@Autowired
	DatabaseService DbSvc;
	@Autowired
	RedisRepository RedisRepo;


	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApplication.class, args);
	}
	
	// TODO: Task 1
	@Override
	public void run(String...args)
	// {
	{	////for computer
		String fileName = "C:\\2nd Partition\\VTTP\\NUS-ISS\\Module 2_Server Side Foundation\\vttp_batch4_assessment-main\\events.json";

		// //for dockerising
		// String fileName = "/src/events.json";
		List<Event> events = DbSvc.readFile(fileName);


		// for(Event event:events)
		// {	
		// 	System.out.printf("\n eventId: %d\n eventName: %s\n eventSize: %d\n eventDate: %d\n participants: %d\n",
		// 	event.getEventId(),event.getEventName(),event.getEventSize(),event.getEventDate(),event.getParticipants());

		// 	//Saving to Redis
		// 	RedisRepo.saveRecord(event);

		// }
		// //Task 3
		// int size = RedisRepo.getNumberOfEvents();
		// System.out.printf("\n Number of Events: %s\n",Integer.toString(size));

		// //Task 4
		// Event event = RedisRepo.getEvent(1);
		// System.out.println(event.getEventName());


	}
}
