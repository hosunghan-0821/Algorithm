import sys
from collections import deque
sys.setrecursionlimit(10000000)

answer = sys.maxsize
def recursive(x,y,n,count):
    global answer
    
    data_list = deque()
    data_set = set()
    count = 1
    
    data_list.append((x + n, count))
    data_list.append((x * 2, count))
    data_list.append((x * 3, count))
    
    data_set.add(x + n)
    data_set.add(x * 2)
    data_set.add(x * 3)
    
    while data_list:
        
        data = data_list.popleft()
        if data[0] == y:
            answer = data[1]
            break
        elif data[0] > y:
            continue
        else :
            
            if data[0] + n not in data_set:
                data_list.append((data[0] + n,data[1] + 1))
                data_set.add(data[0] + n)
                
            if data[0] * 2 not in data_set:
                data_list.append((data[0] * 2,data[1] + 1))
                data_set.add(data[0] * 2)
                
            if data[0] * 3 not in data_set:
                data_list.append((data[0] * 3,data[1] + 1))
                data_set.add(data[0] * 3)
            


def solution(x, y, n):
    global answer
    
    if x==y:
        return 0
    recursive(x,y,n,0)
    
    if answer ==sys.maxsize:
        answer = -1
    return answer