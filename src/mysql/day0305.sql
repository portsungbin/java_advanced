use ssgdb;
-- 샘플데이터 생성
create table code1(cId int, cName varchar(20));
select * from code1;
insert into code1 values (1, '프론트 디자이너');

drop procedure p_insertcodes;

delimiter $$
create procedure p_insertcodes(in cdata varchar(255), in cTName varchar(255))
begin
    -- 쿼리문 생성
    set @strsql = concat(
                  'insert into ', cTName, ' (cId, cName)', ' select coalesce(max(cId),0) + 1 , ? from ', cTName
                  );

    -- 바인딩할 변수 설정
    set @cdata = cdata;
    -- set resultMsg = 'insert Success';

    prepare stmt from @strsql;
    execute stmt using @cdata;
    deallocate prepare stmt;

    -- 트랜잭션 확정
    commit;

end $$
delimiter ;

call p_insertcodes('백엔드 자바 개발자', 'code1');
select * from code1;


delimiter $$
create procedure p_insertresultcodes(in cdata varchar(255), in cTName varchar(255), out resultMsg varchar(255))
begin
    -- 쿼리문 생성
    set @strsql = concat(
            'insert into ', cTName, ' (cId, cName)', ' select coalesce(max(cId),0) + 1 , ? from ', cTName
                  );

    -- 바인딩할 변수 설정
    set @cdata = cdata;
    set resultMsg = 'insert Success';

    prepare stmt from @strsql;
    execute stmt using @cdata;
    execute stmt using @resultMsg;
    deallocate prepare stmt;

    -- 트랜잭션 확정
    commit;

end $$
delimiter ;

-- 테이블 생성
CREATE TABLE TB_MEMBER (
                           m_seq INT AUTO_INCREMENT PRIMARY KEY,  -- 자동 증가 시퀀스
                           m_userid VARCHAR(20) NOT NULL,
                           m_pwd VARCHAR(20) NOT NULL,
                           m_email VARCHAR(50) NULL,
                           m_hp VARCHAR(20) NULL,
                           m_registdate DATETIME DEFAULT NOW(),  -- 기본값: 현재 날짜와 시간
                           m_point INT DEFAULT 0
);

-- TB_MEMBER 테이블에 callableStemEx03 클래스 작성하여서 SP_MEMBER_INSERT PROCEDURE 를 CALL 하여 회원을 입력하도록 작성해주세요
-- 입력성공시 '회원 정보가 안전하게 저장되었습니다.' 메세지 출력!

drop procedure SP_MEMBER_INSERT;

delimiter $$
create procedure SP_MEMBER_INSERT(
    in m_userid varchar(255),
    in m_pwd varchar(255),
    in m_email varchar(255),
    in m_hp varchar(255),
    in cTName varchar(255),
    out resultMsg varchar(255))
begin
    -- 쿼리문 생성
    set @strsql = concat(
            'insert into ', cTName, ' (m_userid, m_pwd, m_email, m_hp)',
            'values(?,?,?,?)'
                  );

    -- 바인딩할 변수 설정
    set @m_userid = m_userid;
    set @m_pwd = m_pwd;
    set @m_email = m_email;
    set @m_hp = m_hp;
    set resultMsg = 'insert Success';

    prepare stmt from @strsql;
    execute stmt using @m_userid, @m_pwd, @m_email, @m_hp;
    deallocate prepare stmt;

    -- 트랜잭션 확정
    commit;

end $$
delimiter ;

select * from TB_MEMBER;



drop procedure SP_MEMBER_LIST;

delimiter $$
create procedure SP_MEMBER_LIST()
begin
    -- 쿼리문 생성
    set @strsql = concat('select * from TB_MEMBER');


    prepare stmt from @strsql;
    execute stmt;
    deallocate prepare stmt;

    -- 트랜잭션 확정
    commit;

end $$
delimiter ;

drop table if exists jepum;

create table jepum (
    code varchar(3) not null ,
    bno integer not null ,
    date datetime not null ,
    status varchar(5) not null
);

alter table jepum -- 테이블을 일단 만들고 alter로 primary key를 만드는게 더 효율적이다
    add constraint pk_jepum_code_bno
        primary key (code, bno);

show index from jepum; -- 테이블의 인덱스 정보 확인 (키, 컬럼네임, 테이블 등등..)


insert into jepum values ('AAA', 0001, '2023.10.10', '판매완료'),
                         ('AAA', 0002, '2023.10.11', '매장진열'),
                         ('BBB', 0001, '2023.10.12', '재고창고'),
                         ('CCC', 0001, '2023.10.13', '판매완료'),
                         ('CCC', 0002, '2023.10.14', '매장진열');

select * from jepum;