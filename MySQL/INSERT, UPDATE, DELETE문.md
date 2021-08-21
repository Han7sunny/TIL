# 데이터 변경을 위한 SQL문

### INSERT문
테이블에 데이터 삽입하는 명령어
```SQL
   INSERT INTO 테이블_이름(열1, 열2, ...) VALUES (값1, 값2, ...);
```
+ 테이블_이름 다음에 나오는 열 생략 가능
  + 생략할 경우 VALUES 다음에 나오는 값들의 순서 및 개수가 테이블에 정의된 열 순서 및 개수와 동일해야 함
+ 테이블_이름 다음에 나오는 열의 순서를 바꿔서 입력할 경우 VALUES 다음에 입력할 순서와 동일하게 맞추어야 함
+ AUTO_INCREMENT
  + 자동으로 1부터 증가하는 값 입력됨
  + 데이터 형은 숫자 형식만 사용 가능
  + AUTO_INCREMENT로 지정할 때 반드시 PRIMARY KEY 또는 UNIQUE로 지정해야 함
  + 테이블 속성이 AUTO_INCREMENT로 지정된다면 해당 열은 INSERT문에서 NULL 값 지정
 
