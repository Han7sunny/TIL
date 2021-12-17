# N과 M (2)
#### 백준 15650번
[백준 | N과 M (2)](https://www.acmicpc.net/problem/15650)
### 풀이
```python
from sys import stdin

n,m = map(int,stdin.readline().split())

def solution(picked):
    if len(picked) == m:
        print(*picked)
        return

    if not picked:
        start = 0
    else:
        start = picked[-1]
        
    for i in range(start + 1, n + 1):
        picked.append(i)
        solution(picked)
        picked.pop()
solution([])
```
