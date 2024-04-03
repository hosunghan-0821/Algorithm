import sys
sys.setrecursionlimit(100000)

def dfsRecursive(j,computers,visited):
    
    if visited[j] is True:
        return False
    
    visited[j] = True
    
    for index, node in enumerate(computers[j]):

        if node == 1:
            dfsRecursive(index, computers, visited)
    return True
    

def solution(n, computers):
    
    answer = 0
    visited = [False] * n 
    
    for i in range(n):
        for j in range(n):
            if (dfsRecursive(j,computers,visited)):
                answer += 1
                
            
    return answer