/*Inactive Users 
Retrieve users who have not registered for any events in the last 90 days.*/

SELECT u.*,e.*
FROM Users u
INNER JOIN Events_users e
  ON u.user_id = e.organizer_id
  AND u.registration_date >= CURDATE() - INTERVAL 90 DAY;
