use events;
select user_id,full_name,city,registration_date from users;
select event_id,title,city as events_city,status,organizer_id from Events_users where status="upcoming";

SELECT 
    u.user_id,
    u.full_name,
    e.event_id,
    e.title AS event_title,
    e.city,
    e.start_date,
    e.end_date,
    e.status
FROM 
    Users u
INNER JOIN 
    Registrations r ON u.user_id = r.user_id
INNER JOIN 
    Events_users e ON r.event_id = e.event_id
WHERE 
    e.status = 'upcoming'
    AND u.city = e.city
ORDER BY 
    e.start_date;
