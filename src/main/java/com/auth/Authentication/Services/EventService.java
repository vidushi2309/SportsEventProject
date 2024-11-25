package com.auth.Authentication.Services;

import com.auth.Authentication.entity.Event;
import com.auth.Authentication.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll(); // Fetch all events from database
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null); // Fetch an event by ID or return null if not found
    }
}