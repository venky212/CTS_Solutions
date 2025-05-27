/*Organizer Event Summary 
For each event organizer, show the number of events created and their current status 
(upcoming, completed, cancelled).*/

SELECT 
    e.organizer_id,
    o.full_name AS organizer_name,
    COUNT(e.event_id) AS total_events,
    SUM(CASE WHEN e.status = 'upcoming' THEN 1 ELSE 0 END) AS upcoming_events,
    SUM(CASE WHEN e.status = 'completed' THEN 1 ELSE 0 END) AS completed_events,
    SUM(CASE WHEN e.status = 'cancelled' THEN 1 ELSE 0 END) AS cancelled_events
FROM 
    Users o
LEFT JOIN 
    Events_users e ON o.user_id = e.organizer_id
GROUP BY 
    e.organizer_id, o.full_name;