# i번째 원소와 i+1번째 원소

### 문제 설명
숫자를 담은 리스트 mylist가 solution 함수의 파라미터로 주어집니다.                
solution 함수가 mylist의 i번째 원소와 i+1번째 원소의 차를 담은 일차원 리스트에 차례로 담아 리턴하도록 코드를 작성해주세요.                 

단, 마지막에 있는 원소는 (마지막+1)번째의 원소와의 차를 구할 수 없으니, 이 값은 구하지 않습니다.                 

### 제한 조건
+ mylist의 길이는 1 이상 100 이하인 자연수입니다.
+ mylist의 원소는 1 이상 100 이하인 자연수입니다.

### 예시
|mylist	|output|
|-------|--------|
|[83, 48, 13, 4, 71, 11]	|[35, 35, 9, 67, 60]|

설명:

+ 83과 48의 차는 35입니다.
+ 48과 13의 차는 35입니다.
+ 13과 4의 차는 9입니다.
+ 4와 71의 차는 67입니다.
+ 71과 11의 차는 60입니다.
따라서 [35, 35, 9, 67, 60]를 리턴합니다.

### 풀이
+ zip() 사용
```python
def solution(mylist):
    answer = []
    for number1, number2 in zip(mylist, mylist[1:]): # zip 함수에 서로 길이가 다른 리스트가 인자로 들어오는 경우 길이가 짧은 쪽 까지만 이터레이션이 이루어짐
        answer.append(abs(number1 - number2))
    return answer
```
+ 반복문 사용
```python
def solution(mylist):
    answer = list()
    for i in range(len(mylist) - 1):
        answer.append(abs(mylist[i+1] - mylist[i]))
    return answer
```
