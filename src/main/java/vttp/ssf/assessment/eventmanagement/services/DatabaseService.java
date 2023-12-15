package vttp.ssf.assessment.eventmanagement.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonReader;

import java.util.List;

import vttp.ssf.assessment.eventmanagement.models.Event;

@Service
public class DatabaseService {
    
    // TODO: Task 1
    List<Event> eventList = null;
    public List<Event> readFile(String fileName)
    {   
        try {
            File file = new File(fileName);
            InputStream is = new FileInputStream(file);
            JsonReader jsonReader = Json.createReader(is);
            JsonArray event = jsonReader.readArray();

            eventList = event.stream().map(j->j.asJsonObject())
            .map(i->{
                Integer eventId = i.getInt("eventId");
                String eventName = i.get("eventName").toString();
                Integer eventSize = i.getInt("eventSize");
                Long eventDate = Long.parseLong(i.get("eventDate").toString());
                Integer participants = i.getInt("participants");
                return new Event(eventId, eventName, eventSize, eventDate, participants);
            })
            .toList();

            

            }
            catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }
        return eventList; 
        }
    
    
    }

