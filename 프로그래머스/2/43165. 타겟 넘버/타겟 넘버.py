import sys
sys.setrecursionlimit(100000)

total_length = 0
answer = 0
def DFSRecursive(numbers, target, index, result):
    
    global total_length
    global answer
    
    if index == total_length:
        if result == target:
            answer += 1
        return 

    DFSRecursive(numbers, target, index + 1, result + numbers[index])
    DFSRecursive(numbers, target, index + 1, result - numbers[index])
    

def solution(numbers, target):
    global total_length
    global answer
    total_length = len(numbers)
    
    DFSRecursive(numbers,target,0,0)
    
    return answer