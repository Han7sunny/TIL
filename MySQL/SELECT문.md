# SELECT문

원하는 데이터를 가져와 주는 (조회하는) 명령어             
+ 가장 자주 쓰이는 형식                         
  ```sql
  SELECT 열_이름 -- SELECT * : 모든 열 조회
  FROM 테이블/뷰_이름
  WHERE 조건
  ```
### DATABASE 관련 명령어    

+ 데이터베이스 조회         

  ```sql
  SHOW DATABASES;
  ```
+ 데이터베이스 조회 및 삭제         
  ```sql
  DROP DATABASE IF EXISTS 데이터베이스_이름; -- 만약 데이터베이스_이름이 존재하면 우선 삭제함
  ```
+ 데이터베이스 생성         
  ```sql
  CREATE DATABASE 데이터베이스_이름;
  ```
+ 데이터베이스 지정          
  ```sql
  USE 데이터베이스_이름; -- 입력하는 쿼리를 수행할 데이터베이스 지정
  ```
  
### TABLE 관련

+ 테이블의 정보 조회
  ```SQL
   SHOW TABLE STATUS; -- 테이블 이름만 간단히 보려면 SHOW TABLES;
  ```
+ 테이블의 열 조회
  ``` SQL
   DESCRIBE 테이블_이름; -- 또는 DESC 테이블_이름;
  ```
+ 테이블 복사
  PK나 FK 등의 제약조건은 복사되지 않는다.
  ```SQL
   CREATE TABLE 새로운_테이블 (SELECT 복사할_열 FROM 기존_테이블);
  ```       
  
### SELECT 절
+ DISTINCT : 중복된 것은 1개만 보여줌
+ LIMIT N : 상위 N개만 제한적으로 출력함
  + LIMIT 시작, 개수 = LIMIT 개수 OFFSET 시작
+ AS 별칭 : 열 이름을 별도의 별칭(Alias)으로 지정, 별칭의 중간에 공백이 있다면 작은 따옴표로 감싸주어야 함      

### WHERE 절
+ 조건 연산자 : =, <, >, <=, >=, <>, !=                
+ 관계 연산자 : NOT, AND, OR
+ BETWEEN ... AND ... : 숫자와 같은 연속적인 값
+ IN(값1, 값2, ...) : 연속적인 값이 아닌 이산적인(Discrete) 값
+ LIKE 검색할_값 : 문자열의 내용 검색할 때
  + ' % ' : 무엇이든 허용 EX. '김%' : 김이 제일 앞 글자인 것들 조회
  + ' _ ' : 한 글자와 매치 EX. '_길동' : 맨 앞 글자가 한 글자이고 그 다음이 '길동'인 사람 조회
+ 서브/하위 쿼리 (SubQuery) : 쿼리문 안의 또다른 쿼리문, ()로 묶어야 함
  + ANY, SOME : 서브쿼리의 여러 개의 결과 중 _한 가지만_  만족해도 됨, = ANY (서브쿼리)는 IN(서브쿼리)과 동일
  + ALL : 서브쿼리의 여러 개의 결과를 _모두_  만족해야 됨

### GROUP BY 절
그룹을 묶어주는 역할           
주로 집계 함수와 함께 쓰임         
집계 함수 (Aggregate Function)
+ SUM() : 합을 구한다.
+ AVG() : 평균을 구한다.
+ MIN() : 최소값을 구한다.
+ MAX() : 최대값을 구한다.
+ COUNT() : 행의 개수를 센다. NULL 제외 , COUNT(*)는 NULL도 카운트
+ COUNT(DISTINCT) : 행의 개수를 센다(중복은 1개만 인정).
+ STDEV() : 표준편차를 구한다.
+ VAR_SAMP() : 분산을 구한다.
총합 또는 중간 합계 : WITH ROLLUP문

### HAVING 절
집계 함수에 대한 조건을 제한 -> WHERE 절에서 집계 함수 조건 제한하면 오류 메시지 출력됨               
반드시 *GROUP BY절 다음*에 나와야 함          

### ORDER BY 절
결과가 출력되는 순서를 조절
SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY 중 **제일 뒤에 와야 한다**
기본값 : ASC (ASCENDING, 오름차순)
DESC : DESCENDING, 내림차순

+ 흐름
FROM -> WHERE -> GROUP MY -> HAVING -> SELECT -> ORDER BY
