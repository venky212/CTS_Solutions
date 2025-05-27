/*Events Without Sessions 
List all events that currently have no sessions scheduled under them.*/

SELECT 
    e.event_id,
    e.title
FROM 
    Events_users e
LEFT JOIN 
    Sessions s ON e.event_id = s.event_id
WHERE 
    s.session_id IS NULL;