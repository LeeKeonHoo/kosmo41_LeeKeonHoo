------------------------------11장--------------------------
create table emp_copy
as
select * from employee;

create table dept_copy
as
select * from department;

create view v_emp_copy
as
select eno,ename,job,manager,dno
from emp_copy;
desc user_views;
select view_name, text from user_views;
select *from emp_copy;
select * from v_emp_copy;
delete from v_emp_copy
where eno = 7369;

create view v_emp2
as
select a.eno, a.ename, a.salary,dno,b.dname,b.loc
from emp_copy a natural join dept_copy b;

select * from v_emp2;
create or replace view v_emp3
as
select dno,
        sum(salary) as "sal sum",
        avg(salary) as "sal avg"
        from emp_copy
        group by dno;
select dno, "sal sum",round("sal avg") from v_emp3;

create or replace view v_emp1
as
 select eno,ename, dno, job
 from emp_copy
 where job = 'MANAGER' with check option;
 
 select * from v_emp1;
 select * from emp_copy;
 
 select max(eno)+1 from employee;
 insert into v_emp1 values(7935,'전우치',10,'MANAGER');