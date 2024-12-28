SELECT FLAVOR
FROM (
    SELECT 
        fh.FLAVOR,
        RANK() OVER (ORDER BY SUM(fh.TOTAL_ORDER) + SUM(j.TOTAL_ORDER) DESC) AS `rank`
    FROM 
        FIRST_HALF fh
    INNER JOIN 
        JULY j ON fh.FLAVOR = j.FLAVOR
    GROUP BY 
        fh.FLAVOR
) ranked_flavors
WHERE `rank` <= 3;
