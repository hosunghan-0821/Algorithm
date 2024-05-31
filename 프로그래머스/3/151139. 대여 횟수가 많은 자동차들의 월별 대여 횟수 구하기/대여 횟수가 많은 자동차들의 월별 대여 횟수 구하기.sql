-- 코드를 입력하세요
SELECT month(rh.START_DATE) as MONTH, rh.CAR_ID , count(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY as rh
WHERE 
    date_format(rh.START_DATE,'%Y-%m') BETWEEN '2022-08' AND '2022-10' 
    AND rh.CAR_ID IN (
                        SELECT CAR_ID
                        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                        WHERE DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10' 
                        GROUP BY CAR_ID
                        HAVING COUNT(CAR_ID) >=5
                     )
GROUP BY rh.CAR_ID, MONTH(rh.START_DATE)
HAVING RECORDS >= 1
ORDER BY MONTH ASC, rh.CAR_ID DESC 