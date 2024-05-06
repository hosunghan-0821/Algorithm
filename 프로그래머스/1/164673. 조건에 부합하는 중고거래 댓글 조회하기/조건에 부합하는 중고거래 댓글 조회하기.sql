-- 코드를 입력하세요
SELECT bd.TITLE, bd.BOARD_ID, rp.REPLY_ID, rp.WRITER_ID, rp.CONTENTS,DATE_FORMAT(rp.CREATED_DATE, "%Y-%m-%d") as CREATED_DATE 
from  USED_GOODS_BOARD as bd
inner join USED_GOODS_REPLY as rp ON bd.BOARD_ID = rp.BOARD_ID
where DATE_FORMAT(bd.CREATED_DATE, '%Y-%m') = '2022-10'
order by rp.CREATED_DATE asc, bd.TITLE asc