from collections import deque
def solution(n, edge):
    visited = [-1 for _ in range(n+1)]
    graph = {i : [] for i in range(1,n+1)}
    for e in edge:
        graph[e[1]].append(e[0])
        graph[e[0]].append(e[1])
    start = 1
    cost = 0
    queue = deque([[start,cost]])
    
    while queue:
        q = queue.popleft()
        start = q[0]
        cost = q[1]
        visited[start] = cost
        cost += 1
        for node in graph[start]:
            if visited[node] == -1:
                visited[node] = cost
                queue.append([node,cost])
    return visited.count(max(visited))
