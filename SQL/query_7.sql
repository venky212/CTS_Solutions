/*Low Feedback Alerts 
List all users who gave feedback with a rating less than 3, along with their comments and 
associated event names. */

SELECT 
    u.user_id,
    u.full_name AS user_name,
    e.title as event_name,
    f.rating,
    f.comments
FROM 
    Feedback f
JOIN 
    Users u ON f.user_id = u.user_id
JOIN 
    Events_users e ON f.event_id = e.event_id
WHERE 
    f.rating < 3;