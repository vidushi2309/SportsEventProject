package com.auth.Authentication.Services;

import com.auth.Authentication.Repository.EventRepository;
import com.auth.Authentication.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl extends EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
