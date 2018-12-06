package com.molvenolakeresort.repositories.event;

import com.molvenolakeresort.models.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "event")
public interface EventRepository extends JpaRepository<Event, Long> {

}
