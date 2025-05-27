 /*Feedback Gap 
Identify events that had registrations but received no feedback at all.*/

SELECT 
    e.event_id,
    e.title
FROM 
    Events_users e
JOIN 
    Registrations r ON e.event_id = r.event_id
LEFT JOIN 
    Feedback f ON e.event_id = f.event_id
WHERE    f.event_id IS NULL
GROUP BY 
    e.event_id, e.title;