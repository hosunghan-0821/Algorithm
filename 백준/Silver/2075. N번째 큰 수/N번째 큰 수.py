import sys
import heapq
input = sys.stdin.readline

def best_practice():
    heap = []
    n = int(input())
    
    for _ in range(n):
        numbers = map(int, input().split())
        for number in numbers :
            if len(heap) < n:
                heapq.heappush(heap, number)
            else :
                if heap[0] < number:
                    heapq.heappop(heap)
                    heapq.heappush(heap, number)
    print(heap[0])
                    
if __name__ == "__main__":
    best_practice()