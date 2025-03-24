-- 1. 2번
-- 2. 1번
-- 3.
-- 4. 1번
-- 5. 1번
-- 6.
-- 13. 3번
-- 14. 3번
-- 15. 1번
-- 16. 2번
--
-- 17.
use 신세계무역;
select * from 제품;
desc 제품;
select * from 제품 where 제품명 like '%주스%';
-- 18.
select * from 제품 where 제품명 like '%주스%' and 단가 between 5000 and 10000;
-- 19.
select * from 제품 where 제품번호 in (1,2,4,7,11,20);
-- 20.
select 제품명, 단가, 재고, 단가 * 재고 as 재고금액 from 제품 order by 재고금액 limit 10;
-- 21. 1번 *
-- 22. 4번 *
-- 23. 4번 *
-- 24. 2, 3번 *
-- 25. 1번 *
-- 26. 4번 *
-- 27.
select * from 고객;
select 담당자명 from 고객 where 담당자명 like '%정%';
-- 28.
select * from 주문 where year(주문일) = 2020 and month(주문일) between 4 and 6;
-- 29.
select 제품번호,
       제품명,
       재고,
       case
           when 재고 > 100 then '과다재고'
           when 재고 > 10 then '적정'
           else '재고부족'
           end as 재고구분
from 제품;
-- 30.
select * from 사원;
select * from 사원 where timestampdiff(month , 입사일, now()) > 40;
-- 31. 4
-- 32. 1
-- 33. 2, 4
-- 34. 4
-- 35. 1
-- 36.
select sum(주문수량), sum(단가)
from 주문세부
group by 제품번호;
-- 37.
select 제품번호, sum(단가) 주문금액합
from 주문세부
group by 주문번호;
-- 38.
select 고객번호
from 주문
where year(주문일) = 2021
group by 고객번호
order by 고객번호 limit 3;
-- 39.
select count(직위), 이름
from 사원
group by 직위;
-- 40. 3
-- 41. 2
-- 42. 3
-- 43. 2
-- 44. 1
-- 45.
select count(*)
from 고객 join 마일리지등급
on 마일리지 between 하한마일리지 and 상한마일리지
group by 등급명;
-- 46.
select *
from 주문
where 주문번호 = 'H0249';
-- 47.
select *
from 주문
where 주문일 = '2020-04-09';
-- 48. ?

-- 49. 1,4
-- 50. 1 *
-- 51. 3 *
-- 52.
select 제품명
from 제품
order by 단가 limit 1;
-- 53.
SELECT SUM(주문수량) AS 총주문수량
FROM 제품
         JOIN 주문세부 ON 제품.제품번호 = 주문세부.제품번호
WHERE 제품.단가 = (SELECT MAX(단가) FROM 제품);

-- 54.
select sum(주문수량)
from 제품 join 주문세부
on 제품.제품번호 = 주문세부.제품번호
where 제품명 = '아이스크림';

-- 55.
select count(*)
from 고객 join 주문
on 고객.고객번호 = 주문.고객번호
where 고객.도시 = '서울특별시'
group by year(주문일);

-- 56. 1
-- 57. 4
-- 58. 2
-- 59. 3
-- 60. 1
-- 61.
insert into 고객(고객번호, 담당자명,고객회사명,도시) values ('ZZZAA', '한동욱', '자유트레이딩', '서울특별시');
select * from 고객 where 고객번호 = 'ZZZAA';
-- 62.
update 고객 set 도시 = '부산광역시', 마일리지 = 100, 담당자직위 = '대표이사' where 고객번호 = 'ZZZAA';
-- 63. *
UPDATE 고객
    JOIN (
        SELECT AVG(마일리지) AS avg
        FROM 고객
        WHERE 담당자직위 = '대표이사'
    ) AS t
SET 고객.마일리지 = t.avg
WHERE 고객.고객번호 = 'ZZZAA';

-- 64.
insert into 사원(사원번호, 이름, 직위) values ('E15', '이석진', '수습사원')
on duplicate key update 사원번호 = 'E15', 이름 = '이석진', 직위 = '수습사원';
select * from 사원 where 사원번호 = 'E15';
-- 65.
delete from 고객 where 고객번호 = 'ZZZAA';
-- 66.
delete from 사원 where 사원번호 = 'E15';

-- 67.
-- ㄱ = 1, ㄴ = 3,4, ㄷ = 12, ㄹ = 2, ㅁ = 8, ㅂ = 10
-- 68. 4
-- 69. 4
-- 70. 1

-- 71.
CREATE TABLE 영화 (
                    영화번호  CHAR(5)       PRIMARY KEY,
                    타이틀    VARCHAR(100)  NOT NULL,
                    장르      VARCHAR(20)
                        CHECK (장르 IN ('코미디','드라마','다큐','SF','액션','역사','기타')),
                    배우      VARCHAR(100)  NOT NULL,
                    감독      VARCHAR(50)   NOT NULL,
                    제작사    VARCHAR(50)   NOT NULL,
                    개봉일    DATE,
                    등록일    DATE
);
create table 평점관리(
  번호 integer,
  평가자닉네임 varchar(50) not null ,
  영화번호 char(5) not null ,
  평점 integer check ( 평점 between 1 and 5) not null ,
  평가 varchar(2000),
  등록일 datetime
);
-- 73. 4
-- 74. 1
-- 75. 4
-- 76. 1 *

-- 77
-- 78
-- 79
-- 80

-- 81. 3
-- 82. 2
-- 83. 1
-- 84. 1
-- 85. 4

-- 86.
-- 87.
-- 88.
-- 89.
-- 90. 2
-- 91. 2
-- 92. 1
-- 93. 2
-- 94.
-- 95.
-- 96.
-- 97.
-- 98. 2
-- 99. 3
-- 100.
-- 101.
-- 102.
-- 103.







