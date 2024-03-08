from collections import deque
def solution(priorities, location):
    
    answer = 0
    queue = deque()
    data = dict()
    
    for i in range(1, 10):
        data[i] = 0
        
    now_priority = 1
    for index, priority in enumerate(priorities):
        queue.append((priority,index))
        data[priority] = data[priority] + 1
        if now_priority < priority:
            now_priority = priority
            
    print(now_priority)
    while True:
        evaluate = queue.popleft()
        if evaluate[0] == now_priority:
            answer += 1
            data[now_priority] = data[now_priority] - 1
            if location == evaluate[1]:
                return answer
        else :
            print(evaluate)
            queue.append(evaluate)
       
        while True:
            if data[now_priority] != 0:
                break
            now_priority -= 1
    
    
    return answer