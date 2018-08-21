---------------------13¿Â------------------

create user test02 identified by 0000;
grant create session to test02;
grant select on scott.employee to test01;
revoke select on scott.employee from test01;

create view emp_view
as
select eno,ename,job from employee;
grant select on scott.emp_view to test01;

grant select on scott.emp_view to test01 with grant option;

create role kosmo41;
grant create session to kosmo41;
grant select on scott.emp_view to kosmo41;

grant kosmo41 to test02;

create synonym enp1 for scott.emp_view;
GRANT CREATE SYNONYM TO test01;