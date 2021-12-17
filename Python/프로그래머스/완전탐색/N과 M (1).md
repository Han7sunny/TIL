# N과 M (1)
#### 백준 15649번
[백준 | N과 M (1)](https://www.acmicpc.net/problem/15649)
### 풀이
```python
from sys import stdin

n,m = map(int,stdin.readline().split())

def solution(picked):
    if len(picked) == m:
        print(*picked)
        return
        
    for i in range(1, n + 1):
        if i not in picked: # 없는거 뽑아
            picked.append(i)
            solution(picked)
            picked.pop()
solution([])
```
