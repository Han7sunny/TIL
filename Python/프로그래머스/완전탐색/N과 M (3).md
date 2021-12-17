# N과 M (3)
#### 백준 15651번
[백준 } N과 M (3)](https://www.acmicpc.net/problem/15651)
### 풀이
```python
from sys import stdin

n,m = map(int,stdin.readline().split())

def solution(picked):
    if len(picked) == m:
        print(*picked)
        return

    for i in range(1, n + 1):
        picked.append(i)
        solution(picked)
        picked.pop()
solution([])
```
