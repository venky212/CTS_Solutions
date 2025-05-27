/*Unregistered Active Users 
Find users who created an account in the last 30 days but haven’t registered for any events.*/


SELECT 
    u.user_id,
    u.full_name,
    u.email,
    u.registration_date
FROM 
    Users u
LEFT JOIN 
    Registrations er ON u.user_id = er.user_id
WHERE 
    u.registration_date >= CURDATE() - INTERVAL 30 DAY
    AND er.user_id IS NULL;