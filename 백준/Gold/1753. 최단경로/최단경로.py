import sys
import heapq
input = sys.stdin.readline

INF = 10**7
N, M = map(int, input().split())
K = int(input())

graph = [[] for _ in range(N + 1)]
distance = [INF for _ in range(N + 1)]

for i in range(M):
    # 그래프 초기화
    first, end, cost = map(int, input().split())
    graph[first].append((end, cost))

distance[K] = 0
q = [(0, K)]

while q:
    cost_v, v = heapq.heappop(q)
    for w, cost_vw in graph[v]:
        dist=cost_v+cost_vw
        if dist < distance[w]:
            heapq.heappush(q, (dist, w))
            distance[w] = dist
            

for i in range(1, N + 1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])
