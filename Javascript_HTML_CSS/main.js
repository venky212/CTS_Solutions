// JavaScript Basics & Setup
console.log("Welcome to the Community Portal");

// Global variables using proper data types
let events = []; // Using let for mutable array
const PORTAL_NAME = "Community Event Portal"; // Using const for immutable values
let totalRegistrations = 0;

// Closure for tracking registrations by category
const registrationTracker = (() => {
    let categoryCount = {};
    
    return {
        increment: (category) => {
            categoryCount[category] = (categoryCount[category] || 0) + 1;
            return categoryCount[category];
        },
        getCount: (category) => categoryCount[category] || 0,
        getAllCounts: () => ({ ...categoryCount })
    };
})();

// Event constructor/class using ES6 class syntax
class Event {
    constructor(name, date, category, seats, description, fee = 0) {
        this.name = name;
        this.date = date;
        this.category = category;
        this.seats = seats;
        this.description = description;
        this.fee = fee;
    }

    // Method on prototype
    checkAvailability() {
        return this.seats > 0;
    }

    register() {
        if (this.checkAvailability()) {
            this.seats--;
            totalRegistrations++;
            return true;
        }
        return false;
    }

    // Method to get formatted event info using template literals
    getFormattedInfo() {
        return `${this.name} - ${new Date(this.date).toLocaleDateString()} (${this.seats} seats left)`;
    }
}

// Higher-order function for filtering events
function createEventFilter(filterCallback) {
    return function(eventList) {
        return eventList.filter(filterCallback);
    };
}

// Functions with default parameters
function addEvent(name, date, category, seats = 50, description = "No description available") {
    const newEvent = new Event(name, date, category, seats, description);
    events.push(newEvent);
    return newEvent;
}

function registerUser(eventIndex, userName = "Anonymous User") {
    try {
        if (eventIndex < 0 || eventIndex >= events.length) {
            throw new Error("Invalid event index");
        }
        
        const event = events[eventIndex];
        if (event.register()) {
            registrationTracker.increment(event.category);
            console.log(`${userName} registered for ${event.name}`);
            return { success: true, message: `Successfully registered for ${event.name}` };
        } else {
            throw new Error("Event is full");
        }
    } catch (error) {
        console.error("Registration error:", error.message);
        return { success: false, message: error.message };
    }
}

// Array methods demonstration
function filterEventsByCategory(category) {
    return events.filter(event => event.category === category);
}

function getUpcomingEvents() {
    const now = new Date();
    return events.filter(event => new Date(event.date) > now);
}

function formatEventCards() {
    return events.map(event => ({
        ...event,
        displayName: `${event.name} - ${event.category.charAt(0).toUpperCase() + event.category.slice(1)}`
    }));
}

// Initialize mock events data
function initializeEvents() {
    const mockEvents = [
        new Event("Community Cooking Workshop", "2025-06-15", "workshop", 15, "Learn to cook traditional dishes with local chefs", 25),
        new Event("Summer Music Festival", "2025-07-04", "music", 200, "Celebrate with live bands and food trucks", 30),
        new Event("Youth Sports Tournament", "2025-06-20", "sports", 50, "Basketball and soccer competitions for all ages", 10),
        new Event("Art & Craft Fair", "2025-06-28", "festival", 100, "Browse and buy from local artisans", 15),
        new Event("Tech Innovation Workshop", "2025-07-10", "workshop", 25, "Explore the latest in community technology", 25),
        new Event("Jazz Night", "2025-07-15", "music", 80, "Smooth jazz under the stars", 30)
    ];
    
    // Using spread operator to clone array
    events = [...mockEvents];
    renderEvents(events);
    loadUserPreferences();
}

// DOM Manipulation functions
function renderEvents(eventList) {
    const eventGrid = document.querySelector('#eventGrid');
    
    if (!eventGrid) {
        console.error("Event grid container not found");
        return;
    }
    
    // Clear existing content
    eventGrid.innerHTML = '';

    // Use forEach to iterate through events
    eventList.forEach((event, index) => {
        // Create elements dynamically
        const eventCard = document.createElement('div');
        eventCard.className = 'eventCard';
        
        // Using template literals for HTML content
        eventCard.innerHTML = `
            <h3>${event.name}</h3>
            <p class="event-date">📅 ${new Date(event.date).toLocaleDateString()}</p>
            <p>📍 ${event.category.charAt(0).toUpperCase() + event.category.slice(1)}</p>
            <p>${event.description}</p>
            <p><strong>Fee: $${event.fee}</strong></p>
            <span class="seats-available">${event.seats} seats available</span>
            <br><br>
            <button class="register-btn" onclick="quickRegister(${index})" ${!event.checkAvailability() ? 'disabled' : ''}>
                ${event.checkAvailability() ? 'Register' : 'Full'}
            </button>
        `;
        
        // Append to container
        eventGrid.appendChild(eventCard);
    });
}

// Event Handling functions
function filterEvents() {
    const categorySelect = document.getElementById('categoryFilter');
    const category = categorySelect.value;
    
    // Using higher-order function
    const categoryFilter = createEventFilter(event => !category || event.category === category);
    const filtered = categoryFilter(events);
    
    renderEvents(filtered);
}

function searchEvents() {
    const searchInput = document.getElementById('searchInput');
    const searchTerm = searchInput.value.toLowerCase();
    
    const filtered = events.filter(event => 
        event.name.toLowerCase().includes(searchTerm) || 
        event.description.toLowerCase().includes(searchTerm)
    );
    
    renderEvents(filtered);
}

// Event fee display using onchange
function showEventFee() {
    const select = document.getElementById('eventFeeSelect');
    const display = document.getElementById('eventFeeDisplay');
    
    if (select.value) {
        display.textContent = `Event Fee: $${select.value}`;
        display.style.display = 'block';
    } else {
        display.style.display = 'none';
    }
}

// Quick registration with error handling
function quickRegister(eventIndex) {
    const result = registerUser(eventIndex, "Quick User");
    
    if (result.success) {
        alert(result.message + `\nSeats remaining: ${events[eventIndex].seats}`);
        renderEvents(events); // Update display
    } else {
        alert(`Registration failed: ${result.message}`);
    }
}

// Form handling with validation
function handleRegistration(e) {
    e.preventDefault(); // Prevent default form submission
    
    try {
        // Using form.elements to access form data
        const form = e.target;
        const formData = new FormData(form);
        
        // Destructuring to extract form values
        const { userName, userEmail, phoneNumber, eventDate, eventType, message } = Object.fromEntries(formData);
        
        // Validation
        if (!userName.trim()) {
            throw new Error("Name is required");
        }
        
        if (!userEmail.includes('@')) {
            throw new Error("Valid email is required");
        }
        
        // Create registration object
        const registration = {
            name: userName,
            email: userEmail,
            phone: phoneNumber,
            date: eventDate,
            eventType: eventType,
            message: message,
            timestamp: new Date().toISOString()
        };

        // Save preferences (using in-memory storage since localStorage is not available)
        if (registration.eventType) {
            window.userPreferences = { 
                eventType: registration.eventType,
                lastRegistration: registration.