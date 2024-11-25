package com.auth.Authentication.Controller;

import com.auth.Authentication.entity.Event;
import com.auth.Authentication.entity.Registration;
import com.auth.Authentication.entity.User;
import com.auth.Authentication.Services.EventService;
import com.auth.Authentication.Services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:63342")
public class UserController {

    @Autowired
    private EventService eventService;

    @Autowired
    private RegistrationService registrationService;

    // Endpoint to register for an event
    @PostMapping("/event_register/{eventId}")
    public ResponseEntity<Registration> registerForEvent(@PathVariable Long eventId, @AuthenticationPrincipal User user) {
        Event event = eventService.getEventById(eventId);
        if (event == null) {
            return ResponseEntity.notFound().build(); // Return 404 if event not found
        }




        // Ensure user is not null
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Return 401 if user is not authenticated
        }

        Registration registration = registrationService.registerUserForEvent(user, event);
        return ResponseEntity.ok(registration); // Return 200 with registration details
    }
}