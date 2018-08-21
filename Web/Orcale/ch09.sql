 ------------------9장--------------------
desc dept;
insert into dept values (1, 'Account','가산');
insert into dept (dno,dname,loc) values(2, 'Sales', '구로');
insert into dept(dno,dname) values(3,'Marktting');
insert into dept (dno,loc) values(4, '남구로');
insert into dept values (5, 'Analust',null);
select * from dept;

create table emp_copy
as
select * from employee where 0 = 1;
select count(*) from emp_copy;
INSERT INTO EMP_COPY
values(7006,'CANDY','MANAGER',7788,'18:07:19',500,NULL,10);
INSERT INTO EMP_COPY
values(7007,'CANDY','MANAGER',7788,TO_DATE('2018,07,19','YYYY,MM,DD'),500,NULL,10);
SELECT * from emp_copy;


SELECT * from emp_copy;

insert into emp_copy(eno,ename,manager)
select eno,ename,'7788' from  employee;

SELECT * from emp_copy
where ename = 'CANDY';

update emp_copy
set ename = 'CANDY1'
where ename = 'CANDY';

create table dept_copy
as
select * from department where 1= 0;
desc dept_copy;

insert into dept_copy
select *from department;

select * from dept_copy;

update dept_copy
set loc = (select loc from dept_copy
           where dno =20)
           where dno =10;
           
update dept_copy
set dname = (select dname from dept_copy
                where dno = 30),
        loc =(select loc from dept_copy
                where dno =30)
                where dno = 10;
            
select count(*) from dept_copy
where loc= 'DALLAS';

delete from dept_copy
where loc = 'CHICAHO'; 

select *
from dept_copy;
commit;

insert into dept_copy values(10, 'ACC1', 'D');
insert into dept_copy values(20, 'ACC2', 'D');
UPDATE DEPT_COPY SET LOC = 'A'
WHERE DNO = 10;
ROLLBACK;

--1번
create table emp_insert 
as select * from employee where 0=1;

--2번
select * from emp_insert;
insert into emp_insert (ename,hiredate)values('lee',SYSDATE);

--3번
insert into emp_insert (ename,hiredate) values('han',to_date('2018.07.18'));

--4번
drop table emp_copy;
select * from emp_copy;
create table emp_copy
as select * from employee;

--5번
update emp_copy
set dno = 10
where eno = 7788;

--6번
update emp_copy
set job = (select job from emp_copy
            where eno = 7499),
     salary = (select salary from emp_copy
            where eno = 7499)
            where eno = 7788;
            
--7번
update emp_copy
set dno = (select dno from emp_copy
            where eno = 7369)
where job = 'CLERK';

--8번
drop table dept_copy;
select * from dept_copy;
create table dept_copy
as select * from department;

--9번
delete dept_copy
where dname = 'RESEARCH';

--10번
DELETE dept_copy
where dno = 10
    or dno = 40;