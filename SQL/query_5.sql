/*Most Active Cities 
List the top 5 cities with the highest number of distinct user registrations.*/

SELECT 
    city,
    COUNT(DISTINCT user_id) AS user_count
FROM 
    Users where  registration_date is not null
GROUP BY 
    city
ORDER BY 
    user_count DESC
LIMIT 5;