package vttp.ssf.assessment.eventmanagement.controllers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vttp.ssf.assessment.eventmanagement.Util.Utils;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.models.Participants;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@Controller
@RequestMapping
public class EventController {
	@Autowired
	DatabaseService dbSvc;

	@Autowired
	RedisRepository redisRepo;
	//TODO: Task 5
	@Autowired
	Utils utils;

	@GetMapping
	public String displayEvents(Model model,HttpSession sess)
	{	

		List<Event> events = utils.getEvents();
		// for(Event event:events)
		// {	System.out.println("From Controller:\n");
		// 	System.out.printf("\n eventId: %d\n eventName: %s\n eventSize: %d\n eventDate: %d\n participants: %d\n",
		// 	event.getEventId(),event.getEventName(),event.getEventSize(),event.getEvenDate(),event.getParticipants());}
		
		// sess.setAttribute(null, );
		model.addAttribute("events", events);
		
		return "index";
	}


}
