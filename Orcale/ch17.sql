------------------------17¿Â----------------------------
desc emp_copy;
desc dept_copy;

select eno, ename, job
from emp_copy
union
select dno,dname,loc
from dept_copy;

select eno, ename, job
from emp_copy
minus
select eno,ename,job
from emp_copy2;

create table emp_copy2
as
select * from emp_copy;

select * from emp_copy2;
delete from emp_copy2
where dno=30;