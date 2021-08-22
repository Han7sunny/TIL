# 데이터 변경을 위한 SQL문

## INSERT문
테이블에 데이터 삽입하는 명령어  

### INSERT문 형식      
          
```SQL
   INSERT INTO 테이블_이름(열1, 열2, ...) VALUES (값1, 값2, ...);
```
+ 테이블_이름 다음에 나오는 열 생략 가능
  + 생략할 경우 VALUES 다음에 나오는 값들의 순서 및 개수가 테이블에 정의된 열 순서 및 개수와 동일해야 함
+ 테이블_이름 다음에 나오는 열의 순서를 바꿔서 입력할 경우 VALUES 다음에 입력할 순서와 동일하게 맞추어야 함
+ 여러 개의 행 한꺼번에 입력
  ```SQL
  INSERT INTO 테이블_명 VALUES (값1, 값2, ...), (값3, 값4, ...), (값5, 값6, ...);
  ```
+ 대량의 샘플 데이터 생성
   + 다른 테이블의 데이터를 가져와 대량으로 입력
     ```SQL
     INSERT INTO 테이블_명 (열_이름_1, 열_이름_2, ...)
        SELECT문 ; --- SELECT문의 결과 열의 개수와 INSERT할 테이블 열의 개수 일치해야 함
     ```
   + 다른 테이블의 데이터로 테이블 정의
     ```SQL
     USE 데이터베이스_명;
     CREATE TABLE 테이블_명 (SELECT 열_이름 FROM 테이블_명 (LIMIT 가져올_데이터_수));
     ALTER TABLE 테이블_명;
       ADD CONSTRAINT 제약_조건_이름 PRIMARY KEY (PK_지정할_열_이름);
     ```
### IGNORE
여러 INSERT문을 수행할 때 키가 중복된 데이터를 입력 시 오류로 인해 나머지 INSERT문이 수행되지 않음
```SQL
INSERT IGNORE INTO 테이블_명 VALUES (값1, 값2, ...);
```
+ PK 중복이여도 오류를 발생시키지 않고 무시하고 넘어감
+ ON DUPLICATE UPDATE
   + PK 중복되면 UPDATE문 수행되어 입력되는 데이터 수정하고, PK 중복되지 않으면 일반적인 INSERT문처럼 데이터 입력됨
   ```SQL
   INSERT INTO 테이블_명 VALUES(값1, 값2, ...) ON DUPLICATE KEY UPDATE 열_이름_1=수정할_값_1, 열_이름_2=수정할_값_2, ... ; 
   ```
### AUTO_INCREMENT
  + 자동으로 1부터 증가하는 값 입력됨
  + 데이터 형은 숫자 형식만 사용 가능
  + AUTO_INCREMENT로 지정할 때 반드시 PRIMARY KEY 또는 UNIQUE로 지정해야 함
  + 테이블 속성이 AUTO_INCREMENT로 지정된다면 해당 열은 INSERT문에서 NULL 값 지정
  + 현재 어느 숫자까지 증가되었는지 확인
    ```sql
    SELECT LAST_INSERT_ID(); -- 마지막에 입력된 값 보여줌,  1개의 INSERT 쿼리 성공시 AUTO_INCREMENT = 1 증가
    ```
  + AUTO_INCREMENT 입력값 N 부터 입력되도록 변경
    ```SQL
    ALTER TABLE 테이블_명 AUTO_INCREMENT=N;
    ```
 
## UPDATE문
테이블의 기존에 입력되어 있는 값 변경하는 명령어           

```SQL
UPDATE 테이블_명
   SET 열_이름_1 = 값_1, 열_이름_2 = 값_2 ...
   WHERE 조건 ;
```
+ WHERE절 생략 가능하지만 생략시 테이블 전체의 행이 변경됨
  + 전체 테이블의 내용을 변경하고 싶을 때 생략

## DELETE문
테이블의 데이터를 행 단위로 삭제하는 명령어
```SQL
DELETE FROM 테이블_명 WHERE 조건;
```
+ UPDATE문과 마찬가지로 WHERE문 생략되면 전체 데이터 삭제됨
+ 모두 삭제하는 것이 아닌 상위 N건만 삭제하려면 LIMIT구문 사용 (LIMIT = N)
+ 대용량 테이블 삭제
  + 효율적인 삭제
    ```SQL
    DELETE FROM 테이블_명;
    DROP TABLE 테이블_명;
    TRUNCATE TABLE 테이블_명;
    ```  
    + DML문(SELECT, INSERT, UPDATE, DELETE, 트랜잭션 발생하는 SQL)인 DELETE문은 트랜잭션 로그를 기록하는 작업으로 인해 시간이 오래 걸림
    + DDL문(CREATE, DROP, ALTER)은 트랜잭션 발생시키지 않음, 실행 즉시 MySQL에 적용됨
      + DDL문인 DROP문은 테이블 자체를 삭제
      + DDL문인 TRUNCATE문의 효과는 DELETE문과 동일하지만 트랜잭션 로그를 기록하지 않아 속도가 매우 빠름
    + 테이블 자체가 필요 없을 경우 : DROP문, 테이블 구조 남겨놓고 싶을 경우 : TRUNCATE문
