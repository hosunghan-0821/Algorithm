import copy
def solution(targets):
    answer = 0
    targets.sort(key = lambda x: x[1])
    
    end = 0
    
    for s, e in targets:
        
        if s >= end:
            answer += 1
            end = e
            
    return answer