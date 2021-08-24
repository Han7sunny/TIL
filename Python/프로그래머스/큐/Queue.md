# 큐 Queue
+ 영어로 '일이 처리되기를 기다리는 리스트'라는 의미
+ 프로그래밍에서 목록 혹은 리스트에서 양쪽에서 접근 가능한 구조
+ FIFO(First-In, First-Out) 원리

### 큐의 구조
+ put : 큐에 값 삽입
+ peek : 큐에 가장 먼저 들어간 값 출력 (삭제 X)
+ get : 큐에 가장 먼저 들어간 값 삭제 및 반환

### python 큐 구현
+ 직접 구현
  ```python
  class Queue(list):
      put = list.append # 리스트의 append와 동일
      
      def peek(self):
          return self[0] # 가장 앞에 있는 값
          
      def get(self):
          return self.pop(0) # index 0인 가장 앞에 있는 값 
  ```
+ Queue 클래스 import
  ```python
  from queue import Queue
  q = Queue()
  q.put(값)
  q.peek()
  q.get()
  ```
+ List로 구현
  ```python
  q = list()     # q = []와 동일
  q.append(값)   # put
  q[0]           # peek
  q.pop(0)       # get
  ```
### 큐의 활용
+ 프린터 인쇄 대기열
+ 너비 우선 탐색 (BFS)
