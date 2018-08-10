--------------------------------10장---------------------------
drop table customer;
CREATE table customer(
                        id varchar2(20) unique,
                        pwd varchar2(20) not null,
                        name varchar2(20) not null,
                        phone varchar2(30),
                        address varchar2(100));
desc customer;
insert into customer (id,pwd,name, phone, address)
values('a','a','홍길동','010-9876-0307','금천구 가산동');

select *from customer;

CREATE table customer(
                        id varchar2(20) constraint customer_id_uk unique,
                        pwd varchar2(20)  not null,
                        name varchar2(20) not null,
                        phone varchar2(30),
                        address varchar2(100));

select table_name, constraint_name
from user_constraints
where table_name in('EMP_COPY');

CREATE table customer(
                        id varchar2(20) ,
                        pwd varchar2(20)  not null,
                        name varchar2(20) not null,
                        phone varchar2(30),
                        address varchar2(100),
                        constraint customer_id_pk primary key(id)
                        );


create table emp_second(
                        eno number(4) constraint enp_second_eno_pk primary key,
                        ename varchar2(10),
                        job varchar2(10),
                        dno varchar2(10)
                        constraint emp_second_dno_fk references department
                        );
                        
alter table department
add constraint department_dno_pk primary key(dno);

drop table emp_second;
create table emp_second(
                        eno number(4) constraint enp_second_eno_pk primary key,
                        ename varchar2(10),
                        job varchar2(9),
                        dno number(2)
                        constraint emp_second_dno_fk references department
                        );

INSERT INTO EMP_SECOND
values(1,'홍길동',0);

create table emp_second(
                        eno number(4) constraint enp_second_eno_pk primary key,
                        ename varchar2(10),
                        SALARY NUMBER(7,2) DEFAULT 1000
                        );
                        
INSERT INTO EMP_second(eno,ename)
values(2,'홍길동2');

select * from emp_second;

alter table enp_copy
add constraint emp_copy_eno_pk primary key (eno);
desc emp_copy;

delete from emp_copy;
insert into emp_copy
select * from employee;

alter table enp_copy
drop primary key;

create table emp
select * from employee;

create table dept
select * from department;

--1번
