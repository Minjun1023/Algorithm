# 위상정렬
# 민오: 1~N번까지 총 N개의 문제로 되어있는 문제집을 풀려고 한다.
# 문제는 난이도 순서로 출제되어 있다.
# 1번 문제가 가장 쉬운문제이고, N번 문제가 가장 어려운 문제가 된다.
# 조건 1: N개의 문제는 모두 풀어야한다.
# 조건 2: 먼저 푸는 것이 좋은 문제가 있는 문제는 먼저 푸는 것이 좋은 문제를 반드시 먼저 풀어야 한다.
# 조건 3: 가능하면 쉬운 문제부터 풀어야 한다.
import sys
import heapq
input = sys.stdin.readline

n, m = map(int, input().split())

answer = []
graph = [[] for _ in range(n+1)]
inDegree = [0 for _ in range(n+1)] # 진입차수
queue = []

for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    inDegree[b] += 1 # 연결해줬으므로 진입차수 + 1

for i in range(1, n+1):
    if inDegree[i] == 0: # 진입차수가 0인 정점을 큐에 삽입
        heapq.heappush(queue, i)

while queue:
    tmp = heapq.heappop(queue)
    answer.append(tmp)
    for i in graph[tmp]:
        inDegree[i] -= 1
        if inDegree[i] == 0:
            heapq.heappush(queue, i)

print(' '.join(map(str, answer)))


