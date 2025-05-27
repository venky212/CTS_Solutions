/*Registration Trends 
Show a month-wise registration count trend over the past 12 months.*/

SELECT
    DATE_FORMAT(registration_date, '%Y-%m') AS yearsmonth,
    COUNT(*) AS registration_count
FROM
    Registrations
WHERE
    registration_date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH)
GROUP BY
    yearsmonth
ORDER BY
    yearsmonth ASC;
