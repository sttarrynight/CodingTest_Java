-- 코드를 작성해주세요
SELECT P.ID, (select count(*) from ECOLI_DATA C where C.PARENT_ID = P.ID) as CHILD_COUNT
FROM ECOLI_DATA P
ORDER BY P.ID;