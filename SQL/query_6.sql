/*Event Resource Summary 
Generate a report showing the number of resources (PDFs, images, links) uploaded for each 
event.*/

SELECT 
    event_id,
    SUM(CASE WHEN resource_type = 'pdf' THEN 1 ELSE 0 END) AS pdf_count,
    SUM(CASE WHEN resource_type = 'image' THEN 1 ELSE 0 END) AS image_count,
    SUM(CASE WHEN resource_type = 'link' THEN 1 ELSE 0 END) AS link_count
FROM 
    Resources
GROUP BY 
    event_id;
    
    
  