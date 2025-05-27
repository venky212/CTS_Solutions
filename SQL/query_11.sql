/*Daily New User Count 
Find the number of users who registered each day in the last 7 days.*/
SELECT 
    DATE(registration_date) AS registration_day,
    COUNT(*) AS new_user_count
FROM 
    Users
WHERE 
    registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP BY 
    DATE(registration_date)
ORDER BY 
    registration_day ASC;