import React, { useState, useEffect } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css'; 
import './Schedule.css';

const Schedule = () => {
    const [selectedDate, setSelectedDate] = useState(new Date());
    const [availableTimes, setAvailableTimes] = useState([]);

    useEffect(() => {
        // Make an API call to the backend to fetch available times for selectedDate
        // This should now reflect the updated availability after processing the CSV file
        fetchAvailableTimes(selectedDate);
    }, [selectedDate]);

    const fetchAvailableTimes = (date) => {
        // Placeholder for an API call
        // Replace this with a real request to your backend
        const mockAvailableTimes = ['10:00', '14:00', '16:00']; // Example times
        setAvailableTimes(mockAvailableTimes);
    };

    const handleDateChange = (date) => {
        setSelectedDate(date);
        fetchAvailableTimes(date);
    };

    return (
        <div className="schedule-container">
            <h2>Available Appointment Slots</h2>
            <Calendar 
                onChange={handleDateChange} 
                value={selectedDate}
            />
            <div className="time-slots">
                {availableTimes.length > 0 ? (
                    availableTimes.map(time => (
                        <button key={time} onClick={() => console.log(`Selected Time: ${time}`)}>
                            {time}
                        </button>
                    ))
                ) : (
                    <p>No available slots for this date.</p>
                )}
            </div>
        </div>
    );
};

export default Schedule;
