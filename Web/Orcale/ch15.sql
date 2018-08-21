---���ν��� �����ϱ�
create procedure sp_salary
is
    v_salary employee.ename%type;
begin
    select salary into v_salary
    from employee
    where ename = 'SCOTT';
    dbms_output.put_line('SCOTT �� �޿��� ' || v_salary);
 end;
/
execute sp_salary;

-------IN�Ű����� ����ϱ�
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
    dbms_output.put_line(v_ename || ' �� �޿��� ' || v_salary);
end;
/
execute sp_salary_ename('SCOTT');

--------OUT �Ű����� ����ϱ�
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

-------------�Լ�
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

-------------SQL������ �Լ� ȣ���ϱ�
select ename, fn_salary_ename('SCOTT')
from employee
where ename = 'SCOTT';

----------�׽�Ʈ�� ���̺� ����
create table dept_original
as
select * from department where 0 =1;

create table dept_copy
as
select * from department where 0=1;


----------���̺� ������ �߰��ϱ�
INSERT INTO dept_original
values(10, 'ACCOUNTING', 'NEW YORK');

select * from dept_copy;


---------Delete Ʈ���� ����
create or replace trigger trigger_sample2
    after delete
    on dept_original
    for each row
begin
    DBMS_OUTPUT.PUT_LINE('Delete triger �߻�');
    delete from dept_copy
        where dept_copy.dno = :old.dno;
end;
/
delete from dept_original where dno = 10;
select *from dept_copy;