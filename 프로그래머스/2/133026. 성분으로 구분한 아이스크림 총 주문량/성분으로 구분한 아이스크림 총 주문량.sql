-- 코드를 입력하세요
SELECT INGREDIENT_TYPE, sum(TOTAL_ORDER) as TOTAL_ORDER
FROM FIRST_HALF as fh
INNER JOIN ICECREAM_INFO as ii ON fh.FLAVOR = ii.FLAVOR 
GROUP BY INGREDIENT_TYPE