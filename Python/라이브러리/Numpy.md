# Numpy

+ Numerical Python의 약자로 대규모 다차원 배열과 행렬 연산에 필요한 다양한 함수 제공
+ 메모리 버퍼에 배열 데이터 저장 및 처리하는 효율적인 인터페이스 제공

### 다차원 배열
#### Shape
  + Numpy 배열 구조는 shape로 표현
  + 배열 구조를 파이썬 tuple 자료형을 이용하여 정의
  + 데이터 방향 : axis로 표현
  + Numpy 객체 정보 출력
    ```python
    import numpy as np
    def pprint(arr):
        print("type: {}".format(type(arr)))
        print("shape: {}, dimension : {}, dtype : {}".format(arr.shape, arr.ndim, arr.dtype))
        print("Array's Data:\n", arr)
    ```python
    
#### 파이썬 배열을 인자로 Numpy 배열 생성
  + Numpy 배열은 numpy.ndarray 객체
  ```python
  a = np.array([1,2,3]) # 1차원 배열로 Numpy 배열 생성
  pprint(a)
  ```
  > type: <class 'numpy.ndarray'>             
    shape: (3,), dimension : 1, dtype : int32       
    Array's Data:        
    [1 2 3]           
                  
  ```python
  arr = [(1,2,3),(4,5,6)] # 2차원 배열로 Numpy 배열 생성
  a1 = np.array(arr, dtype = float) # 파라미터로 list 객체와 dtype(데이터 타입) 입력
  pprint(a1)
  a2 = np.array([[1,2,3]]) # 2차원 배열 (괄호 2개)
  pprint(a2)
  ```
  > type: <class 'numpy.ndarray'>         
    shape: (2, 3), dimension : 2, dtype : float64         
    Array's Data:         
    [[1. 2. 3.]     
    [4. 5. 6.]]       
    type: <class 'numpy.ndarray'>           
    shape: (1, 3), dimension : 2, dtype : int32      
    Array's Data:\n [[1 2 3]]          
               
   ```python
   arr = np.array([[[1,2,3],[4,5,6]],[[3,2,1],[4,5,6]]], dtype = float) # 3차원 배열(괄호 3개)
   a = np.array(arr,dtype = float)
   pprint(a)
   ```
  > type: <class 'numpy.ndarray'>       
    shape: (2, 2, 3), dimension : 3, dtype : float64     
    Array's Data:       
    [[[1. 2. 3.]    
    [4. 5. 6.]]              
    [[3. 2. 1.]    
    [4. 5. 6.]]]     
    
#### 배열 생성 및 초기화
+ 원하는 Shape로 배열을 설정하고 각 요소를 특정 값으로 초기화
+ np.zeros()
  ```python
  a = np.zeros((3,4)) # 모든 데이터 0으로 초기화, 3행 4열
  pprint(a)
  ```
  > type: <class 'numpy.ndarray'>                 
    shape: (3, 4), dimension : 2, dtype : float64        
    Array's Data:        
    [[0. 0. 0. 0.]     
    [0. 0. 0. 0.]     
    [0. 0. 0. 0.]]      
+ np.ones()
  ```python
  a = np.ones((2,3,4),dtype=np.int16) # 모든 요소를 1로 초기화
  pprint(a)
  ```
  > type: <class 'numpy.ndarray'>            
    shape: (2, 3, 4), dimension : 3, dtype : int16       
    Array's Data:      
    [[[1 1 1 1]    
    [1 1 1 1]    
    [1 1 1 1]]    
               
    [[1 1 1 1]     
    [1 1 1 1]      
    [1 1 1 1]]]      
+ np.full()
  ```python
  a = np.full((2,2),7) # 모든 요소를 지정한 값으로 초기화
  pprint(a)
  ```
  > type: <class 'numpy.ndarray'>                    
    shape: (2, 2), dimension : 2, dtype : int32       
    Array's Data:         
    [[7 7]      
    [7 7]]       
+ np.eye()
  ```python
  np.eye(4) # 단위 행렬 N * N
  ```
  > array([[1., 0., 0., 0.],      
       [0., 1., 0., 0.],      
       [0., 0., 1., 0.],      
       [0., 0., 0., 1.]])     
+ np.empty()
  ```python
  a = np.empty((4,2)) # 초기화 과정 없고 기존 메모리값 그대로 사용
  pprint(a)
  ```
  > type: <class 'numpy.ndarray'>                  
    shape: (4, 2), dimension : 2, dtype : float64         
    Array's Data:       
    [[ 30.075  24.2  ]     
    [364.875  24.2  ]     
    [ 30.075 241.64 ]     
    [364.875 241.64 ]]    
+ like 함수
  + np.zeros_like()
    ```python
    a = np.array([[1,2,3],[4,5,6]])
    b = np.zeros_like(a) # 지정된 배열과 shape(값X 행,렬의 구조)이 동일한 행렬을 만듦, 요소 0로 초기화
    pprint(b)
    ```
    > type: <class 'numpy.ndarray'>                    
      shape: (2, 3), dimension : 2, dtype : int32        
      Array's Data:     
      [[0 0 0]     
      [0 0 0]]     
  + np.ones_like()
    ```python
    a = np.array([[1,2,3],[4,5,6]])
    b = np.ones_like(a) # 지정된 배열과 shape(값X 행,렬의 구조)이 동일한 행렬을 만듦, 요소 1로 초기화
    pprint(b)
    ```
    > type: <class 'numpy.ndarray'>                    
      shape: (2, 3), dimension : 2, dtype : int32           
      Array's Data:             
      [[1 1 1]     
      [1 1 1]]     
  + np.full_like()
    ```python
    a = np.array([[1,2,3],[4,5,6]])
    b = np.full_like(a,7) # 지정된 배열과 shape(값X 행,렬의 구조)이 동일한 행렬을 만듦, 지정된 값으로 초기화
    pprint(b)
    ```
    > type: <class 'numpy.ndarray'>                    
      shape: (2, 3), dimension : 2, dtype : int32          
      Array's Data:         
      [[7 7 7]      
      [7 7 7]]     
  + np.empty_like()
    ```python
    a = np.array([[1,2,3],[4,5,6]])
    b = np.empty_like(a) # 지정된 배열과 shape, 값이 동일한 행렬을 만듦
    pprint(b)
    ```
    > type: <class 'numpy.ndarray'>                 
      shape: (2, 3), dimension : 2, dtype : int32        
      Array's Data:        
      [[1 2 3]    
      [4 5 6]]    
    
