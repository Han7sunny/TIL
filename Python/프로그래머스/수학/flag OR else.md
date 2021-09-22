# flag OR else
### 문제 설명
본 문제에서는 자연수 5개가 주어집니다.

+ 숫자를 차례로 곱해 나온 수가 제곱수1가 되면 found를 출력하고
+ 모든 수를 곱해도 제곱수가 나오지 않았다면 not found를 출력하는      
코드를 작성해주세요.
         
### 예시 1
입력     
2      
4      
2       
5        
1      
         
출력      
found       
              
설명        

수를 곱해나가면 2, 8, 16, 80, 80 이 나옵니다. 16은 4를 제곱해 나온 수이므로 이 수는 제곱수입니다. 따라서 found를 출력합니다.               
         
### 예시 2    
입력      
5        
1        
2        
3        
1       
        
출력         
not found        
      
설명       

수를 곱해나가면 5, 5, 10, 30, 30 이 나옵니다. 이중 어떤 수도 제곱 수가 아니므로 not found를 출력합니다.             
                 
제곱수란 어떤 자연수를 제곱한 수입니다. 예를 들어 1, 4, 9, 16, 25, .. 등은 제곱수입니다.
### 풀이
+ flag 사용
```python
import math
check = False
total = 1
for _ in range(5):
    total *= int(input())
    if math.sqrt(total) == int(math.sqrt(total)):
        check = True
        break
if check == True:
    print('found')
else:
    print('not found')
```
+ if else 구문 사용
```python
import math
total = 1
if __name__ == '__main__':
    for _ in range(5):
        total *= int(input()) # [int(input()) for _ in range(5)]
        if math.sqrt(total) == int(math.sqrt(total)):
            print('found')
            break
else: # else 작성하지 않으면 found 이후에도 not found 출력됨
    print('not found')
```
