document.addEventListener('DOMContentLoaded', () => {
    fetchEvents();
});

async function fetchEvents() {
console.log(localStorage.getItem('token'))
    try {
        const response = await fetch('http://localhost:8080/api/events', {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${localStorage.getItem('token')}`, // Assuming token is stored in local storage
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const events = await response.json();
        displayEvents(events);

    } catch (error) {
        console.error('Error fetching events:', error);
        document.getElementById('events-list').innerHTML = '<p>Error loading events.</p>';
    }
}

function displayEvents(events) {
    const eventsList = document.getElementById('events-list');

    events.forEach(event => {
        const eventCard = document.createElement('div');
        eventCard.className = 'event-card';

        eventCard.innerHTML = `
            <h2>${event.eventName}</h2>
            <p class="event-details"><strong>Category:</strong> ${event.category}</p>
            <p class="event-details"><strong>Date:</strong> ${event.eventDate}</p>
            <img src="${event.imageLink}" alt="${event.eventName}">
            <button class="register-button" onclick="registerForEvent(${event.id})">Register</button>
        `;

        eventsList.appendChild(eventCard);
    });
}

async function registerForEvent(eventId) {
    try {
    console.log(localStorage.getItem('token'))
        const response = await fetch(`http://localhost:8080/api/user/event_register/${eventId}`, {
            method: 'POST',
            headers: {
                'Authorization': `Bearer ${localStorage.getItem('token')}`, // Ensure token is present
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('Failed to register for event');
        }

        const data = await response.json();
        alert(`Successfully registered for event ID: ${data.event.id}`);

    } catch (error) {
        console.error('Error registering for event:', error);
        alert('Error registering for event. Please try again.');
    }
}