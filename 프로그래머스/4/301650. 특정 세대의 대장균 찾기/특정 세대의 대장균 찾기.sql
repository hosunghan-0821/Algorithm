-- 코드를 작성해주세요

WITH RECURSIVE gen_data as (

    select id,parent_id,1 AS gen
    From ecoli_data
    where  parent_id is NULL
    UNION ALL
    select e.id, e.parent_id, (gen + 1) as gen
    from ecoli_data  e
    inner join gen_data g on e.parent_id = g.id
)

select id From gen_data where gen = 3 order by id