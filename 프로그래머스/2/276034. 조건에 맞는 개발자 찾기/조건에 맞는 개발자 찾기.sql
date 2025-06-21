select D.ID,D.EMAIL,D.FIRST_NAME,D.LAST_NAME from DEVELOPERS D
where D.SKILL_CODE & ( select S.CODE from SKILLCODES S where S.NAME = 'PYTHON')  = ( select S.CODE from SKILLCODES S where S.NAME = 'PYTHON')
or D.SKILL_CODE & ( select S.CODE from SKILLCODES S where S.NAME = 'C#')  = ( select S.CODE from SKILLCODES S where S.NAME = 'C#')
ORDER BY ID ASC