------------------------6��--------------------------------
select * from employee, department;


select *
from employee, department
where employee.dno = department.dno;

select employee.eno, employee.ename,
 department.dname, department.dno
 from employee, department
 where employee.dno = department.dno;

select e.eno, e.ename,
 d.dname, d.dno
 from employee e, department d
 where e.dno = d.dno
 and d.dno = 20;
 
  select e.eno, e.ename, d.dname, dno
 from employee e natural join department d
 where e.eno=7788;
 
 select * from employee a natural join salgrade b;
 
 select e.eno, e.ename, d.dname, dno
 from employee e join department d
 using(dno)
 where e.eno=7788;
 
 select a.ename, b.dname, a.salary, c.grade
 from employee a, department b,salgrade c
 where a.dno = b.dno
and a.salary between c.losal and c.hisal;

select a.eno, a.ename, a.manager , b.ename
from employee a, employee b
where a.manager = b.eno;

select a.ename ||'�� ���� �����' || b.ename
from employee a join employee b
on a.manager = b.eno(+);

--1��
select employee.dno , dname
from employee, department
where employee.dno = department.dno
and employee.ename LIKE 'SCOTT';

--2��
select e.eno, e.ename, d.loc, d.dname
from employee e join department d
on e.dno = d.dno
where e.ename = 'SCOTT';

--3��
select *
from employee e join department d
using(dno)
where dno =10;

--4��
select e.ename, dno, d.loc,nvl(e.commission,0)
from employee e natural join department d
where e.commission > 0;

--5��
select e.ename, d.dname
from employee e,department d
where e.ename like '%A%';

--6��
select e.ename,e.job,dno,d.dname
from employee e natural join department d
where d.loc = 'NEW YORK';

--7��
select e.ename as "Employee Emp#", e.eno,
        d.ename as "Manager Mgr#", d.eno
from employee e,employee d
where e.manager = d.eno;

--8��
select *
from employee e ,employee d
where e.manager = d.dno(+)
order by e.eno desc;

--9��
select  e.ename as "�̸�",
        d.dno as "�μ���ȣ",
        d.ename as "����"
from employee e,employee d
where d.dno = e.dno;

--10��
select e.ename,e.hiredate
from employee e, employee d
where d.hiredate > e.hiredate;

select SIDOK, SIGUNGUK, DOROK,
       TRANSLATE(DOROK, '1234567890'||DOROK, '1234567890') A,
       NVL(TRANSLATE(DOROK, '1234567890'||DOROK, '1234567890'), 0) B,
       TO_NUMBER(NVL(TRANSLATE(DOROK, '1234567890'||DOROK, '1234567890'), 0)) as order1
 from zipcode
 where DOROK like '%�������%'
 group by SIDOK, SIGUNGUK, DOROK
 order by order1;