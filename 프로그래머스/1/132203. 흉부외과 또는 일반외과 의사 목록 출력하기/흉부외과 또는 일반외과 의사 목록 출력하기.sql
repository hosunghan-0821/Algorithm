-- 코드를 입력하세요
SELECT dc.DR_NAME, dc.DR_ID, dc.MCDP_CD, DATE_FORMAT(dc.HIRE_YMD, "%Y-%m-%d") as HIRE_YMD
FROM DOCTOR AS dc 
where dc.MCDP_CD = "CS" OR dc.MCDP_CD = "GS"
ORDER BY dc.HIRE_YMD desc, dc.DR_NAME asc