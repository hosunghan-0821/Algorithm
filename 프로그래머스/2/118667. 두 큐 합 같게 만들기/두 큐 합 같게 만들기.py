# Greedy
from collections import deque

def solution(queue1, queue2):
    answer = 0
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    queue1_sum = sum(queue1)
    queue2_sum = sum(queue2)
    
    limit = len(queue1) * 3 - 3
    while True:
        if queue1_sum == queue2_sum:
            break
        if len(queue1) == 0 or len(queue2) == 0:
            answer = -1
            break 
        if answer >= limit:
            answer = -1
            break
            
        if queue1_sum > queue2_sum:
            data = queue1.popleft()
            queue2.append(data)
            
            queue2_sum += data
            queue1_sum -= data
            
            answer += 1
        else :
            data = queue2.popleft()
            queue1.append(data)
            
            queue1_sum += data
            queue2_sum -= data
            
            answer += 1
    
    return answer