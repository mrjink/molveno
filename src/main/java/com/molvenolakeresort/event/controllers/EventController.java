package com.molvenolakeresort.event.controllers;

        import com.molvenolakeresort.event.Event;
        import com.molvenolakeresort.event.repositories.EventRepository;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/event")
public class EventController {
    EventRepository eventRepository;
    public EventController(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public Iterable<Event> getAll(){
        return this.eventRepository.findAll();
    }

}

