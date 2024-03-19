def solution(targets):
    answer = 1
    targets.sort(key = lambda x: x[1])
    
    start = targets[0][0]
    end = targets[0][1]
    for target in targets:
        
        start = target[0]
        if start >= end:
            answer +=1
            end = target[1]
            
    return answer