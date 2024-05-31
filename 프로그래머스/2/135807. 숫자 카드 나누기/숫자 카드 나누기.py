import math

def GCDRecursive(a,b):
    
    if a > b:
        if b == 0 :
            return a
        if a % b == 0:
            return b
        else:
            return GCDRecursive(b , a % b)
    else:
        if a == 0 :
            return b
        if b % a == 0:
            return a
        else :
            return GCDRecursive(a, b % a)

def solution(arrayA, arrayB):
    
  
    gc, vc = 0,0
    
    for i in range(len(arrayA)):
        gc = GCDRecursive(gc,arrayA[i])

    for i in range(len(arrayB)):
        vc = GCDRecursive(vc,arrayB[i])

    
    for j in range(len(arrayA)):
        if arrayA[j] % vc == 0:
            vc = 1
        if arrayB[j] % gc == 0:
            gc = 1

    if gc == 1 and vc ==1:
        return 0
    else:
        return max(gc,vc)
        
    return answer