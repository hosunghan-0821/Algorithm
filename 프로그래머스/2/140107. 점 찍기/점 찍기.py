import math


def solution(k, d):
    answer = 0

    
    for i in range(0, d + 1, k):
        y = math.pow(d, 2) - math.pow(i, 2)
        # print(math.sqrt(y))
        y = math.sqrt(y)
        answer += ((math.floor(y)) // k) + 1
        
    return answer