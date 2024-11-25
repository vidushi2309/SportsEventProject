package com.auth.Authentication.Services;

import com.auth.Authentication.entity.Event;
import com.auth.Authentication.entity.Registration;
import com.auth.Authentication.entity.User;
import com.auth.Authentication.Repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public Registration registerUserForEvent(User user, Event event) {
        Registration registration = new Registration();
        registration.setUser(user); // Set the user correctly
        registration.setEvent(event); // Set the event correctly
        return registrationRepository.save(registration); // Save to database
    }
}