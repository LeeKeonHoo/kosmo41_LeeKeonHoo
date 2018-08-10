select 'Orcale mania',
lower ('Orcale mania'),
upper ('Orcale mania'),
initcap ('Orcale mania')
from dual;

select length('Orcale mania'), length('오라클매니아')
from dual;

select lengthb('Orcale mania'), lengthb('오라클매니아')
from dual;

select 'Orcale', 'mania', concat('Orcale', 'mania')
from dual;

select substr('Orcale mania', 4, 3),
        substrb('Orcale mania', 4, 3)
        from dual;
        
select substr('동해물과백두산이' , 2 ,2),
substrb('동해물과백두산이' , 1 ,3),
substrb('동해물과백두산이' , 13 ,3)
from dual;

select 'Orcale mania',
trim('O' from 'Orcale mania')
from dual;

select 598.7654,
round(598.7654),
round(598.7654, 2),
round(598.7654, -1)
from dual;

select sysdate-1 어제,
sysdate 오늘,
sysdate+1 내일
from dual;

select ename, sysdate - hiredate from employee;
select ename, round(sysdate - hiredate)/365 from employee;
select ename, round(sysdate - hiredate), trunc(months_between(sysdate,hiredate))
from employee;

select ename, hiredate, add_months(hiredate, 6)
from employee;

select sysdate, next_day(sysdate, '토')
from dual;

select ename, hiredate, last_day(hiredate)
from employee;

select ename, hiredate,
to_char(hiredate, 'YY-MM-DD'),
TO_CHAR(HIREDATE, 'YYYY/MM/DD DAY')
FROM EMPLOYEE;

SELECT ENAME, HIREDATE
FROM EMPLOYEE
WHERE HIREDATE <= TO_DATE('19810220', 'YYYYMMDD');

SELECT TO_NUMBER('100,000','999,999') - TO_NUMBER('50,000','999,999')
FROM DUAL;

select ename salary, commission,
nvl2(commission, salary*12*commission, salary*12)
from employee
order by job;

select ename, dno,
decode(dno, 10, 'ACCOUNTING',
            20, 'RESEARCH',
            30, 'SALES',
            40, 'OPERATIONS',
            'DEFAULT') AS 부서
from employee
order by dno;

select ename, dno,
        case when dno =10 then 'ACCOUNTING'
              when dno =20 then 'RESEARCH'
              when dno =30 then 'sales'
              else 'default'
              end as dname
              from employee
              order by dno;
              
              
--1번
select substr(hiredate, 1, 2), substr(hiredate, 4, 2)
from employee;

--2번
select ename from employee
where substr(hiredate, 4, 2) = '04';

--3번(못함)
select ename,mod(eno,2,0) from employee;

--4번
select hiredate, to_char(hiredate, 'yy'), to_char(hiredate, 'mon'), to_char(hiredate, 'dy')
from employee;

--5번(못함)
select sysdate, LAST_DAY(SYSDATE), months_between(last_day('12'),sysdate) from dual;
select sysdate, LAST_DAY(SYSDATE) from dual;

--6번
select ename, nvl(manager, 0)
from employee;

--7번
select ename, job,
DECODE(job, 'ANALYST', SALARY+200,
            'SALESMAN', SALARY+180,
            'MANAGER', SALARY+150,
            'CLERK', SALARY+100,
            salary) AS 인상
            FROM employee
            order by ename;