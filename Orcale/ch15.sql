---프로시저 생성하기
create procedure sp_salary
is
    v_salary employee.ename%type;
begin
    select salary into v_salary
    from employee
    where ename = 'SCOTT';
    dbms_output.put_line('SCOTT 의 급여는 ' || v_salary);
 end;
/
execute sp_salary;

-------IN매개변수 사용하기
create procedure sp_salary_ename
(
    v_ename in employee.ename%type
)
is
    v_salary employee.salary%type;
begin
    select salary into v_salary
    from employee
    where ename = v_ename;
    dbms_output.put_line(v_ename || ' 의 급여는 ' || v_salary);
end;
/
execute sp_salary_ename('SCOTT');

--------OUT 매개변수 사용하기
create procedure sp_salary_ename2
(
    v_ename in employee.ename%type,
    v_salary out employee.salary%type
)
is
begin
    select salary into v_salary
    from employee
    where ename = v_ename;
end;
/
variable v_salary varchar(14);
execute sp_salary_ename2('SCOTT', :v_salary);
print v_salary;

-------------함수
create or replace function fn_salary_ename
(
    v_ename in employee.ename%type
)
    return number
is
    v_salary number(7,2);
begin
    select salary into v_salary
    from employee
    where ename = v_ename;
    return v_salary;
end;
/
variable v_salary number;
execute :v_salary :=fn_salary_ename('SCOTT');
print v_salary;

-------------SQL문에서 함수 호출하기
select ename, fn_salary_ename('SCOTT')
from employee
where ename = 'SCOTT';

----------테스트용 테이블 생성
create table dept_original
as
select * from department where 0 =1;

create table dept_copy
as
select * from department where 0=1;


----------테이블에 데이터 추가하기
INSERT INTO dept_original
values(10, 'ACCOUNTING', 'NEW YORK');

select * from dept_copy;


---------Delete 트리거 생성
create or replace trigger trigger_sample2
    after delete
    on dept_original
    for each row
begin
    DBMS_OUTPUT.PUT_LINE('Delete triger 발생');
    delete from dept_copy
        where dept_copy.dno = :old.dno;
end;
/
delete from dept_original where dno = 10;
select *from dept_copy;