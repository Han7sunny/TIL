# SQL 고급

## MySQL 데이터 형식
+ 숫자 데이터 형식
  | 데이터 형식  | 바이트 수 | 특징  |
  | :---------: | :----:  |:----:|
  | SMALLINT    | 2| 정수|
  |INT / INTEGER|4|정수|
  |BIGINT|8|정수|
  |FLOAT|4|소수점 아래 7자리까지 표현, 근사치의 숫자 저장|
  |DOUBLE|8|소수점 아래 15자리까지 표현, 근사치의 숫자 저장|
  |DECIMAL|5~17|정확한 수치 저장, 소수점이 들어간 실수 저장할 때 사용|       
                   
+ 문자 데이터 형식
  | 데이터 형식  | 바이트 수 | 특징  |
  | :---------: | :----:  |:----:|
  |CHAR(n)|1~255|고정길이 문자형, n을 1부터 255까지 지정, CHAR = CHAR(1)|
  |VARCHAR(n)|1~65535|가변길이 문자형, n을 1부터 65535까지 지정|
  |BINARY(n)|1~255|고정길이 이진 데이터 값|
  |VARBINARY(n)|1~255|가변길이 이진 데이터 값|
  |TEXT 형식|TEXT|1~65535|TEXT 데이터 값|
  |TEXT 형식|LONGTEXT|1~4294967295|최대 4GB 크기의 TEXT 데이터 값|
  |BLOB 형식|BLOB|1~65535|BLOB 데이터 값|
  |BLOB 형식|LONGBLOB|1~4294967295|최대 4GB 크기의 BLOB 데이터 값|
  |ENUM(값들...)|1 또는 2|최대 65535개의 열거형 데이터 값|
  |SET(값들...)|1,2,3,4,8|최대 64개의 서로 다른 데이터 값|
  + BLOB : Binary Large OBject로 사진 파일, 동영상 파일, 문서 파일 등의 대용량 이진 데이터 저장
            
+ 날짜, 시간 데이터 형식
  | 데이터 형식  | 바이트 수 | 특징  |
  | :---------: | :----:  |:----:|
  |DATE|3|'YYYY-MM-DD' 형식으로 날짜 형식만 사용|
  |TIME|3|'HH:MM:SS' 형식으로 사용|
  |DATETIME|8|'YYYY-MM-DD HH:MM:SS' 형식으로 사용|
  |TIMESTAMP|4|'YYYY-MM-DD HH:MM:SS' 형식으로 사용, UTC 시간대 변환하여 저장|
  |YEAR|1|'YYYY'형식으로 사용, 1901~2155까지 저장|
                
+ 기타 데이터 형식
  | 데이터 형식  | 바이트 수 | 특징  |
  | :---------: | :----:  |:----:|
  |GEOMETRY|N/A|공간 데이터 형식으로 선,점 및 다각형 같은 공간 데이터 개체를 저장하고 조작|
  |JSON|8|JSON(JavaScript Object Notation)문서를 저장|
                   
## 데이터 형식과 형 변환
+ 명시적인 변환 Explicit conversion
  + CAST() 또는 CONVERT() 함수를 이용하여 데이터 형식 변환
  ```SQL
  CAST( 표현식 AS 데이터_형식 [(길이)] )
  CONVERT( 표현식, 데이터_형식 [(길이)] )
  ```
  + 가능한 데이터 형식 : BINARY, CHAR, DATE, DATETIME, DECIMAL, JSON, SIGNED INTEGER, TIME, UNSIGNED INTEGER 등          
  
+ 암시적인 형 변환 Implicit conversion
  + CAST()나 CONVERT() 함수를 **사용하지 않고** 데이터 형식 변환
  ```SQL
  SELECT '100' + '200'; --- 문자와 문자를 더함 -> 더하기 연산자로 인해 문자열이 숫자로 변환됨
  SELECT 1 > '2differenttears'; -- 정수인 2로 변환되어 비교 false(0)
  SELECT 3 > '2differenttears'; -- 정수인 2로 변환되어 비교 true(0)
  SELECT 0 = 'differenttears2'; -- 문자는 0으로 변환되어 비교 true(0)
  -- CONCAT() : 문자열을 연결해주는 함수
  SELECT CONCAT('100', '200'); -- 문자와 문자를 연결, 문자로 처리됨
  SELECT CONCAT(100, '200'); -- 정수가 문자로 변환되어 문자와 문자를 연결
  ```
## MySQL 내장 함수
제어 흐름, 문자열, 수학, 날짜/시간, 전체 텍스트 검색, 형 변환, XML, 비트, 보안/압축, 정보, 공간 분석, 기타 함수 등
+ 제어 흐름 함수
  프로그램의 흐름을 제어
  + CASE ~ WHEN ~ ELSE ~ END
    CASE는 내장 함수는 아니며 연산자Operator로 분류됨, 다중 분기에 사용될 수 있음
    ```sql
    -- 예제
    SELECT CASE 10
                WHEN 1 THEN '일'
                WHEN 5 THEN '오'
                WHEN 10 THEN '십' -- CASE 뒤의 값이 10이므로 '십' 반환
                ELSE '모름' -- 해당하는 사항 없을 경우 ELSE 부분 반환
          END AS 'CASE연습'; -- 출력될 열의 별칭
    ```            
    
## 변수의 사용
SQL도 다른 일반적인 프로그래밍 언어와 같이 변수(Variable)를 선언하고 사용할 수 있음
```sql
SELECT @변수_이름 = 변수의_값; -- 변수의 선언 및 값 대입, 전역 변수처럼 사용
SELECT @변수_이름; -- 변수의 값 출력
```
+ 변수는 Workbench를 재시작할 때까지는 계속 유지되지만 Workbench를 닫았다 재시작하면 소멸됨

## 조인
두 개 이상의 테이블을 서로 묶어 하나의 결과 집합으로 만들어 내는 것
+ INNER JOIN (내부조인)
  + 그냥 JOIN이라고 작성해도 INNER JOIN으로 인식함
  + 양쪽 테이블에 모두 내용이 있는 것만 조인되는 방식
  ```SQL
  SELECT 열_목록
  FROM 첫번째_테이블_명 -- 테이블에 별칭 줄 경우 -> 테이블_명 별칭 로 붙여주면 됨
        INNER JOIN 두번째_테이블_명
        ON 조인될_조건 -- 테이블_명.열_이름 또는 별칭.열_이름
  [WHERE 검색_조건];
  ```
+ OUTER JOIN (외부조인)
  + 조인의 조건에 만족되지 않는 행까지도 포함시키는 방식
  + 양쪽 테이블에 내용이 있으면 당연히 조인되고, 한쪽에만 내용이 있어도 그 결과가 표시되는 조인 방식
  ```SQL
  SELECT 열_목록
  FROM 첫번째_테이블_명(LEFT 테이블)
        <LEFT | RIGHT | FULL> OUTER JOIN 두번째_테이블_명(RIGHT 테이블)
        ON 조인될_조건
  [WHERE 검색_조건];
  ```
  + LEFT OUTER JOIN(LEFT JOIN)문의 의미 = 왼쪽 테이블(첫번째_테이블_명(LEFT 테이블))의 것은 모두 출력되어야 한다
  + FULL OUTER JOIN(전체 조인 또는 전체 외부 조인) : LEFT OUTER JOIN + RIGHT OUTER JOIN
    + 양쪽 모두에 조건이 일치하지 않는 것을 모두 출력하는 방식      
    + 
+ CROSS JOIN (상호 조인)
  + 한쪽 테이블의 모든 행들과 다른 쪽 테이블의 모든 행을 조인시키는 방식
