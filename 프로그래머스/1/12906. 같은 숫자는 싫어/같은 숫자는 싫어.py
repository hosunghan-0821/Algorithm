from collections import deque
def solution(arr):
    answer = []
    
    answer.append(arr[0])
    previous_num = arr[0]
    for i in range(1, len(arr)):
        if arr[i] != previous_num:
            answer.append(arr[i])
            previous_num = arr[i]
    
    
    return answer