import math
def solution(r1, r2):
    answer = 0
    temp = 0
    
    for i in range(1, r2 + 1):
        if i > r1:
            minH = 0
        else :
            minH =math.ceil(math.sqrt(r1**2 - i**2))
        
        maxH = math.floor(math.sqrt(r2**2 - i **2))
        
        answer += maxH - minH + 1
        
    return answer * 4