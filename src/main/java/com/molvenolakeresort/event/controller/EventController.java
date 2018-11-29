package com.molvenolakeresort.event.controller;


import com.molvenolakeresort.event.models.Event;
import com.molvenolakeresort.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/event")
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    //Get all Events from database
    @RequestMapping(value = "all", method = RequestMethod.GET)
    public Iterable<Event> getAll() {
        return eventRepository.findAll();
    }

    //Create Event entry in database
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void create(@RequestBody Event event){
        this.eventRepository.save(event);
    }

   /* @RequestMapping(value = "", method = RequestMethod.POST)
    public void create(@RequestBody Movie movie){
        this.movieRepository.save(movie);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) throws Exception {
        //Optional<Movie> movie = this.movieRepository.findById(id);
        //if(movie.isPresent()) {
        //    this.movieRepository.delete(movie.get());
        //} else {
        //    throw new Exception("kan niet lul");
        //}
        this.movieRepository.deleteById(id);
    }

    @RequestMapping(value = "wachted/{id}", method = RequestMethod.PUT)
    public void toggleWachted(@PathVariable long id) {
        Movie movie = this.movieRepository.getOne(id);
        movie.setWachted( !movie.isWachted());
        this.movieRepository.save(movie);

    }*/

}
