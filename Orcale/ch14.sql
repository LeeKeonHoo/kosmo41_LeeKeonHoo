---------------14장-----------------

set serveroutput on
begin
dbms_output.put_line('Hello');
end;
/
@c:\temp\hello.sql;

set serveroutput on
declare
    v_eno   number(4);
    v_ename employee.ename%type;
begin
    v_eno :=7788;
    v_ename := 'SCOTT';
    dbms_output.put_line('사원번호  사원이름');
    dbms_output.put_line('------------------');
    dbms_output.put_line(v_eno|| '     ' || v_ename);
end;
/

@c:\temp\hello2.sql;

set serveroutput on
declare
    v_eno   number(4);
    v_ename employee.ename%type;
begin
    dbms_output.put_line('사원번호  사원이름');
    dbms_output.put_line('------------------');
    
    select eno,ename into v_eno, v_ename
    from employee
    where ename = 'SCOTT';
    
    dbms_output.put_line(v_eno|| '     ' || v_ename);
end;
/

@c:\temp\hello3.sql;

set serveroutput on
declare
    v_employee employee%rowtype;
    temp   number(4) := 1;
    annsal number(7,2);
begin
    select * into v_employee
    from employee
    where ename = 'SCOTT';
    
    if(v_employee.commission is null)then
        v_employee.commission := 0;
        end if;
        
        annsal := v_employee.salary * 12 + v_employee.commission;
        dbms_output.put_line('사원번호  사원이름    연봉');
        dbms_output.put_line('---------------------------------');
        dbms_output.put_line(v_employee.eno|| '     ' ||
                             v_employee.ename || '      '||
                             annsal);
end;
/
@c:\temp\hello4.sql;

select eno, ename, job
from emp_copy2
minus
select eno,ename,job
from emp_copy;

set serveroutput on
declare
     v_eno employee.eno%type;
     v_ename employee.ename%type;
     v_dno employee.dno%type;
     v_dname varchar2(20) := null;
begin
select eno,ename,dno
into v_eno,v_ename,v_dno
from employee
where ename = 'SCOTT';

if(v_dno = 10) then
    v_dname := 'ACCOUNTING';
elsif(v_dno = 20) then
    v_dname := 'RESEARCH';
elsif(v_dno = 30) then
    v_dname := 'SALES';
elsif(v_dno = 40) then
    v_dname := 'OPERATIONS';
end if;
        dbms_output.put_line('사원번호  사원이름    부서명');
        dbms_output.put_line('---------------------------------');
        dbms_output.put_line(v_eno|| '     ' ||
                             v_ename || '      '||
                             v_dname);
end;
/

set serveroutput on
declare
    dan number :=2;
    i number :=1;
begin
    loop
    dbms_output.put_line(dan || '*' || i || '=' || (dan*i) );
    i :=i+1;
    if i>9 then
           exit;
     end if;
    end loop;
end;
/

set serveroutput on
declare
    dan number :=2;
    i number :=1;
begin
    for i in 1 .. 9 loop
        dbms_output.put_line(dan || '*' || i || '=' || (dan*i) );
    end loop;
end;
/

set serveroutput on
declare
    dan number :=2;
    i number :=1;
begin
    while i <= 9 loop
    dbms_output.put_line(dan || '*' || i || '=' || (dan*i) );
    i := i+1;
    end loop;
end;
/

set serveroutput on
declare
    v_dept  department%rowtype;
    cursor c1
        is
        select * from department;
begin
        dbms_output.put_line('사원번호  사원이름    부서명');
        dbms_output.put_line('---------------------------------');
        open c1;
        loop
            fetch c1 into v_dept.dno, v_dept.dname, v_dept.loc;
            exit when c1 %notfound;
            dbms_output.put_line(v_dept.dno|| '     ' ||
                             v_dept.dname || '      '||
                             v_dept.loc);
    end loop;
    close c1;
end;
/

select eno, ename, job
from emp_copy2
minus
select eno,ename,job
from emp_copy;
    v_dept  department%rowtype;
    cursor c1
        is
        select * from department;
begin
        dbms_output.put_line('사원번호  사원이름    부서명');
        dbms_output.put_line('---------------------------------');
        for v_dept in c1 loop
            exit when c1 %notfound;
            dbms_output.put_line(v_dept.dno|| '     ' ||
                             v_dept.dname || '      '||
                             v_dept.loc);
    end loop;
end;
/

--1번
set serveroutput on
declare
     v_eno employee.eno%type;
     v_ename employee.ename%type;
     v_dno employee.dno%type;
     v_dname varchar2(20) := null;
begin
select eno,ename,dno
into v_eno,v_ename,v_dno
from employee
where ename = 'KING';

if(v_dno = 10) then
    v_dname := 'ACCOUNTING';
elsif(v_dno = 20) then
    v_dname := 'RESEARCH';
elsif(v_dno = 30) then
    v_dname := 'SALES';
elsif(v_dno = 40) then
    v_dname := 'OPERATIONS';
end if;
        dbms_output.put_line('사원번호  사원이름    부서명    부서번호');
        dbms_output.put_line('---------------------------------');
        dbms_output.put_line(v_eno|| '     ' ||
                             v_ename || '      '||
                             v_dname||'         '||
                            v_dno);
end;
/

--2번
set serveroutput on
declare
    dan number :=0;
    i number :=1;
begin
    loop
    dbms_output.put_line(dan || '+' || i || '=' || (dan+i) );
    dan := dan+i;
    i :=i+1;
    if i>10 then
           exit;
     end if;
    end loop;
end;
/

--3번
set serveroutput on
declare
    dan number :=0;
    i number :=1;
begin
    for i in 1 .. 10 loop
        dbms_output.put_line(dan || '+' || i || '=' || (dan+i) );
    dan := dan+i;
    end loop;
end;
/

--4번

set serveroutput on
declare
    dan number :=0;
    i number :=1;
begin
    while i <= 10 loop
    dbms_output.put_line(dan || '+' || i || '=' || (dan+i) );
    dan :=dan +i;
    i := i+1;
    end loop;
end;
/

--5번        CURSOR 사용해야함,   풀어야함    장나눠서 저장하기
set serveroutput on
declare
    v_emp employee%rowtype;
    cursor c1
    is
    select * from employee;
begin
        dbms_output.put_line('사원번호  사원이름    연봉');
        dbms_output.put_line('---------------------------------');
    open c1;
    loop
        fetch c1 into v_emp.eno, v_emp.ename,v_emp.salary,v_emp.commission;
        where commission is not null;
        exit when c1 %notfound;
        dbms_output.put_line(v_emp.eno|| '     ' ||
                             v_emp.ename || '      '||
                             v_emp.salary || '      '||
                             v_emp.commission);
    end loop;
    close c1;
end;
/
select *from employee;
--6번
set serveroutput on
declare
    dan number :=2;
    i number :=1;
begin
    for dan in 2 .. 9 loop
    for i in 1 .. 9 loop
        dbms_output.put_line(dan || '*' || i || '=' || (dan*i) );
    end loop;
    dbms_output.put_line('');
    end loop;
end;
/
