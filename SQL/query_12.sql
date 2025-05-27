/*Event with Maximum Sessions 
List the event(s) with the highest number of sessions.*/

SELECT 
    e.event_id,
    e.title,
    COUNT(s.session_id) AS session_count
FROM 
    Events_users e
JOIN 
    Sessions s ON e.event_id = s.event_id
GROUP BY 
    e.event_id, e.title
HAVING 
    session_count = (
        SELECT 
            MAX(session_counts.total_sessions)
        FROM (
            SELECT 
                COUNT(session_id) AS total_sessions
            FROM 
                Sessions
            GROUP BY 
                event_id
        ) AS session_counts
    );
    