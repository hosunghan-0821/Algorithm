import heapq
import sys

input = sys.stdin.readline
N = int(input())

heap = []
data = []
for i in range(N):
    start, end = map(int, input().split(" "))
    data.append((start, end))
data.sort()

start_time = data[0][0]
end_time = data[0][1]
count = 1
heapq.heappush(heap, end_time)
for i in range(1, N):
    next_end_time = data[i][1]
    next_start_time = data[i][0]
    if heap[0] > next_start_time:
        count += 1
        heapq.heappush(heap, next_end_time)
    else:
        heapq.heappop(heap)
        heapq.heappush(heap, next_end_time)

print(count)


