select sum(salary) as "급여총액",
        avg(salary) as "급여평균",
        max(salary) as "최대급여",
        min(salary) as "최소급여"
        from employee;
        
select sum(commission) as "커미션 총액"
from employee;

select count(*) as "사원의수"
from employee
where dno in(10, 20);

select count(distinct job) as "직업 종류"
from employee;

select round(avg(salary),1)
from employee
where dno =20;

select dno,round(avg(salary),1)
from employee
group by dno;

select dno,job ,count(*),sum(salary)
from employee
group by dno, job
order by dno, job;

select dno,max(salary)
from employee
group by dno
having max(salary) >= 3000;

--1번
select sum(salary) as "급여총액",
        round(avg(salary),0) as "급여평균",
        max(salary) as "최대급여",
        min(salary) as "최소급여"
        from employee;
        
--2번
select distinct job as "직업종류",
        sum(salary) as "급여총액",
       round(avg(salary),0) as "급여평균",
       max(salary) as "최대급여",
       min(salary) as "최소급여"
        from employee
        group by job;
        
--3번
select job,count(*) as "사원의수"
from employee
group by job;

--4번
select JOB,count(*) as "사원수"
from employee
where job = 'MANAGER'
GROUP BY JOB;

--5번
select (max(salary) - min(salary)) as DIFFERENCE
     from employee;
     
--6번
select job,min(salary) 
from employee
group by job
having min(salary) >= 2000 and job !='PRESIDENT'
order by min(salary) desc;
 
--7번
select dno, count(*) as "Number of People" ,round(avg(salary),2) as SALARY
from employee
group by dno;

--8번(못함)
select dno, 
        decode(dno,10,'ACCOUNTING',
                    20,'RESCARCH',
                    30,'SALES',
                    40,'OPERATIONS')AS LOCATION,
        count(*) as "Number of People" ,round(avg(salary),2) as SALARY
from employee
group by dno;

--9번(못함)
select JOB,dno,
nvl(decode(dno,10,sum(salary)),0) as "부서 10",
nvl(decode(dno,20,sum(salary)),0) as "부서 20",
nvl(decode(dno,30,sum(salary)),0) as "부서 30",
sum(salary) as 총액
FROM EMPLOYEE
GROUP BY JOB,dno
order by job,dno;

--서울시의 모든 구를 출력
select sigunguk
from zipcode
where sidok = '서울특별시'
group by sigunguk
order by sigunguk;

--서울시의 특정 동이름을 출력
select sigunguk,count(distinct law_name)
from zipcode
where sidok = '서울특별시' 
group by sigunguk
order by sigunguk;

--서울시의 특정 중학교를 출력
select sigunguk,bd_name
from zipcode
where sidok = '서울특별시' 
and bd_name like '%중학교%'
group by sigunguk, bd_name
order by sigunguk;