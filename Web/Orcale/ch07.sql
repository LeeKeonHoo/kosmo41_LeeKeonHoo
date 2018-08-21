----------------------------7��----------------------------
select ename,salary
from employee
where salary >(select salary
            from employee
            where ename ='SCOTT');
            
select ename,salary
from employee
WHERE SALARY >(3000);            

select a.ename,a.dno, b.dname
from employee a, department b
where a.dno >(select dno
            from employee
            where ename ='SCOTT')
            and a.dno =b.dno
            and a.ename != 'SCOTT';

select a.eno,a.ename,a.salary, b.dname
from employee a,department b
where a.dno = b.dno
and salary in(select min(salary)
                from employee
                group by dno);
                
select eno,ename, job, salary
from employee
where job <> 'SALESMAN'
and salary < any(500,900,1000);

select salary
from employee
where job <> 'SALESMAN'
and salary<any(select salary
                from employee
                where job = 'SALESMAN');
                
select eno,ename,job,salary
from employee
where job <> 'SALESMAN'
and salary<all(select salary
                from employee
                where job = 'SALESMAN');
                
--1��
select ename,job
from employee
where job = (select job
            from employee
            where eno = 7788);
            
--2��
select ename, job
from employee
where salary >(select salary
            from employee
            where eno = 7499);
            
--3��
select ename, job,salary
from employee
where salary in(select min(salary)
                from employee);
            
--4��(����,��ǰ)
select job,round(avg(salary))
from employee
group by job
having round(avg(salary)) = (select job,min(round(avg(salary)))
                from employee );

--5��
select ename,salary,dno
from employee
where salary in(select min(salary)
                from employee
                 group by dno)
order by dno;
            
--6��
select eno, ename, job, salary
from employee
where job <> 'ANALYST'
and salary<  (select min(salary)
              from employee
              where job = 'ANALYST');
                
--7��(����)
select ename,eno
from employee
where eno not in (select nvl2(manager,manager,0)
                    from employee);

--8��(����)
select ename,eno
from employee
where eno in (select nvl2(manager,manager,0)
               from employee);

--9��
select ename, hiredate
from employee
where ename <> 'BLAKE'
and dno = (select dno
            from employee
            where ename = 'BLAKE');
            
--10��
select eno, ename
from employee
where salary > (select avg(salary)
                from employee)
order by salary asc;

--11��
select eno, ename
from employee
where dno  in (select dno
             from employee
             where ename like '%K%');
             

--12��
select ename, dno, job
from employee
where dno = (select dno 
            from department 
            where loc='DALLAS');

--13��
select dno, ename, job
from employee
where manager = (select eno
                from employee
                where ename = 'KING');

--14��
select dno, ename, job
from employee
where dno = (select dno
                from department
                where dname ='RESEARCH');
                
--15��
select eno, ename, salary
from employee
where salary >(select avg(salary)
                from employee)
and ename in (select ename
            from employee
            where ename like '%K%');
            
--16��
select job,avg(salary)
from employee
group by job
having avg(salary) = (select min(avg(salary))
                        from employee
                        group by job);

--17��
select eno,ename
from employee
where dno in(select dno
                from employee
                where job = 'ANALYST');