# 스택 Stack
+ 영어로 '쌓다'라는 의미
+ 프로그래밍에서 목록 혹은 리스트에서 한쪽에서만 접근이 가능한 구조
+ LIFO(Last-In, First-Out) 원리

### 스택의 구조
+ push : 스택에 값 추가 (위에 추가)
+ peek : 가장 위의 값 출력(삭제X)
+ pop : 스택에서 가장 위의 값 삭제 및 반환

### python 스택 구현
python은 List가 스택으로 사용 가능하도록 구현되어있음
+ 직접 구현
  ```python
  class Stack(list):
    push = list.append # append : stack의 push와 동일       

    def peek(self):      
        return self[-1] # self[len(self) - 1]과 동일         

    # pop은 list의 내장함수로 이미 존재
  ```       
  
+ list로 구현
  ```python
  s = list() # s = []와 동일
  s.append(값) # push
  s.pop() # pop
  s[-1] # peek
  ```
  
### 스택의 활용
 + 브라우저의 이전 페이지, 다음 페이지
 + 깊이 우선 탐색 (DFS)
  
