from collections import deque
def solution(order):
    answer = 0
    stack = []
    order = deque(order)
  
    start_num = 1
    while order:
        
        push_num = order.popleft()
       
        if push_num < start_num:
           
            if stack[-1] != push_num:
                break
            else:
                stack.pop(-1)
                answer +=1
                continue
    
        while True:
            if start_num != push_num:
                stack.append(start_num)
                start_num += 1
                continue

            else:
            
                answer +=1
                start_num += 1
                break
        
    return answer