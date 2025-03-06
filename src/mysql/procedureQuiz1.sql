use ssgdb;
drop table usertbl;
CREATE TABLE usertbl -- 회원 테이블
( userID  	CHAR(8) NOT NULL PRIMARY KEY, -- 사용자 아이디(PK)
  name    	VARCHAR(10) NOT NULL, -- 이름
  birthYear   INT NOT NULL,  -- 출생년도
  addr	  	CHAR(2) NOT NULL, -- 지역(경기,서울,경남 식으로 2글자만입력)
  mobile1	CHAR(3), -- 휴대폰의 국번(011, 016, 017, 018, 019, 010 등)
  mobile2	CHAR(8), -- 휴대폰의 나머지 전화번호(하이픈제외)
  height    	SMALLINT,  -- 키
  mDate    	DATE  -- 회원 가입일
);

CREATE TABLE buytbl -- 회원 구매 테이블(Buy Table의 약자)
(  num 		INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
   userID  	CHAR(8) NOT NULL, -- 아이디(FK)
   prodName 	CHAR(6) NOT NULL, --  물품명
   groupName 	CHAR(4)  , -- 분류
   price     	INT  NOT NULL, -- 단가
   amount    	SMALLINT  NOT NULL, -- 수량
   FOREIGN KEY (userID) REFERENCES usertbl(userID)
);

INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');
INSERT INTO usertbl VALUES('JYP', '조용필', 1950, '경기', '011', '4444444', 166, '2009-4-4');
INSERT INTO usertbl VALUES('SSK', '성시경', 1979, '서울', NULL  , NULL      , 186, '2013-12-12');
INSERT INTO usertbl VALUES('LJB', '임재범', 1963, '서울', '016', '6666666', 182, '2009-9-9');
INSERT INTO usertbl VALUES('YJS', '윤종신', 1969, '경남', NULL  , NULL      , 170, '2005-5-5');
INSERT INTO usertbl VALUES('EJW', '은지원', 1972, '경북', '011', '8888888', 174, '2014-3-3');
INSERT INTO usertbl VALUES('JKW', '조관우', 1965, '경기', '018', '9999999', 172, '2010-10-10');
INSERT INTO usertbl VALUES('BBK', '바비킴', 1973, '서울', '010', '0000000', 176, '2013-5-5');
INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(NULL, 'KBS', '노트북', '전자', 1000, 1);
INSERT INTO buytbl VALUES(NULL, 'JYP', '모니터', '전자', 200,  1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '모니터', '전자', 200,  5);
INSERT INTO buytbl VALUES(NULL, 'KBS', '청바지', '의류', 50,   3);
INSERT INTO buytbl VALUES(NULL, 'BBK', '메모리', '전자', 80,  10);
INSERT INTO buytbl VALUES(NULL, 'SSK', '책'    , '서적', 15,   5);
INSERT INTO buytbl VALUES(NULL, 'EJW', '책'    , '서적', 15,   2);
INSERT INTO buytbl VALUES(NULL, 'EJW', '청바지', '의류', 50,   1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(NULL, 'EJW', '책'    , '서적', 15,   1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '운동화', NULL   , 30,   2);
commit;


SELECT * FROM usertbl;
SELECT * FROM buytbl;


-- 1.1 userTbl테이블을 대상으로 1개의 이름을 입력하여 해당 회원의 정보를 출력하는 프로시저를 작성하고 실행시키세요  '조관우' 회원의 정보를 출력하세요
delimiter $$
create procedure userTbl1(d_name varchar(10))
begin
    select * from usertbl where name = d_name;
end $$
delimiter ;

call userTbl1('조관우');


-- 1.2 userTbl 테이블  : 회원중 출생년도가 1970 이후 출생자이면서 키가 178 초과 인 회원의 정보를 출력하는 프로시저를 작성하고 실행시키세요
delimiter $$
create procedure userTbl2(year integer, h_height smallint)
begin
    select * from usertbl where birthYear > year and height > h_height;
end $$
delimiter ;

call userTbl2(1970, 178);

-- 1.3 usertbl 테이블 :  1980년 이후 출생자에게는 "고객님 건강보험 생애 전환 서비스 가입에 해당하지 않습니다." 1980년 이전 출생자들에게는 "고객님 건강보험 생애 전환 서비스 가입에 해당하오니 가입해 주시길 바랍니다." 출력하는 프로시저 작성

-- drop procedure if exists userTbl3  -- 만약 유저테이블3이 있다면 지우고 실행해달라!!!!! 항상 실행해서 체크
delimiter $$
create procedure userTbl3(in userName varchar(20))
begin
    declare
        byear int;

    select birthyear into byear from usertbl where name = userName;
    if(byear >= 1980) then select '고객님 건강보험 생애 전환 서비스 가입에 해당하지 않습니다.';
    else
        select '고객님 건강보험 생애 전환 서비스 가입에 해당하오니 가입해 주시길 바랍니다.';
    end if;
end $$
delimiter ;

call usertbl3('은지원');


-- 1.4 while문을 활용하여 구구단을 문자열로 생성해서 테이블에 입력하는 프로시저를 작성해 보자
-- 기존 테이블이 있으면 삭제
DROP TABLE IF EXISTS guguTBL;
CREATE TABLE guguTBL (
    result VARCHAR(255) -- 문자열 저장을 위해 충분한 크기로 설정
);

drop procedure if exists gugudanTBL;
delimiter $$
create procedure gugudanTBL()
begin
    declare i int; -- 구구단 앞자리
    declare j int; -- 구구단 뒷자리
    declare strsum varchar(100); -- 각 단을 문자열로 저장

    set i = 2;

    while (i < 10) do -- 2단 ~ 9단까지 반복문
        set strsum = '';
        set j = 1; -- 구구단 뒤 숫자 2 x 1 부터 9까지
        while(j < 10) do
            set strsum = concat(strsum, ' ', i, ' x ', j, ' = ', i*j); -- 결과물 출력
            set j = j+1;
            end while;
            set i = i+1;
            insert into guguTBL values (strsum);

    end while;

end $$
delimiter ;

call gugudanTBL();
select * from guguTBL;


-- 4-1 1~100까지 합계를 구하는 totalsum 프로시저를 작성 출력 포멧은 '1-100의 총항은 5050입니다'
drop procedure if exists totalsum;
delimiter $$
create procedure totalsum()
begin
    declare i int default 1;
    declare sum int default 0;
    declare strsum varchar(10);


    while (i <= 100) do
    set sum = sum + i;
    set i = i+1;
        end while;

    select concat('1~100까지 총합은 ', sum,'입니다.');

end $$
delimiter ;

call totalsum();


-- 1.5 DECARE~ HANDLER 를 이용해서 오류처리 구문을 추가해 보자 . ex) 1부터 숫자를 더하여 합계가 정수형(int)데이터 형식의 오버플로우가 발생하면 멈추고 오류처리를 해보자
drop procedure if exists oruu;
delimiter $$
create procedure oruu()
begin
    declare i int; -- 1씩 증가하는값
    declare result int; -- 합계(정수형). 오버플로 발생시킬 예정
    declare savepointResult int; -- 오버플로 직전의 값 저장

    declare exit handler for 1264 -- int형 오버플로가 발생하면 해당 부분 수행 1264는 정해져 있는 오버플로
    begin
        select concat('int 오버플로 직전의 합계 --> ', savepointResult);
        select concat('1+2+3+.....+ ', i , '= 오버플로');

    end;

    set i = 1; -- i 를 1로 초기화
    set result = 0; -- 합계 0 초기화

    while (true) do -- 무한루프
        set savepointResult = result; -- 오버플로 직전의 합을 저장하기 위해
        set result = result + i;
        set i = i +1;

    end while;

end $$
delimiter ;

call oruu();

-- 1.6 현재 저장된 프로시저의 이름과 내용을 확인해 보자
use information_schema;
select routine_name, ROUTINES.ROUTINE_DEFINITION from information_schema.ROUTINES
where ROUTINE_SCHEMA = 'ssgdb' and ROUTINE_TYPE = 'PROCEDURE';

-- 1.7 파라미터도 확인해 보자 ?? 이건 잘 모르겠음
select parameter_mode, parameter_name, DTD_IDENTIFIER from information_schema.PARAMETERS
where SPECIFIC_NAME = 'oruu';

-- 1.8 테이블 이름을 파라미터로 전달해 보자

    delimiter $$
    create procedure nameTblProc(in tblname varchar(20))
        begin
            select * from tblname;

    end $$
    delimiter ;

    call nameTblProc('usertbl'); -- mysql 은 직접 테이블 이름을 파라미터로 사용할 수 없어서 밑에처럼 해야한다

delimiter $$
create procedure nameTblProc(in tblname varchar(20))
begin
    set @sqlQuery = concat ('select * from ', tblname);
    prepare myQuery from @sqlQuery;
    EXECUTE myQuery;
    deallocate prepare myQuery;

end $$
delimiter ;




-- 1.9 배송담당자는 사용자의 정보를 접근할 수 있는 프로시저(delivProc)를 이용하여 사용자의 주소와 이름을 확인한다.
    -- userID, name, addr, mobile1, mobile2 만 접근해서 사용자의 정보를 조회할 수 있는 delivProc 작성하세요
    -- 배송담당자는 사용자의 아이디로 회원의 정보를 접근할 수 있다.

delimiter $$
create procedure delivProc(in id varchar(20))
begin
    select usertbl.userID, usertbl.name,usertbl.addr, usertbl.mobile1,usertbl.mobile2 from usertbl where userID = id;

end $$
delimiter ;

call delivProc('LJB');


-- --------스토어드 함수
-- 덧셈
drop function if exists userFunc;
delimiter $$
create function userFunc(value1 int, value2 int)
    returns int
begin
    return value1 + value2;
end $$
delimiter ;

select userFunc(100, 200);

-- 출생년도 입력하면 나이 출력되는 함수
drop function if exists getAgeFunc;
delimiter $$
create function getAgeFunc(bYear int)
    returns int
begin
    declare age int;
    set age = year(curdate()) - bYear;
    return age;
end $$
delimiter ;

select getAgeFunc(1999);


drop procedure if exists cursorProc;
delimiter $$
create procedure cursorProc()
begin
    declare userHeight int;
    declare cnt int default 0;
    declare totalHeight int default 0;

    declare endOfRow boolean default FALSE;

    declare userCuror CURSOR FOR -- 커서 선언
    select height from usertbl;

    declare CONTINUE HANDLER
        FOR NOT FOUND SET endOfRow = TRUE;

    OPEN userCuror;

    cursor_loop: LOOP
        fetch userCuror INTO userHeight;

        if endOfRow THEN
            LEAVE cursor_loop;
        end if;

        set cnt = cnt + 1;
        set totalHeight = totalHeight + userHeight;
    end loop cursor_loop;

    select concat('고객 키의 평균 --> ', (totalHeight/cnt))

    CLOSE userCuror;

end $$
delimiter ;

call cursorProc();

-- 트리거 실습
use ssgdb;
create table if not exists testTBL(id int, txt varchar(20));
insert into testTBL values (1, '레드벨벳');
insert into testTBL values (2, '잇지');
insert into testTBL values (3, '블랙핑크');

delimiter //
create trigger testTrg
    after delete
    on testTBL
    for each row
begin
    set @msg = '가수 그룹이 삭제됨';
end //

delimiter ;


set @msg = '';
insert into testTBL values (4, '마마무');
select @msg;
update testTBL set txt = '블핑' where id = 3;
select @msg;
delete from testTBL where id = 4;
select @msg;

drop table buyTbl;
create table backup_userTbl(
    userID char(8) not null primary key,
    name varchar(10) not null,
    birthYear int not null,
    addr char(2) not null,
    mobile1 char(3),
    mobile2 char(8),
    height smallint,
    mDate date,
    modType char(2),
    modDate date,
    modUser varchar(256)
);

drop trigger if exists backUserTbl_UpdateTrg;
delimiter //
create trigger backUserTbl_UpdateTrg
    after update
    on usertbl
    for each row
begin
    insert into backup_userTbl values (OLD.userID, OLD.name, OLD.birthYear, OLD.addr, OLD.mobile1, OLD.mobile2,OLD.height,OLD.mDate,
                                       '수정', curdate(), current_user());
end //
delimiter ;

drop trigger if exists backUserTbl_DeleteTrg;
delimiter //
create trigger backUserTbl_DeleteTrg
    after delete
    on usertbl
    for each row
begin
    insert into backup_userTbl values (OLD.userID, OLD.name, OLD.birthYear, OLD.addr, OLD.mobile1, OLD.mobile2,OLD.height,OLD.mDate,
                                       '삭제', curdate(), current_user());
end //
delimiter ;

update usertbl set addr = '몽고' where userID = 'JKW';
delete from userTbl where height >= 177;
desc usertbl;
select * from backup_userTbl;

truncate table usertbl;
select * from backup_userTbl;


drop trigger if exists usertbl_InsertTrg;
--  이 문장이 insert를 rollback을 시켜 insert가 실행이 되지 않음
delimiter //
create trigger userTbl_InsertTrg
    after INSERT
    on usertbl
    for each row
begin
    signal sqlstate '45000'
    set message_text = '데이터의 입력을 시도했습니다. 귀하의 정보가 서버에 기록되었습니다.';
end //
delimiter ;

insert  into usertbl values ('ABC', '에비씨', 1977, '서울', '011',
                             '1111111', 181, '2019-12-25');
select * from usertbl;


use ssgdb;
DROP TRIGGER IF EXISTS userTbl_BeforeInsertTrg;
DELIMITER //

CREATE TRIGGER userTbl_BeforeInsertTrg
    BEFORE INSERT
    ON usertbl
    FOR EACH ROW
BEGIN
    -- 출생 연도가 1900 미만이면 0으로 설정
    IF NEW.birthYear < 1900 THEN
        SET NEW.birthYear = 0;

        -- 출생 연도가 현재 연도보다 크면 현재 연도로 설정
    ELSEIF NEW.birthYear > YEAR(CURDATE()) THEN
        SET NEW.birthYear = YEAR(CURDATE());
    END IF;
END //

DELIMITER ;



INSERT INTO usertbl VALUES ('AAA', '에이', 1877, '서울', '011', '1112222',
                            181, '2022-12-25');

INSERT INTO usertbl VALUES ('BBB', '비이', 2977, '경기', '011', '1113333',
                            171, '2019-03-25');

truncate table usertbl;

SELECT * FROM usertbl;

show triggers from ssgdb;

drop trigger userTbl_BeforeInsertTrg; -- 트리거 삭제


