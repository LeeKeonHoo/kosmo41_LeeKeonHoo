select sum(salary) as "�޿��Ѿ�",
        avg(salary) as "�޿����",
        max(salary) as "�ִ�޿�",
        min(salary) as "�ּұ޿�"
        from employee;
        
select sum(commission) as "Ŀ�̼� �Ѿ�"
from employee;

select count(*) as "����Ǽ�"
from employee
where dno in(10, 20);

select count(distinct job) as "���� ����"
from employee;

select round(avg(salary),1)
from employee
where dno =20;

select dno,round(avg(salary),1)
from employee
group by dno;

select dno,job ,count(*),sum(salary)
from employee
group by dno, job
order by dno, job;

select dno,max(salary)
from employee
group by dno
having max(salary) >= 3000;

--1��
select sum(salary) as "�޿��Ѿ�",
        round(avg(salary),0) as "�޿����",
        max(salary) as "�ִ�޿�",
        min(salary) as "�ּұ޿�"
        from employee;
        
--2��
select distinct job as "��������",
        sum(salary) as "�޿��Ѿ�",
       round(avg(salary),0) as "�޿����",
       max(salary) as "�ִ�޿�",
       min(salary) as "�ּұ޿�"
        from employee
        group by job;
        
--3��
select job,count(*) as "����Ǽ�"
from employee
group by job;

--4��
select JOB,count(*) as "�����"
from employee
where job = 'MANAGER'
GROUP BY JOB;

--5��
select (max(salary) - min(salary)) as DIFFERENCE
     from employee;
     
--6��
select job,min(salary) 
from employee
group by job
having min(salary) >= 2000 and job !='PRESIDENT'
order by min(salary) desc;
 
--7��
select dno, count(*) as "Number of People" ,round(avg(salary),2) as SALARY
from employee
group by dno;

--8��(����)
select dno, 
        decode(dno,10,'ACCOUNTING',
                    20,'RESCARCH',
                    30,'SALES',
                    40,'OPERATIONS')AS LOCATION,
        count(*) as "Number of People" ,round(avg(salary),2) as SALARY
from employee
group by dno;

--9��(����)
select JOB,dno,
nvl(decode(dno,10,sum(salary)),0) as "�μ� 10",
nvl(decode(dno,20,sum(salary)),0) as "�μ� 20",
nvl(decode(dno,30,sum(salary)),0) as "�μ� 30",
sum(salary) as �Ѿ�
FROM EMPLOYEE
GROUP BY JOB,dno
order by job,dno;

--������� ��� ���� ���
select sigunguk
from zipcode
where sidok = '����Ư����'
group by sigunguk
order by sigunguk;

--������� Ư�� ���̸��� ���
select sigunguk,count(distinct law_name)
from zipcode
where sidok = '����Ư����' 
group by sigunguk
order by sigunguk;

--������� Ư�� ���б��� ���
select sigunguk,bd_name
from zipcode
where sidok = '����Ư����' 
and bd_name like '%���б�%'
group by sigunguk, bd_name
order by sigunguk;