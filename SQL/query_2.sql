/*Top Rated Events 
Identify events with the highest average rating, considering only those that have received at 
least 10 feedback submissions.*/


SELECT 
    e.event_id as EventID,
    e.title as EventName,
    COUNT(Rating) AS FeedbackCount,
    AVG(Rating) AS AverageRating
FROM 
    Feedback f inner join events_users e on f.event_id = e.event_id
GROUP BY 
    EventID, EventName
HAVING 
    COUNT(Rating) >= 1
ORDER BY 
    AverageRating DESC;