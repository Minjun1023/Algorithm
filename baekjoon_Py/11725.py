# dfs
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)  # 재귀 깊이 제한 증가

n = int(input())
graph =[[] for _ in range(n+1)]
for i in range(1, n):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [0] * (n+1)

def dfs(s):
    for i in graph[s]:
        if visited[i] == 0:
            visited[i] = s
            dfs(i)

dfs(1)

for x in range(2, n+1):
     print(visited[x])