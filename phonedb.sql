--테이블 삭제
delete from phonedb;

drop table phonedb;

--시퀀스 삭제
drop sequence seq_person_id;

--테이블 생성
create table phonedb(
    person_id number(10),
    name varchar2(50),
    hp varchar2(50),
    company varchar2(50)
);

--시퀀스 생성
create sequence seq_person_id
increment by 1
start with 1;

--insert문
insert into phonedb
values(seq_person_id.nextval, '이효리', '010-1111-1111', '02-1111-1111');

insert into phonedb
values(seq_person_id.nextval, '정우성', '010-2222-2222', '02-2222-2222');

insert into phonedb
values(seq_person_id.nextval, '유재석', '010-3333-3333', '02-3333-3333');

insert into phonedb
values(seq_person_id.nextval, '이정재', '010-4444-4444', '02-4444-4444');

insert into phonedb
values(seq_person_id.nextval, '서장훈', '010-5555-5555', '02-5555-5555');


--select문
select person_id,
       name,
       hp,
       company
from phonedb;

--update문
update phonedb
set name = '유정재',
    hp = '010-1234-5678',
    company = '02-9876-5432'
where person_id = 4;

--delete문
delete from phonedb
where person_id = 2;

commit;