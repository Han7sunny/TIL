# N과 M (4)
#### 백준 15652번
[백준 | N과 M (4)](https://www.acmicpc.net/problem/15652)
### 풀이
```python
from sys import stdin

n,m = map(int,stdin.readline().split())

def solution(picked):
    if len(picked) == m:
        print(*picked)
        return

    if not picked:
        start = 1
    else:
        start = picked[-1]

    for i in range(start, n + 1):
        picked.append(i)
        solution(picked)
        picked.pop()
solution([])
```
