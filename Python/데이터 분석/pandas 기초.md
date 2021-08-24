# pandas 기초

pandas : 테이블 형태의 데이터를 쉽게 다룰 수 있는 파이썬 라이브러리          

### 데이터 불러오기
```python
import pandas as pd
sample_1 = pd.read_excel('./files/sample_1.xlsx', header = 1. skipfooter = 2, usecols = 'A:C')
sample_1.head(3)
```
+ import pandas as pd : 데이터를 불러오기 위하여 pandas 불러옴, 별칭을 사용하여 pd로 호출함
+ pd.read_excel() : 엑셀 파일을 불러오는 함수, 엑셀 파일의 위치를 입력
  + header : 칼럼명(속성, 열)이 있는 위치를 나타냄, 파이썬은 0부터 세는 제로 인덱스 유형을 사용하기에 두번째 row인 1 입력
  + skipfooter : 마지막 row에서 지정한 n(숫자) 줄 생략하고 불러옴
  + usercols : 불러올 칼럼 영역 지정
+ head(n) : 처음부터 n번째 row까지 보여주는 함수, 불러온 데이터의 로우가 많을 경우 잘 불러왔는지 확인하는 용도
+ tail(n) : 마지막부터 n번째 row까지 보여주는 함수
+ info() : 불러온 데이터의 요약 정보 확인
+ describe() : 숫자형 변수에 대한 여러 가지 통계량을 출력하는 함수
  + count : 데이터의 개수
  + mean : 평균값
  + std : 표준편차
  + min : 최솟값
  + 25% : 1사분위수
  + 50% : 2사분위수(중위수)
  + 75% : 3사분위수
  + max : 최댓값
           
### 데이터 선택 - 칼럼 기준
데이터에서 원하는 칼럼 부분만 선택   
+ 칼럼 1개 선택
  ```python
  sample_1.['입국객수'] # == sample_1.입국객수 
  # sample_1 데이터에서 입국객수 칼럼만 봄
  ```              
+ 칼럼 2개 이상
  ```python
  sample_1.[['국적코드', '입국객수']] # 국적코드, 입국객수 순서대로 출력됨
  ```
  + 여러 개의 칼럼을 리스트로 묶어 입력
+ 칼럼 선택
  ```python
  sample_1[칼럼명] = 값
  ```
  + sample_1 데이터에 존재하지 않던 칼럼명에 값을 부여하면 새로운 칼럼 생성     
  
### 데이터 선택 - 로우 기준
특정 조건에 맞는 데이터를 필터링(filtering)한 결과를 찾을 경우             
```python
condition = (sample_1['성별'] == '여성')
sample_1[condition] 
# 조건에 해당하지 않는 경우를 찾을 경우 condition==False를 조건으로 부여
# sample_1[condition == False]
```
+ sample_1에서 조건의 true에 해당되는 값만 출력됨
+ &(AND), |(OR), <, >, <=, >=, ==  등 기호를 사용하여 조건 입력
+ isin() : 찾고 싶은 값들을 리스트 형태로 매개변수에 입력, 리스트 안의 값에 해당할 경우 True 반환
         
### 데이터 통합 - 옆으로 통합 merge
여러 데이터를 하나의 데이터로 통합
+ 한쪽 테이블을 기준으로 두 테이블 결합하는 경우
  ```python
  import pandas as pd
  code_1 = pd.read_excel('./files/sample_2.xlsx')
  sample_1_code = pd.merge(left = sample_1, right = code_1, how = 'left', left_on = '국적코드', right_on = '국적코드')
  ```
  + pd.merge() : 기준 테이블과 정보를 결합하고 싶은 테이블 간에 공통된 칼럼에 대해 같은 값을 찾아 결합해 하나의 테이블로 합치는 역할
    + left : 왼쪽 테이블 지정
    + right : 오른쪽 테이블 지정
    + how : 입력한 (왼쪽 / 오른쪽)테이블을 기준으로 두 테이블을 결합
    + left_on : 왼쪽 테이블의 기준 칼럼 지정
    + right_on : 오른쪽 테이블의 기준 칼럼 지정
  + 매칭되는 값이 없는 경우 NaN으로 결과가 출력됨   
         
+ 양쪽 테이블에서 공통으로 존재하는 경우
  ```python
  import pandas as pd
  code_2_inner = pd.merge(left = sample_1, right = code_1, how = 'inner', left_on = '국적코드', right_on = '국적코드')
  ```
  + how = 'inner' : 두 테이블의 기준 칼럼의 값이 서로 일치하는 경우에만 데이터를 통합
           
### 데이터 통합 - 아래로 통합 append
여러 데이터를 아래로 통합
```python
import pandas as pd
sample = sample_1_code.append(sample_2_code, ignore_index = True)
```
+ 통합하려는 테이블 간의 칼럼 순서가 동일해야 함
+ sample_1_code를 기준으로 그 밑에 sample_2_code를 통합
+ ignore_index : True로 지정하지 않으면 원래 각 데이터에서의 인덱스 값으로 지정됨

### 데이터 저장 to_excel
데이터를 엑셀 파일로 저장
```python
sample.to_excel('./files/sample.xlsx')
# sample.to_excel('./files/sample_index_false.xlsx', index = False)
```
+ pandas에서 자동 생성된 인덱스 번호가 엑셀 파일의 맨 앞(A셀)에 저장됨
+ index 번호를 제외하고 저장하고 싶을 경우 index = False 조건 부여
     
### 데이터 집계 pivot_table
피벗 테이블 : 기존 데이터의 칼럼을 재구성하여 데이터에 대한 통계를 한눈에 파악할 수 있게 정리한 표
+ 피벗 테이블 생성
  ```python
  sample_pivot = sample.pivot_table(values='입국객수', index = '국적명', columns = '기준년월', aggfunc = 'mean')
  ```
  + sample.pivot_table() : sample 데이터를 피벗화한다.
    + values : 피벗 테이블 내부에 들어갈 값(엑셀에서 값) 지정
    + index : 피벗 테이블의 로우(엑셀에서의 행) 지정
    + columns : 피벗 테이블의 칼럼(엑셀에서의 열) 지정
    + aggfunc : index와 columns 기준으로 values를 지정한 옵션 계산
      + mean : 평균
      + sum : 합계
      + min : 최솟값
      + median : 중앙값
      + max : 최댓값
      + count : 개수
      + nunique : 중복 제거한 후 개수(원소 개수)
  + index와 columns가 항상 있어야 하는 것 아님
