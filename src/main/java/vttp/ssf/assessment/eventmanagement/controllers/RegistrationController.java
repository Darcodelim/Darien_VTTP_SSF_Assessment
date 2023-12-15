package vttp.ssf.assessment.eventmanagement.controllers;

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

import jakarta.validation.Valid;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.models.Participants;

@Controller
@RequestMapping
public class RegistrationController {
    

    // TODO: Task 6
    @GetMapping(path="/register")
	public String getEvents(@ModelAttribute("events") Event event, 
	@RequestParam MultiValueMap<String,String> param,Model model)
	{
		String eventName = param.getFirst("eventName");
		String date = param.getFirst("eventDate");

		System.out.println(eventName);

		model.addAttribute("Particulars", new Participants());

		return "eventregister";
	}

    // TODO: Task 7
	@PostMapping("/registrationSuccess")
	public String getParticulars(@Valid @ModelAttribute("Particulars") Participants particulars,BindingResult bindings, @RequestBody MultiValueMap<String,String> body,Model model)
	{
		
		String name = body.getFirst("fullname");
		String date = body.getFirst("DOB");
		String email = body.getFirst("email");
		String phoneNo = body.getFirst("phoneNo");
		String gender = body.getFirst("gender");
		String NumOfTicks =body.getFirst("NumOfTicks");

		System.out.println(date);
		System.out.printf("error: %b\n", bindings.hasErrors());
        
		if(bindings.hasErrors())
		{
            bindings.getAllErrors().stream().forEach(f->System.out.println(f.getCode()+": " + f.getDefaultMessage()));
            
            
            return "eventregister";}
        
        // else if()
        //     {

        //     }

		return "SuccessRegistration";

	}

    
}
