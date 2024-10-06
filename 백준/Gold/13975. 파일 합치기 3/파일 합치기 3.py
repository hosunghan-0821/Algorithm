import sys
import heapq

input = sys.stdin.readline

T = int(input())

for i in range(T):
    N = int(input())
    heap = list(map(int, input().split()))
    heapq.heapify(heap)
    sum = 0
    while True:
        if len(heap) >= 2:
            data1 = heapq.heappop(heap)
            data2 = heapq.heappop(heap)
            sum += data1 + data2
            heapq.heappush(heap,data1+data2)
        else:
             break

    print(sum)