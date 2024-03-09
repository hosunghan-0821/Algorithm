import sys

sys.setrecursionlimit(10000)
def DFSRecursive(graph, i, visited):
    if visited[i]:
        return False
    
    visited[i] = True
    
    for linked_node in graph[i]:
        DFSRecursive(graph, linked_node, visited)
    
    return True
        
    

def solution(n, computers):
    answer = 0
    visited = [False] * n
    graph = [[] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if i == j :
                continue
            if computers[i][j] == 1:
                graph[i].append(j)
             
    for i in range(n):
        if DFSRecursive(graph, i, visited):
            answer += 1

    return answer