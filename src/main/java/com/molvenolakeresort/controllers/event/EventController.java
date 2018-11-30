package com.molvenolakeresort.controllers.event;


import com.molvenolakeresort.models.event.Event;
import com.molvenolakeresort.repositories.event.EventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/event")
public class EventController {

    //@Autowired
    private EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Alle Events ophalen
    @RequestMapping(value = "all", method = RequestMethod.GET)
    public Iterable<Event> getAll() {
        return eventRepository.findAll();
    }

    //Event aanmaken
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void create(@RequestBody Event event){
        this.eventRepository.save(event);
    }

    //    //1 Event Aanpassen
    @RequestMapping(value = "update/{id}", method = RequestMethod.PATCH)
    public void updateEvent(@PathVariable long id, @RequestBody Event event) {
        Event dBevent = this.eventRepository.getOne(id);
        dBevent.setAddress(event.getAddress());
        this.eventRepository.save(event);
    }

//    //Event verwijderen
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) throws Exception {
        //Optional<Movie> movie = this.movieRepository.findById(id);
        //if(movie.isPresent()) {
        //    this.movieRepository.delete(movie.get());
        //} else {
        //    throw new Exception("delete is niet gelukt");
        //}
        this.eventRepository.deleteById(id);
    }

// 1 Event ophalen
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Optional<Event> getEvent(@PathVariable long id) throws Exception{
        return eventRepository.findById(id);
    }
}
