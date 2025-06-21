-- 코드를 작성해주세요

select ed.ID, 
    case 
        WHEN ed.SIZE_OF_COLONY <= 100  THEN 'LOW'
        WHEN ed.SIZE_OF_COLONY >  100 and ed.SIZE_OF_COLONY <= 1000 THEN 'MEDIUM'
        WHEN ed.SIZE_OF_COLONY >  1000  THEN 'HIGH'
    END AS SIZE
from ECOLI_DATA ed
