import sys
import copy
from collections import deque
sys.setrecursionlimit(100000)

visited = [[]]
total_row = 0
total_column = 0
answer = sys.maxsize
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def DFSRecursive(maps, row, column,depth,visited_map):
    
    global total_row, total_column
    global dx, dy
    global answer
    
    if row < 0 or row >= total_row or column < 0 or column >= total_column:
        return
    
    if visited_map[row][column] == 0:
        return
    
    if row == total_row -1 and column == total_column -1:
      
        if depth < answer:
            answer = depth
        return
    
    visited_map[row][column] = 0
    
    for i in range(4):
        new_row = row + dy[i]
        new_column = column + dx[i]
        DFSRecursive(maps, new_row, new_column, depth + 1,copy.deepcopy(visited_map))

        
def BFS(maps, row, column):
    
    queue = deque()
    visited = [[0 for _ in range(total_column)] for _ in range(total_row)]
    
    queue.append((row, column))
    
    while queue:
        
        row, column= queue.popleft()
        visited[row][column] = 1


        for i in range(4):
            
            checked_row = row + dy[i]
            checked_column = column + dx[i]
            
            if checked_row < 0 or checked_row >= total_row or checked_column < 0 or checked_column >= total_column:
                continue
            if visited[checked_row][checked_column] == 0 and maps[checked_row][checked_column] == 1:
                queue.append((checked_row, checked_column))
                maps[checked_row][checked_column] = maps[row][column] + 1                
            
            
    if visited[total_row- 1][total_column - 1]:
        answer = maps[total_row-1][total_column-1]
        return answer
    else :
        return -1

def solution(maps):
    
    global total_row, total_column, visited
    global answer
    
    total_row = len(maps)
    total_column = len(maps[0])
    
    visited= copy.deepcopy(maps)

    answer = BFS(maps, 0 ,0)
    
    return answer