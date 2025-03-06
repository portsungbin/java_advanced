use ssgdb;

-- 뷰 (view) : 일반 사용자 입장에서는 테이블과 동일하게 사용하는 객체이다.
-- 뷰는 한번 생성해 놓으면 테이블처럼 사용가능한 객체이다.

select userid, name, addr from usertbl;

create view v_usertbl as select userid, name, addr from usertbl;
-- 뷰에 대한 접근권한은 주지만 테이블에 대한 접근권한은 주지 않는다
select * from v_usertbl; -- view 는 읽기 전용 테이블이다. 뷰는 수정은 가능하지만 권장하지 않는다.


-- 물건을 구매한 회원들의 리스트 출력
                         create view v_userbuytbl as
                            select u.userid, u.name, u.addr from usertbl u join buytbl b on u.userID = b.userID;
select * from v_userbuytbl where name = '김범수';

drop view v_userbuytbl;

-- 테이블 스페이스 (테이블이 저장되는 물리적 공간을 '테이블 스페이스' 라고함)
-- 대용량의 데이터를 다룰 때 성능 향상을 위해 테이블 스페이스에 대한 설정 방법을 알아야함.
-- 데이터베이스는 테이블 논리적 공간으로 다루며, 테이블 스페이스는 실제로 데이터가 저장되는 물리적 공간을 의미한다.
show variables like 'innodb_data_file_path';


-- 대용량의 데이터를 운영한다고 가정하고, 테이블 스페이스를 분리해서 설정하는 방법에 대해 알아보자.

-- 1. innodb_file_per_table 상태정보를 on으로 설정
show variables like 'innodb_file_per_table';

-- 테이블 스페이스 설정 (root 에서 작업해야함)
create tablespace ts_a add datafile 'ts_a.ibd';
create tablespace ts_b add datafile 'ts_b.ibd';
create tablespace ts_c add datafile 'ts_c.ibd';


create table table_a (id int) tablespace ts__a;
alter table table_a tablespace ts__b;

create tablespace table_c (select * from sakila.customer);





