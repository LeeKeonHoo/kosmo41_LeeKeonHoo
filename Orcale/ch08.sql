---------------------8장-------------------------

create table dept(
    dno number(2),
    dname varchar(14),
    loc varchar(13)
    );
    
create table dept2
as
select dno,dname, loc
from dept;

desc dept2;

create table dept3
as select* from dept;
desc dept3;

create table dept4(
dno1, dname1, loc1)
as select * from dept;

desc dept3;

alter table dept3
add(dno2 number(20));

desc dept4;

alter table dept3
modify dno2 number(10);
desc employee;

alter table employee
modify ename varchar2(4);

alter table dept4
modify dno1 number(2);

desc dept4;

alter table dept4
drop column britg;

alter table dept4
set unused(school);

alter table dept4
drop unused columns;

rename dept4 to dept5;

drop table dept5;
desc dept3;
insert into dept3 values (10,'회계','가산동');
commit;
select *from dept3;
truncate table dept3;
delete from dep4;

SELECT TABLESPACE_NAME, STATUS, CONTENTS FROM DBA_TABLESPACES;
SELECT tablespace_name, SUM(bytes), MAX(bytes) 
   FROM DBA_FREE_SPACE 
 GROUP BY tablespace_name;
 
 --1번
 DROP TABLE dept;
 create table dept(
    dno number(2),
    dname varchar(14),
    loc varchar(13)
    );
desc dept;

--2번
create table emp(
    eno number(4),
    ename varchar2(10),
    dno number(2)
    );
desc emp;

 --3번
 alter table dept
 modify dname varchar2(25);
desc dept;

--4번
drop table employee2;
create table employee2
as select eno as emp_id,ename as name,salary as sal,dno as dept_id
from employee;

--5번
drop table emp;

--6번
rename employee2 to emp;
select * from emp;

--7번
alter table dept
drop column dname;
select * from dept;

--8번
alter table dept
set unused(loc);
select * from dept;

--9번
alter table dept
drop unused columns;