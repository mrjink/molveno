package com.molvenolakeresort.repositories.event;

import com.molvenolakeresort.models.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "event")
public interface EventRepository extends JpaRepository<Event, Long> {
    //Iterable<Event> findAllByLocation(String Location);
}