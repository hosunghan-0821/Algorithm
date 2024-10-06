import sys
import heapq

input = sys.stdin.readline

N = int(input())

heap = []
for i in range(N):
    input_num = int(input())
    if input_num == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heapq.heappop(heap)[1])
    else:
        heapq.heappush(heap,(abs(input_num), input_num))


