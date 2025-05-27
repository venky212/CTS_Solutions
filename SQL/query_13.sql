/*Average Rating per City 
Calculate the average feedback rating of events conducted in each city.*/

SELECT 
    e.city,
    AVG(f.rating) AS average_rating
FROM 
    Feedback f
JOIN 
    Events_users e ON f.event_id = e.event_id
GROUP BY 
    e.city
ORDER BY 
    average_rating DESC; 