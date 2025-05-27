 /*Multi-Session Speakers 
Identify speakers who are handling more than one session across all events.*/

SELECT 
    sp.user_id as speaker_id ,
    sp. full_name as speaker_name,
    COUNT(s.session_id) AS session_count
FROM 
    Sessions s
INNER JOIN 
	events_users e ON e.event_id = s.event_id
    INNER JOIN
    users sp ON sp.user_id = e.organizer_id
GROUP BY 
    sp.user_id, sp.full_name
HAVING 
    session_count > 1
ORDER BY 
    session_count DESC;