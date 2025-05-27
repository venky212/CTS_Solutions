 /*User Engagement Index 
For each user, calculate how many events they attended and how many feedbacks they 
submitted.*/

SELECT 
    u.user_id,
    u.full_name AS user_name,
    COUNT(DISTINCT r.event_id) AS events_attended,
    COUNT(DISTINCT f.feedback_id) AS feedbacks_submitted
FROM 
    Users u
LEFT JOIN 
    Registrations r ON u.user_id = r.user_id
LEFT JOIN 
    Feedback f ON u.user_id = f.user_id
GROUP BY 
    u.user_id, u.full_name
ORDER BY 
    events_attended DESC, feedbacks_submitted DESC;