package vttp.ssf.assessment.eventmanagement.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {

    private Integer eventId;
    private String eventName;
    private Integer eventSize;
    private Long eventDate;
    private Integer participants;

    
    public Integer getEventId() {
        return eventId;
    }
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }
    public Event() //So jackson could use it to descontruct back to our EVENT object
    {
        
    }

    public Event(Integer eventId, String eventName, Integer eventSize, Long evenDate, Integer participants) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventSize = eventSize;
        this.eventDate = evenDate;
        this.participants = participants;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public Integer getEventSize() {
        return eventSize;
    }
    public void setEventSize(Integer eventSize) {
        this.eventSize = eventSize;
    }
    public Long getEventDate() {
        return eventDate;
    }
    public void setEventDate(Long evenDate) {
        this.eventDate = evenDate;
    }
    public Integer getParticipants() {
        return participants;
    }
    public void setParticipants(Integer participants) {
        this.participants = participants;
    }


    
    
}
