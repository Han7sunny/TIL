# x만큼 간격이 있는 n개의 숫자     

### 문제 설명
함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다.         
다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

### 제한 조건
x는 -10000000 이상, 10000000 이하인 정수입니다.        
n은 1000 이하인 자연수입니다.       

### 입출력 예
![ex6](https://user-images.githubusercontent.com/63505110/129747951-80b1a608-306e-4c73-a933-0585bb110158.GIF)

### 풀이
+ 반복문 사용
```python
    def solution(x, n):
        answer = []
        for num in range(1,n + 1):
            answer.append(x*num)
        return answer
```
+ 리스트 내포
```python
    def solution(x, n):
        return [x * i for i in range(1,n+1)]
```
+ list() 
```python
    def solution(x, n):
        return list(range(x,x*(n+1),x))
    -> 런타임 에러 발생
```
   
```python
    -> 해결 : x가 0일 경우 range()로 범위 지정할 필요 없음       
    def solution(x, n):
        if(x == 0):
            return [0] * n
        else:
            return list(range(x, x * (n+1), x))
```
