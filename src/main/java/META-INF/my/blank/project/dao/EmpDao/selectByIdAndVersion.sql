select
  ID,
  EMP_NO,
  EMP_NAME,
  MGR_ID,
  HIREDATE,
  SAL,
  DEPT_ID,
  VERSION_NO
from
  EMP
where
  ID = /* id */1
  and
  VERSION_NO = /* versionNo */1
