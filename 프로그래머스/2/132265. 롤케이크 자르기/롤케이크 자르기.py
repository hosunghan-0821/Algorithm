def solution(topping):
    answer = 0
    
    bro1 = {}
    for t in topping:
        if t in bro1:
            bro1[t] += 1
        else:
            bro1[t] = 1

    bro2 = {}
    for t in topping:
        if len(bro2) == len(bro1):
            answer +=1
        if t not in bro2:
            bro2[t] = 1
        bro1[t] -= 1
        if bro1[t] == 0:
            bro1.pop(t)
    
    return answer