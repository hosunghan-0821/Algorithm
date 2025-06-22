SELECT 
    count(*) as FISH_COUNT, 
    max(f.LENGTH) as MAX_LENGTH,
    f.FISH_TYPE as FISH_TYPE
FROM FISH_INFO f
GROUP BY f.FISH_TYPE
HAVING AVG(
         CASE
           WHEN f.LENGTH <= 10 THEN 10
           ELSE f.LENGTH
         END
       ) >= 33
ORDER BY FISH_TYPE asc