 -------------------------12��-----------------------
 
 create sequence emp_eno_seq
 increment by 1
start with 1;
delete from emp_copy;

insert into emp_copy (eno,ename,job)
values(emp_eno_seq.nextval,'ȫ�浿4','����');

create eno from emp_copy;

create index job_emp_eno
on emp_copy(eno);

select sigunguk a, law_name b from zipcode
where law_name = '������';