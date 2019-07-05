create table user_trms(
userid serial primary key,
username varchar not null,
pass_word varchar not null
);

alter table user_trms add column reportsto integer;

alter table user_trms add column usertype varchar;

alter table user_trms add column available numeric (10,2) default 1000.0;

alter table user_trms add column awarded numeric (10,2) default 0.0;

alter table user_trms add column pending numeric (10,2) default 0.0;

alter table user_trms rename column usertype to title;

alter table user_trms rename column userid to employeeid;


insert into user_trms(username, pass_word) values ('toyin', 'soccer');

select * from user_trms;

insert into user_trms
values
(
default,
'Nicki',
'rapper',
null,
'Department Head- Sales')
,
(
default,
'Trevor',
'standup',
null,
'Department Head-HR');



insert into user_trms
values
(
default,
'charles',
'basketball',
null,
'Sales Supervisor');

insert into user_trms
values
(
default,
'mozart',
'concerto',
2,
'Sales Employee');

insert into user_trms
values
(
default,
'chaplin',
'comedy',
2,
'Sales Employee'),
(
default,
'albert',
'genius',
null,
'HR Supervisor');


insert into user_trms
values
(
default,
'jackson',
'thriller',
5,
'HR Employee');


insert into user_trms
values
(
default,
'Trump',
'prez',
null,
'Benco');


delete from user_trms where employeeid = 7;

select * from user_trms;

update table user_trms set pending = ? where id = ?;

--add constraint
ALTER TABLE user_trms ADD CONSTRAINT constraint_name UNIQUE (username);


ALTER TABLE public.reimbursement_trms ALTER COLUMN status SET DEFAULT 'pending-1'::character varying;

ALTER TABLE public.reimbursement_trms add COLUMN proof varchar;


select * from reimbursement_trms;

select * from reimbursement_trms where status = 'pending-1';
truncate table reimbursement_trms;


update reimbursement_trms set status = 'pending-1' where reimbursementid = 1;

select * from reimbursement_trms where reimbursementid = 2;

select reimbursementid from reimbursement_trms where employeeid in (select e.employeeid from user_trms e inner join user_trms s on e.reportsto = s.employeeid);

--This is for Supervisor
select * from reimbursement_trms where employeeid in (select e.employeeid from user_trms e inner join user_trms s on e.reportsto = s.employeeid where e.reportsto = 2);

--This is for Department HEAD
select * from reimbursement_trms where status = 'pending-2' and employeeid in (select e.employeeid from user_trms e inner join user_trms s on e.reportsto = s.employeeid);


--This is for BENCO
select * from reimbursement_trms where status = 'pending-3' and employeeid in (select e.employeeid from user_trms e inner join user_trms s on e.reportsto = s.employeeid);



--This is to select User by formid
select * from user_trms where employeeid in (select employeeid from reimbursement_trms where reimbursementid = 19);


select e.employeeid from user_trms e inner join user_trms s on e.reportsto = s.employeeid where e.reportsto =2;

create table reimbursement_trms(
reimbursementid serial primary key,
employeeid integer references user_trms (userid),
startdate date,
enddate date,
status varchar,
form_time time default current_time,
address_location varchar(50),
description varchar (200),
course_cost numeric(10,2),
grading_format varchar(50),
events varchar(50),
work_justify varchar(200),
event_attachments text);
ALTER TABLE public.reimbursement_trms ALTER COLUMN form_date TYPE date USING form_date::date;


update user_trms set reportsto = 9 where employeeid = 5;
update user_trms set reportsto = 8 where employeeid = 2;

update user_trms set reportsto = 10 where employeeid = 8;
update user_trms set reportsto = 10 where employeeid = 9;

update user_trms set title = 'HR Employee', reportsto = 5 where employeeid = 1;

update user_trms set title = 'Sales Employee', reportsto = 2 where employeeid = 3;

update user_trms set title = 'Sales Employee', reportsto = 2 where employeeid = 3;

update user_trms set title = 'Sales Employee', reportsto = 2 where employeeid = 1;

update user_trms set title = 'Sales Employee', reportsto = 2 where employeeid = 6;

update user_trms set title = 'Sales Employee', reportsto = 2 where employeeid = 9;

update user_trms set title = 'Sales Employee', reportsto = 2 where employeeid = 5;

Sales Employee

select * from user_trms;


alter table reimbursement_trms drop column form_date;

alter table reimbursement_trms add column startdate date;
alter table reimbursement_trms add column enddate date;



)
--tested unique constraint
--insert into user_trms values(default, 'toyin','soccer', 2, 'Sales Employee',default, default, default);


---testing images...

create table images_trms(imgname text, img bytea);

